package com.morecritters.mod.block;

import com.morecritters.mod.procedures.EvolutionTableOnBlockRightClickedProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EvolutionTableBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public EvolutionTableBlock() {
        super(Properties.of().sound(SoundType.WOOD).strength(1.0F).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
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
        return switch ((Direction)state.getValue(FACING)) {
            case NORTH -> Shapes.or(
                box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0),
                box(0.0, 11.0, 0.0, 16.0, 16.0, 4.0),
                box(0.0, 11.0, 12.0, 16.0, 16.0, 16.0),
                box(12.0, 11.0, 4.0, 16.0, 16.0, 12.0),
                box(0.0, 11.0, 4.0, 4.0, 16.0, 12.0)
            );
            case EAST -> Shapes.or(
                box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0),
                box(12.0, 11.0, 0.0, 16.0, 16.0, 16.0),
                box(0.0, 11.0, 0.0, 4.0, 16.0, 16.0),
                box(4.0, 11.0, 12.0, 12.0, 16.0, 16.0),
                box(4.0, 11.0, 0.0, 12.0, 16.0, 4.0)
            );
            case WEST -> Shapes.or(
                box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0),
                box(0.0, 11.0, 0.0, 4.0, 16.0, 16.0),
                box(12.0, 11.0, 0.0, 16.0, 16.0, 16.0),
                box(4.0, 11.0, 0.0, 12.0, 16.0, 4.0),
                box(4.0, 11.0, 12.0, 12.0, 16.0, 16.0)
            );
            default -> Shapes.or(
                box(0.0, 0.0, 0.0, 16.0, 11.0, 16.0),
                box(0.0, 11.0, 12.0, 16.0, 16.0, 16.0),
                box(0.0, 11.0, 0.0, 16.0, 16.0, 4.0),
                box(0.0, 11.0, 4.0, 4.0, 16.0, 12.0),
                box(12.0, 11.0, 4.0, 16.0, 16.0, 12.0)
            );
        };
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
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
    public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
        super.useWithoutItem(blockstate, world, pos, entity, hit);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        double hitX = hit.getLocation().x;
        double hitY = hit.getLocation().y;
        double hitZ = hit.getLocation().z;
        Direction direction = hit.getDirection();
        EvolutionTableOnBlockRightClickedProcedure.execute(world, x, y, z, entity);
        return InteractionResult.SUCCESS;
    }
}
