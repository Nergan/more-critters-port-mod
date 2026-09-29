package com.morecritters.mod.network;

import com.morecritters.mod.MoreCritters;
import java.util.function.Supplier;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * Player variables of the original mod. Forge capabilities became a NeoForge data attachment;
 * the original copied every variable on respawn, which is what {@code copyOnDeath()} does.
 */
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MoreCrittersModVariables {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, MoreCritters.MODID);
    public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register(
        "player_variables", () -> AttachmentType.serializable(PlayerVariables::new).copyOnDeath().build()
    );

    @SubscribeEvent
    public static void registerMessages(RegisterPayloadHandlersEvent event) {
        event.registrar("1").playToClient(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
    }

    @EventBusSubscriber
    public static class EventBusVariableHandlers {
        @SubscribeEvent
        public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
            if (event.getEntity() instanceof ServerPlayer player) {
                player.getData(PLAYER_VARIABLES).syncPlayerVariables(player);
            }
        }

        @SubscribeEvent
        public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
            if (event.getEntity() instanceof ServerPlayer player) {
                player.getData(PLAYER_VARIABLES).syncPlayerVariables(player);
            }
        }

        @SubscribeEvent
        public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
            if (event.getEntity() instanceof ServerPlayer player) {
                player.getData(PLAYER_VARIABLES).syncPlayerVariables(player);
            }
        }
    }

    public static class PlayerVariables implements INBTSerializable<CompoundTag> {
        public boolean HadCubefrog = false;
        public boolean HadPlainswyrm = false;
        public boolean HadDunger = false;
        public boolean HadSnek = false;
        public boolean HadExpy = false;
        public boolean HadScowl = false;
        public boolean HadRollball = false;
        public boolean HadOpalcrab = false;
        public boolean HadMothkid = false;
        public boolean HadGillmunch = false;
        public boolean HadDominc = false;
        public boolean HadOlmer = false;
        public boolean HadStalk = false;
        public boolean HadFlarg = false;
        public boolean HadPiranheed = false;
        public boolean HadMangotrice = false;
        public boolean HadFresnoid = false;

        public void syncPlayerVariables(Entity entity) {
            if (entity instanceof ServerPlayer serverPlayer) {
                PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
            }
        }

        @Override
        public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
            CompoundTag nbt = new CompoundTag();
            nbt.putBoolean("HadCubefrog", this.HadCubefrog);
            nbt.putBoolean("HadPlainswyrm", this.HadPlainswyrm);
            nbt.putBoolean("HadDunger", this.HadDunger);
            nbt.putBoolean("HadSnek", this.HadSnek);
            nbt.putBoolean("HadExpy", this.HadExpy);
            nbt.putBoolean("HadScowl", this.HadScowl);
            nbt.putBoolean("HadRollball", this.HadRollball);
            nbt.putBoolean("HadOpalcrab", this.HadOpalcrab);
            nbt.putBoolean("HadMothkid", this.HadMothkid);
            nbt.putBoolean("HadGillmunch", this.HadGillmunch);
            nbt.putBoolean("HadDominc", this.HadDominc);
            nbt.putBoolean("HadOlmer", this.HadOlmer);
            nbt.putBoolean("HadStalk", this.HadStalk);
            nbt.putBoolean("HadFlarg", this.HadFlarg);
            nbt.putBoolean("HadPiranheed", this.HadPiranheed);
            nbt.putBoolean("HadMangotrice", this.HadMangotrice);
            nbt.putBoolean("HadFresnoid", this.HadFresnoid);
            return nbt;
        }

        @Override
        public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
            this.HadCubefrog = nbt.getBoolean("HadCubefrog");
            this.HadPlainswyrm = nbt.getBoolean("HadPlainswyrm");
            this.HadDunger = nbt.getBoolean("HadDunger");
            this.HadSnek = nbt.getBoolean("HadSnek");
            this.HadExpy = nbt.getBoolean("HadExpy");
            this.HadScowl = nbt.getBoolean("HadScowl");
            this.HadRollball = nbt.getBoolean("HadRollball");
            this.HadOpalcrab = nbt.getBoolean("HadOpalcrab");
            this.HadMothkid = nbt.getBoolean("HadMothkid");
            this.HadGillmunch = nbt.getBoolean("HadGillmunch");
            this.HadDominc = nbt.getBoolean("HadDominc");
            this.HadOlmer = nbt.getBoolean("HadOlmer");
            this.HadStalk = nbt.getBoolean("HadStalk");
            this.HadFlarg = nbt.getBoolean("HadFlarg");
            this.HadPiranheed = nbt.getBoolean("HadPiranheed");
            this.HadMangotrice = nbt.getBoolean("HadMangotrice");
            this.HadFresnoid = nbt.getBoolean("HadFresnoid");
        }
    }

    public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
        public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MoreCritters.MODID, "player_variables_sync"));
        public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of(
            (buffer, message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())),
            buffer -> {
                PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
                CompoundTag tag = buffer.readNbt();
                if (tag != null) {
                    message.data().deserializeNBT(buffer.registryAccess(), tag);
                }
                return message;
            }
        );

        @Override
        public Type<PlayerVariablesSyncMessage> type() {
            return TYPE;
        }

        public static void handleData(PlayerVariablesSyncMessage message, IPayloadContext context) {
            if (context.flow() == PacketFlow.CLIENTBOUND) {
                context.enqueueWork(() -> {
                    HolderLookup.Provider registries = context.player().registryAccess();
                    context.player().getData(PLAYER_VARIABLES).deserializeNBT(registries, message.data().serializeNBT(registries));
                });
            }
        }
    }
}
