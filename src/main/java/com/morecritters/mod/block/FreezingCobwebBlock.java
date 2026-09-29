package com.morecritters.mod.block;

import com.morecritters.mod.procedures.FreezingCobwebEntityCollidesInTheBlockProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FreezingCobwebBlock extends Block {
    public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 2);

    public FreezingCobwebBlock() {
        super(Properties.of().sound(SoundType.STONE).strength(0.5F, 4.0F).lightLevel(s -> (new Object() {
            public int getLightLevel() {
                if (s.getValue(FreezingCobwebBlock.BLOCKSTATE) == 1) {
                    return 0;
                } else {
                    return s.getValue(FreezingCobwebBlock.BLOCKSTATE) == 2 ? 0 : 0;
                }
            }
        }).getLightLevel()).noCollission().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(BLOCKSTATE) == 1) {
            return Shapes.empty();
        } else {
            return state.getValue(BLOCKSTATE) == 2 ? Shapes.empty() : box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        }
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BLOCKSTATE);
    }

    @Override
    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.entityInside(blockstate, world, pos, entity);
        FreezingCobwebEntityCollidesInTheBlockProcedure.execute(entity);
    }
}
