package com.morecritters.mod.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import com.morecritters.mod.fluid.types.AvoiderBucketFluidType;
import com.morecritters.mod.fluid.types.AvoiderFryBucketFluidType;
import com.morecritters.mod.fluid.types.BlackIropodBucketFluidType;
import com.morecritters.mod.fluid.types.BlubberfishBucketFluidType;
import com.morecritters.mod.fluid.types.BlubberfishFryBucketFluidType;
import com.morecritters.mod.fluid.types.IropodBucketFluidType;
import com.morecritters.mod.fluid.types.LargeBombJellyFluidType;
import com.morecritters.mod.fluid.types.MediumBombJellyFluidType;
import com.morecritters.mod.fluid.types.RamchuBucketFluidType;
import com.morecritters.mod.fluid.types.RamchuBucketNoOilFluidType;
import com.morecritters.mod.fluid.types.RamchuBucketNoShellFluidType;
import com.morecritters.mod.fluid.types.RamchuFryBucketFluidType;
import com.morecritters.mod.fluid.types.SmallBombJellyFluidType;
import com.morecritters.mod.fluid.types.StinarpBucketFluidType;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class MoreCrittersModFluidTypes {
    public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, "more_critters");
    public static final DeferredHolder<FluidType, FluidType> SMALL_BOMB_JELLY_TYPE = REGISTRY.register("small_bomb_jelly", () -> new SmallBombJellyFluidType());
    public static final DeferredHolder<FluidType, FluidType> MEDIUM_BOMB_JELLY_TYPE = REGISTRY.register("medium_bomb_jelly", () -> new MediumBombJellyFluidType());
    public static final DeferredHolder<FluidType, FluidType> LARGE_BOMB_JELLY_TYPE = REGISTRY.register("large_bomb_jelly", () -> new LargeBombJellyFluidType());
    public static final DeferredHolder<FluidType, FluidType> AVOIDER_BUCKET_TYPE = REGISTRY.register("avoider_bucket", () -> new AvoiderBucketFluidType());
    public static final DeferredHolder<FluidType, FluidType> IROPOD_BUCKET_TYPE = REGISTRY.register("iropod_bucket", () -> new IropodBucketFluidType());
    public static final DeferredHolder<FluidType, FluidType> BLACK_IROPOD_BUCKET_TYPE = REGISTRY.register("black_iropod_bucket", () -> new BlackIropodBucketFluidType());
    public static final DeferredHolder<FluidType, FluidType> BLUBBERFISH_BUCKET_TYPE = REGISTRY.register("blubberfish_bucket", () -> new BlubberfishBucketFluidType());
    public static final DeferredHolder<FluidType, FluidType> BLUBBERFISH_FRY_BUCKET_TYPE = REGISTRY.register(
        "blubberfish_fry_bucket", () -> new BlubberfishFryBucketFluidType()
    );
    public static final DeferredHolder<FluidType, FluidType> AVOIDER_FRY_BUCKET_TYPE = REGISTRY.register("avoider_fry_bucket", () -> new AvoiderFryBucketFluidType());
    public static final DeferredHolder<FluidType, FluidType> STINARP_BUCKET_TYPE = REGISTRY.register("stinarp_bucket", () -> new StinarpBucketFluidType());
    public static final DeferredHolder<FluidType, FluidType> RAMCHU_FRY_BUCKET_TYPE = REGISTRY.register("ramchu_fry_bucket", () -> new RamchuFryBucketFluidType());
    public static final DeferredHolder<FluidType, FluidType> RAMCHU_BUCKET_TYPE = REGISTRY.register("ramchu_bucket", () -> new RamchuBucketFluidType());
    public static final DeferredHolder<FluidType, FluidType> RAMCHU_BUCKET_NO_SHELL_TYPE = REGISTRY.register(
        "ramchu_bucket_no_shell", () -> new RamchuBucketNoShellFluidType()
    );
    public static final DeferredHolder<FluidType, FluidType> RAMCHU_BUCKET_NO_OIL_TYPE = REGISTRY.register("ramchu_bucket_no_oil", () -> new RamchuBucketNoOilFluidType());
}
