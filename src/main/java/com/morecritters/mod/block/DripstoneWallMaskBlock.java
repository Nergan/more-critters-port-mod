package com.morecritters.mod.block;

import com.morecritters.mod.procedures.DripstoneWallMaskBlockValidPlacementConditionProcedure;
import com.morecritters.mod.procedures.DripstoneWallMaskOnBlockRightClickedProcedure;
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
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DripstoneWallMaskBlock extends Block implements SimpleWaterloggedBlock {
    public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 10);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public DripstoneWallMaskBlock() {
        super(Properties.of().sound(SoundType.DRIPSTONE_BLOCK).instabreak().lightLevel(s -> (new Object() {
            public int getLightLevel() {
                if (s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 1) {
                    return 0;
                } else if (s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 2) {
                    return 0;
                } else if (s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 3) {
                    return 0;
                } else if (s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 4) {
                    return 0;
                } else if (s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 5) {
                    return 0;
                } else if (s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 6) {
                    return 0;
                } else if (s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 7) {
                    return 0;
                } else if (s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 8) {
                    return 0;
                } else if (s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 9) {
                    return 0;
                } else {
                    return s.getValue(DripstoneWallMaskBlock.BLOCKSTATE) == 10 ? 0 : 0;
                }
            }
        }).getLightLevel()).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
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
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 2) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 3) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 4) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 5) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 6) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 7) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 8) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 9) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else if (state.getValue(BLOCKSTATE) == 10) {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        } else {
            return switch ((Direction)state.getValue(FACING)) {
                case NORTH -> box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
                case EAST -> box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
                case WEST -> box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
                default -> box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
            };
        }
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, WATERLOGGED, BLOCKSTATE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
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
            return DripstoneWallMaskBlockValidPlacementConditionProcedure.execute(world, x, y, z, blockstate);
        } else {
            return super.canSurvive(blockstate, worldIn, pos);
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return !state.canSurvive(world, currentPos)
            ? Blocks.AIR.defaultBlockState()
            : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        DripstoneWallMaskOnBlockRightClickedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }
}
