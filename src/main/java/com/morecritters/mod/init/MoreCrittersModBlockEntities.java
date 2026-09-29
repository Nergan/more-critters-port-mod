package com.morecritters.mod.init;

import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.minecraft.core.registries.Registries;
import com.morecritters.mod.block.entity.BouncelizardEggBlockEntity;
import com.morecritters.mod.block.entity.CannonBlockEntity;
import com.morecritters.mod.block.entity.ConfettiPopperTileEntity;
import com.morecritters.mod.block.entity.GravediggerJarTileEntity;
import com.morecritters.mod.block.entity.ShipWheelTileEntity;
import com.morecritters.mod.block.entity.TatteredJollyRogerTileEntity;
import com.morecritters.mod.block.entity.TreasureChestBlockEntity;
import com.morecritters.mod.block.entity.TreasureChestOpenBlockEntity;
import com.morecritters.mod.block.entity.TreasureChestOpeningBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MoreCrittersModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "more_critters");
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BOUNCELIZARD_EGG = register(
        "bouncelizard_egg", MoreCrittersModBlocks.BOUNCELIZARD_EGG, BouncelizardEggBlockEntity::new
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TatteredJollyRogerTileEntity>> TATTERED_JOLLY_ROGER = REGISTRY.register(
        "tattered_jolly_roger", () -> Builder.of(TatteredJollyRogerTileEntity::new, MoreCrittersModBlocks.TATTERED_JOLLY_ROGER.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ShipWheelTileEntity>> SHIP_WHEEL = REGISTRY.register(
        "ship_wheel", () -> Builder.of(ShipWheelTileEntity::new, MoreCrittersModBlocks.SHIP_WHEEL.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CANNON = register("cannon", MoreCrittersModBlocks.CANNON, CannonBlockEntity::new);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TREASURE_CHEST = register(
        "treasure_chest", MoreCrittersModBlocks.TREASURE_CHEST, TreasureChestBlockEntity::new
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TREASURE_CHEST_OPENING = register(
        "treasure_chest_opening", MoreCrittersModBlocks.TREASURE_CHEST_OPENING, TreasureChestOpeningBlockEntity::new
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TREASURE_CHEST_OPEN = register(
        "treasure_chest_open", MoreCrittersModBlocks.TREASURE_CHEST_OPEN, TreasureChestOpenBlockEntity::new
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ConfettiPopperTileEntity>> CONFETTI_POPPER = REGISTRY.register(
        "confetti_popper", () -> Builder.of(ConfettiPopperTileEntity::new, MoreCrittersModBlocks.CONFETTI_POPPER.get()).build(null)
    );
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GravediggerJarTileEntity>> GRAVEDIGGER_JAR = REGISTRY.register(
        "gravedigger_jar", () -> Builder.of(GravediggerJarTileEntity::new, MoreCrittersModBlocks.GRAVEDIGGER_JAR.get()).build(null)
    );

    private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntitySupplier<?> supplier) {
        return REGISTRY.register(registryname, () -> Builder.of(supplier, block.get()).build(null));
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BOUNCELIZARD_EGG.get(), (blockEntity, side) -> new SidedInvWrapper((BouncelizardEggBlockEntity) blockEntity, side));
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CANNON.get(), (blockEntity, side) -> new SidedInvWrapper((CannonBlockEntity) blockEntity, side));
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TREASURE_CHEST.get(), (blockEntity, side) -> new SidedInvWrapper((TreasureChestBlockEntity) blockEntity, side));
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TREASURE_CHEST_OPENING.get(), (blockEntity, side) -> new SidedInvWrapper((TreasureChestOpeningBlockEntity) blockEntity, side));
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TREASURE_CHEST_OPEN.get(), (blockEntity, side) -> new SidedInvWrapper((TreasureChestOpenBlockEntity) blockEntity, side));
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TATTERED_JOLLY_ROGER.get(), (blockEntity, side) -> new SidedInvWrapper((TatteredJollyRogerTileEntity) blockEntity, side));
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SHIP_WHEEL.get(), (blockEntity, side) -> new SidedInvWrapper((ShipWheelTileEntity) blockEntity, side));
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CONFETTI_POPPER.get(), (blockEntity, side) -> new SidedInvWrapper((ConfettiPopperTileEntity) blockEntity, side));
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRAVEDIGGER_JAR.get(), (blockEntity, side) -> new SidedInvWrapper((GravediggerJarTileEntity) blockEntity, side));
    }
}
