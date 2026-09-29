package com.morecritters.mod.fluid;

import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModFluidTypes;
import com.morecritters.mod.init.MoreCrittersModFluids;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid.Properties;

public abstract class StinarpBucketFluid extends BaseFlowingFluid {
    public static final Properties PROPERTIES = new Properties(
            () -> MoreCrittersModFluidTypes.STINARP_BUCKET_TYPE.get(),
            () -> MoreCrittersModFluids.STINARP_BUCKET.get(),
            () -> MoreCrittersModFluids.FLOWING_STINARP_BUCKET.get()
        )
        .explosionResistance(100.0F)
        .bucket(() -> MoreCrittersModItems.STINARP_BUCKET_BUCKET.get())
        .block(() -> (LiquidBlock)MoreCrittersModBlocks.STINARP_BUCKET.get());

    private StinarpBucketFluid() {
        super(PROPERTIES);
    }

    public static class Flowing extends StinarpBucketFluid {
        protected void createFluidStateDefinition(Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source extends StinarpBucketFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
