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

public abstract class BlubberfishBucketFluid extends BaseFlowingFluid {
    public static final Properties PROPERTIES = new Properties(
            () -> MoreCrittersModFluidTypes.BLUBBERFISH_BUCKET_TYPE.get(),
            () -> MoreCrittersModFluids.BLUBBERFISH_BUCKET.get(),
            () -> MoreCrittersModFluids.FLOWING_BLUBBERFISH_BUCKET.get()
        )
        .explosionResistance(100.0F)
        .bucket(() -> MoreCrittersModItems.BLUBBERFISH_BUCKET_BUCKET.get())
        .block(() -> (LiquidBlock)MoreCrittersModBlocks.BLUBBERFISH_BUCKET.get());

    private BlubberfishBucketFluid() {
        super(PROPERTIES);
    }

    public static class Flowing extends BlubberfishBucketFluid {
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

    public static class Source extends BlubberfishBucketFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }
}
