package com.morecritters.mod.block;

import com.morecritters.mod.procedures.AsdasdProcedure;
import com.morecritters.mod.procedures.MoriPlaceProcedure;
import com.morecritters.mod.procedures.VitaShroomBoneMealSuccessConditionProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.OffsetType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class MoriShroomBlock extends FlowerBlock implements BonemealableBlock {
    public MoriShroomBlock() {
        super(MobEffects.MOVEMENT_SPEED, 5.0F,
            Properties.of()
                .mapColor(MapColor.PLANT)
                .sound(SoundType.GRASS)
                .instabreak()
                .noCollission()
                .offsetType(OffsetType.XZ)
                .pushReaction(PushReaction.DESTROY)
        );
    }


    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
        boolean additionalCondition = true;
        if (worldIn instanceof LevelAccessor world) {
            int x = pos.getX();
            int y = pos.getY() + 1;
            int z = pos.getZ();
            BlockState blockstate = world.getBlockState(pos.above());
            additionalCondition = MoriPlaceProcedure.execute(world, x, y, z);
        }

        return additionalCondition;
    }

    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState groundState = worldIn.getBlockState(blockpos);
        return this.mayPlaceOn(groundState, worldIn, blockpos);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
        return VitaShroomBoneMealSuccessConditionProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
        AsdasdProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }
}
