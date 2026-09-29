package com.morecritters.mod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.LevelReader;
import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.block.entity.TreasureChestOpenBlockEntity;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.procedures.TreasureChestOpenOnTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.util.DeferredSoundType;

public class TreasureChestOpenBlock extends FallingBlock implements EntityBlock {
    public static final MapCodec<TreasureChestOpenBlock> CODEC = simpleCodec(properties -> new TreasureChestOpenBlock());

    @Override
    public MapCodec<TreasureChestOpenBlock> codec() {
        return CODEC;
    }

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public TreasureChestOpenBlock() {
        super(
            Properties.of()
                .sound(
                    new DeferredSoundType(
                        1.0F,
                        1.0F,
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.break")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.step")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.place")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.treasure_chest.breaking")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.fall"))
                    )
                )
                .strength(-1.0F, 3600000.0F)
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false)
        );
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
            case NORTH -> box(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
            case EAST -> box(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
            case WEST -> box(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
            default -> box(1.0, 0.0, 1.0, 15.0, 10.0, 15.0);
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
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader world, BlockPos pos, Player player) {
        return new ItemStack(MoreCrittersModBlocks.TREASURE_CHEST.get());
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        world.scheduleTick(pos, this, 1);
    }

    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        TreasureChestOpenOnTickUpdateProcedure.execute(world, x, y, z);
        world.scheduleTick(pos, this, 1);
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TreasureChestOpenBlockEntity(pos, state);
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
    }
}
