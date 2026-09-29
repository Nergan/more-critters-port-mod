package com.morecritters.mod.block;

import com.morecritters.mod.procedures.ConfettiTrailBlockAddedProcedure;
import com.morecritters.mod.procedures.ConfettiTrailBlockValidPlacementConditionProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ConfettiTrailBlock extends Block {
    public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 2);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public ConfettiTrailBlock() {
        super(Properties.of().sound(SoundType.AZALEA).instabreak().lightLevel(s -> (new Object() {
            public int getLightLevel() {
                if (s.getValue(ConfettiTrailBlock.BLOCKSTATE) == 1) {
                    return 0;
                } else {
                    return s.getValue(ConfettiTrailBlock.BLOCKSTATE) == 2 ? 0 : 0;
                }
            }
        }).getLightLevel()).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
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
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
                case EAST -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
                case WEST -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
                default -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 2) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
                case EAST -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
                case WEST -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
                default -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
            };
        } else {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
                case EAST -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
                case WEST -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
                default -> box(0.0, 0.1, 0.0, 16.0, 1.0, 16.0);
            };
        }
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, BLOCKSTATE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
        if (worldIn instanceof LevelAccessor world) {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return ConfettiTrailBlockValidPlacementConditionProcedure.execute(world, x, y, z);
        } else {
            return super.canSurvive(blockstate, worldIn, pos);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        return !state.canSurvive(world, currentPos)
            ? Blocks.AIR.defaultBlockState()
            : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        ConfettiTrailBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }
}
