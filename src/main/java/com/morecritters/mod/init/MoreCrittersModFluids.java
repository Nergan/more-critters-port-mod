package com.morecritters.mod.init;

import net.minecraft.core.registries.Registries;
import com.morecritters.mod.fluid.AvoiderBucketFluid;
import com.morecritters.mod.fluid.AvoiderFryBucketFluid;
import com.morecritters.mod.fluid.BlackIropodBucketFluid;
import com.morecritters.mod.fluid.BlubberfishBucketFluid;
import com.morecritters.mod.fluid.BlubberfishFryBucketFluid;
import com.morecritters.mod.fluid.IropodBucketFluid;
import com.morecritters.mod.fluid.LargeBombJellyFluid;
import com.morecritters.mod.fluid.MediumBombJellyFluid;
import com.morecritters.mod.fluid.RamchuBucketFluid;
import com.morecritters.mod.fluid.RamchuBucketNoOilFluid;
import com.morecritters.mod.fluid.RamchuBucketNoShellFluid;
import com.morecritters.mod.fluid.RamchuFryBucketFluid;
import com.morecritters.mod.fluid.SmallBombJellyFluid;
import com.morecritters.mod.fluid.StinarpBucketFluid;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredHolder;

public class MoreCrittersModFluids {
    public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(Registries.FLUID, "more_critters");
    public static final DeferredHolder<Fluid, FlowingFluid> SMALL_BOMB_JELLY = REGISTRY.register("small_bomb_jelly", () -> new SmallBombJellyFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_SMALL_BOMB_JELLY = REGISTRY.register(
        "flowing_small_bomb_jelly", () -> new SmallBombJellyFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> MEDIUM_BOMB_JELLY = REGISTRY.register("medium_bomb_jelly", () -> new MediumBombJellyFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MEDIUM_BOMB_JELLY = REGISTRY.register(
        "flowing_medium_bomb_jelly", () -> new MediumBombJellyFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> LARGE_BOMB_JELLY = REGISTRY.register("large_bomb_jelly", () -> new LargeBombJellyFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LARGE_BOMB_JELLY = REGISTRY.register(
        "flowing_large_bomb_jelly", () -> new LargeBombJellyFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> AVOIDER_BUCKET = REGISTRY.register("avoider_bucket", () -> new AvoiderBucketFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_AVOIDER_BUCKET = REGISTRY.register(
        "flowing_avoider_bucket", () -> new AvoiderBucketFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> IROPOD_BUCKET = REGISTRY.register("iropod_bucket", () -> new IropodBucketFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_IROPOD_BUCKET = REGISTRY.register("flowing_iropod_bucket", () -> new IropodBucketFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> BLACK_IROPOD_BUCKET = REGISTRY.register("black_iropod_bucket", () -> new BlackIropodBucketFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BLACK_IROPOD_BUCKET = REGISTRY.register(
        "flowing_black_iropod_bucket", () -> new BlackIropodBucketFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> BLUBBERFISH_BUCKET = REGISTRY.register("blubberfish_bucket", () -> new BlubberfishBucketFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BLUBBERFISH_BUCKET = REGISTRY.register(
        "flowing_blubberfish_bucket", () -> new BlubberfishBucketFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> BLUBBERFISH_FRY_BUCKET = REGISTRY.register(
        "blubberfish_fry_bucket", () -> new BlubberfishFryBucketFluid.Source()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BLUBBERFISH_FRY_BUCKET = REGISTRY.register(
        "flowing_blubberfish_fry_bucket", () -> new BlubberfishFryBucketFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> AVOIDER_FRY_BUCKET = REGISTRY.register("avoider_fry_bucket", () -> new AvoiderFryBucketFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_AVOIDER_FRY_BUCKET = REGISTRY.register(
        "flowing_avoider_fry_bucket", () -> new AvoiderFryBucketFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> STINARP_BUCKET = REGISTRY.register("stinarp_bucket", () -> new StinarpBucketFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_STINARP_BUCKET = REGISTRY.register(
        "flowing_stinarp_bucket", () -> new StinarpBucketFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> RAMCHU_FRY_BUCKET = REGISTRY.register("ramchu_fry_bucket", () -> new RamchuFryBucketFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_RAMCHU_FRY_BUCKET = REGISTRY.register(
        "flowing_ramchu_fry_bucket", () -> new RamchuFryBucketFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> RAMCHU_BUCKET = REGISTRY.register("ramchu_bucket", () -> new RamchuBucketFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_RAMCHU_BUCKET = REGISTRY.register("flowing_ramchu_bucket", () -> new RamchuBucketFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> RAMCHU_BUCKET_NO_SHELL = REGISTRY.register(
        "ramchu_bucket_no_shell", () -> new RamchuBucketNoShellFluid.Source()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_RAMCHU_BUCKET_NO_SHELL = REGISTRY.register(
        "flowing_ramchu_bucket_no_shell", () -> new RamchuBucketNoShellFluid.Flowing()
    );
    public static final DeferredHolder<Fluid, FlowingFluid> RAMCHU_BUCKET_NO_OIL = REGISTRY.register("ramchu_bucket_no_oil", () -> new RamchuBucketNoOilFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_RAMCHU_BUCKET_NO_OIL = REGISTRY.register(
        "flowing_ramchu_bucket_no_oil", () -> new RamchuBucketNoOilFluid.Flowing()
    );

    @EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
    public static class FluidsClientSideHandler {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.SMALL_BOMB_JELLY.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_SMALL_BOMB_JELLY.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.MEDIUM_BOMB_JELLY.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_MEDIUM_BOMB_JELLY.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.LARGE_BOMB_JELLY.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_LARGE_BOMB_JELLY.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.AVOIDER_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_AVOIDER_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.IROPOD_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_IROPOD_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.BLACK_IROPOD_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_BLACK_IROPOD_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.BLUBBERFISH_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_BLUBBERFISH_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.BLUBBERFISH_FRY_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_BLUBBERFISH_FRY_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.AVOIDER_FRY_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_AVOIDER_FRY_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.STINARP_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_STINARP_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.RAMCHU_FRY_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_RAMCHU_FRY_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.RAMCHU_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_RAMCHU_BUCKET.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.RAMCHU_BUCKET_NO_SHELL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_RAMCHU_BUCKET_NO_SHELL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.RAMCHU_BUCKET_NO_OIL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(MoreCrittersModFluids.FLOWING_RAMCHU_BUCKET_NO_OIL.get(), RenderType.translucent());
        }
    }
}
