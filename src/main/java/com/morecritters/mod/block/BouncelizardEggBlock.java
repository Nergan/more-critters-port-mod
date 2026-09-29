package com.morecritters.mod.block;

import net.minecraft.world.level.LevelReader;
import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.block.entity.BouncelizardEggBlockEntity;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.procedures.SlablizardEggBlockAddedProcedure;
import com.morecritters.mod.procedures.SlablizardEggBreak1Procedure;
import com.morecritters.mod.procedures.SlablizardEggOnBlockRightClickedProcedure;
import com.morecritters.mod.procedures.SlablizardEggOnTickUpdateProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.util.DeferredSoundType;

public class BouncelizardEggBlock extends Block implements EntityBlock {
    public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 4);

    public BouncelizardEggBlock() {
        super(
            Properties.of()
                .sound(
                    new DeferredSoundType(
                        1.0F,
                        1.0F,
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.turtle.egg_break")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.step")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.place")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.hit")),
                        () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.stone.fall"))
                    )
                )
                .strength(0.5F)
                .lightLevel(s -> (new Object() {
                    public int getLightLevel() {
                        if (s.getValue(BouncelizardEggBlock.BLOCKSTATE) == 1) {
                            return 0;
                        } else if (s.getValue(BouncelizardEggBlock.BLOCKSTATE) == 2) {
                            return 0;
                        } else if (s.getValue(BouncelizardEggBlock.BLOCKSTATE) == 3) {
                            return 0;
                        } else {
                            return s.getValue(BouncelizardEggBlock.BLOCKSTATE) == 4 ? 0 : 0;
                        }
                    }
                }).getLightLevel())
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false)
        );
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
            return box(9.25, 0.0, 9.5, 15.25, 4.0, 15.5);
        } else if (state.getValue(BLOCKSTATE) == 2) {
            return Shapes.or(box(1.0, 0.0, 9.0, 7.0, 3.0, 15.0), box(9.25, 0.0, 9.5, 15.25, 4.0, 15.5));
        } else if (state.getValue(BLOCKSTATE) == 3) {
            return Shapes.or(box(1.0, 0.0, 9.0, 7.0, 3.0, 15.0), box(1.0, 0.0, 0.5, 7.0, 4.0, 6.5), box(9.25, 0.0, 9.5, 15.25, 4.0, 15.5));
        } else {
            return state.getValue(BLOCKSTATE) == 4
                ? Shapes.or(
                    box(8.0, 0.0, 2.0, 14.0, 3.0, 8.0),
                    box(1.0, 0.0, 9.0, 7.0, 3.0, 15.0),
                    box(1.0, 0.0, 0.5, 7.0, 4.0, 6.5),
                    box(9.25, 0.0, 9.5, 15.25, 4.0, 15.5)
                )
                : box(9.25, 0.0, 9.5, 15.25, 4.0, 15.5);
        }
    }

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BLOCKSTATE);
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, LevelReader world, BlockPos pos, Player player) {
        return new ItemStack(MoreCrittersModBlocks.BOUNCELIZARD_EGG.get());
    }

    @Override
    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        world.scheduleTick(pos, this, 1);
        SlablizardEggBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        SlablizardEggOnTickUpdateProcedure.execute(world, x, y, z, blockstate);
        world.scheduleTick(pos, this, 1);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
        boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
        SlablizardEggBreak1Procedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate, entity);
        return retval;
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
        SlablizardEggOnBlockRightClickedProcedure.execute(world, x, y, z, blockstate, entity);
        return InteractionResult.SUCCESS;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        return worldIn.getBlockEntity(pos) instanceof MenuProvider menuProvider ? menuProvider : null;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BouncelizardEggBlockEntity(pos, state);
    }

    @Override
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
        super.triggerEvent(state, world, pos, eventID, eventParam);
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            if (world.getBlockEntity(pos) instanceof BouncelizardEggBlockEntity be) {
                Containers.dropContents(world, pos, be);
                world.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
        return world.getBlockEntity(pos) instanceof BouncelizardEggBlockEntity be ? AbstractContainerMenu.getRedstoneSignalFromContainer(be) : 0;
    }
}
