// Публикует уже собранные jar на McnCDN.
// Аутентификация: MCNS_WORKER_ID + MCNS_WORKER_KEY, либо MCNS_WORKER_TOKEN.
// Версия auto — метка времени: номер на CDN нельзя переиспользовать,
// а mod_version между пушами часто не меняется.
import { createHash, createPrivateKey, randomBytes, sign } from "node:crypto";
import { basename, readFileSync } from "node:fs";

const base = (process.env.MCNS_CDN_URL ?? "https://cdn.mikchan.net").replace(/\/$/, "");
const token = process.env.MCNS_WORKER_TOKEN || "";
const worker = process.env.MCNS_WORKER_ID || "";

function pemFromEnv() {
  let pem = process.env.MCNS_WORKER_KEY ?? "";
  pem = pem.replace(/^\uFEFF/, "").trim();
  if (!pem.includes("\n") && pem.includes("\\n")) {
    pem = pem.replace(/\\n/g, "\n");
  }
  if (!pem.includes("BEGIN")) {
    throw new Error("MCNS_WORKER_KEY is empty or not a PEM private key");
  }
  return pem.endsWith("\n") ? pem : `${pem}\n`;
}

if (!token && (!worker || !process.env.MCNS_WORKER_KEY)) {
  throw new Error("Set MCNS_WORKER_ID and MCNS_WORKER_KEY, or MCNS_WORKER_TOKEN");
}

const privateKey = token ? null : createPrivateKey(pemFromEnv());
const sha = (data) => createHash("sha256").update(data).digest("hex");
const signText = (text) =>
  sign(null, Buffer.from(text), privateKey).toString("base64url");

function authorize(method, path, bodyHash) {
  if (token) return `Bearer ${token}`;
  const ts = Math.floor(Date.now() / 1000);
  const nonce = randomBytes(16).toString("base64url");
  const sig = signText(
    ["MCNS-CDN-REQUEST-V1", method, path, String(ts), nonce, worker, bodyHash].join("\n"),
  );
  return `MCNS-Ed25519 keyId="${worker}",ts="${ts}",nonce="${nonce}",sig="${sig}"`;
}

function artifactSignature(pkg, version, slot, file) {
  if (token) return {};
  const statement = [
    "MCNS-CDN-ARTIFACT-V1",
    pkg,
    version,
    slot,
    sha(file),
    String(file.length),
  ].join("\n");
  return { "x-artifact-signature": signText(statement) };
}

async function call(method, path, { json, raw, headers = {} } = {}) {
  const body = raw ?? Buffer.from(json === undefined ? "" : JSON.stringify(json));
  const res = await fetch(base + path, {
    method,
    headers: {
      authorization: authorize(method, path, sha(raw ? "" : body)),
      ...(json === undefined ? {} : { "content-type": "application/json" }),
      ...headers,
    },
    body: body.length ? body : undefined,
  });
  if (!res.ok) {
    const text = await res.text();
    const error = new Error(`${method} ${path}: ${res.status} ${text.slice(0, 500)}`);
    error.status = res.status;
    error.body = text;
    throw error;
  }
  return res;
}

function nextVersion() {
  const ms = Date.now();
  return `${Math.floor(ms / 1000)}.${ms % 1000}.0`;
}

function sleep(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

async function main() {
  const [pkg, versionArg, ...pairs] = process.argv.slice(2);
  if (!pkg || !versionArg || pairs.length === 0) {
    throw new Error(
      "usage: node scripts/mcns-release.mjs <package> <version|auto> slot=path ...",
    );
  }

  const files = Object.fromEntries(
    pairs.map((pair) => {
      const index = pair.indexOf("=");
      if (index <= 0) throw new Error(`expected slot=path, got ${pair}`);
      return [pair.slice(0, index), pair.slice(index + 1)];
    }),
  );

  const layout = (await (await call("GET", `/v1/packages/${pkg}`)).json()).layout;
  const slots = Object.keys(layout);
  const missing = slots.filter((slot) => !(slot in files));
  const extra = Object.keys(files).filter((slot) => !slots.includes(slot));
  if (missing.length || extra.length) {
    throw new Error(
      `layout mismatch, missing: ${missing.join(", ") || "-"}, extra: ${extra.join(", ") || "-"}`,
    );
  }

  const description = [
    process.env.MCNS_MOD_VERSION ? `mod ${process.env.MCNS_MOD_VERSION}` : null,
    process.env.MCNS_COMMIT ? process.env.MCNS_COMMIT.slice(0, 12) : null,
  ]
    .filter(Boolean)
    .join(" ");
  const meta = {
    modVersion: process.env.MCNS_MOD_VERSION || null,
    commit: process.env.MCNS_COMMIT || null,
    ref: process.env.MCNS_REF || null,
    files: Object.fromEntries(
      Object.entries(files).map(([slot, path]) => [slot, basename(path)]),
    ),
  };

  let version = versionArg;
  let created = false;
  let published = false;
  try {
    if (versionArg === "auto") {
      for (let attempt = 1; attempt <= 5; attempt++) {
        version = nextVersion();
        try {
          await call("POST", `/v1/packages/${pkg}/versions`, {
            json: { version, description, meta },
          });
          created = true;
          break;
        } catch (error) {
          const retry = error.status === 409 && /version|floor/i.test(error.body || "");
          if (!retry || attempt === 5) throw error;
          await sleep(20);
        }
      }
    } else {
      await call("POST", `/v1/packages/${pkg}/versions`, {
        json: { version, description, meta },
      });
      created = true;
    }

    for (const slot of slots) {
      const file = readFileSync(files[slot]);
      const target = `/v1/packages/${pkg}/versions/${version}/artifacts/${slot}`;
      await call("PUT", target, {
        raw: file,
        headers: artifactSignature(pkg, version, slot, file),
      });
    }

    await call("POST", `/v1/packages/${pkg}/versions/${version}/publish`);
    published = true;
    console.log(`published ${pkg}@${version}`);
    console.log(`${base}/v1/packages/${pkg}/latest`);
  } catch (error) {
    if (created && !published) {
      try {
        await call("DELETE", `/v1/packages/${pkg}/versions/${version}`);
        console.error(`removed draft ${pkg}@${version}`);
      } catch (cleanup) {
        console.error(`draft ${pkg}@${version} was left in place: ${cleanup.message}`);
      }
    }
    throw error;
  }
}

main().catch((error) => {
  console.error(error.message);
  process.exit(1);
});
