package com.morecritters.mod.block.entity;

import net.minecraft.core.HolderLookup;
import io.netty.buffer.Unpooled;
import java.util.stream.IntStream;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModBlockEntities;
import com.morecritters.mod.world.inventory.TreasureChestGuiMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.capabilities.Capabilities;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;

public class TreasureChestOpeningBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
    private NonNullList<ItemStack> stacks = NonNullList.withSize(27, ItemStack.EMPTY);

    public TreasureChestOpeningBlockEntity(BlockPos position, BlockState state) {
        super(MoreCrittersModBlockEntities.TREASURE_CHEST_OPENING.get(), position, state);
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.loadAdditional(compound, lookupProvider);
        if (!this.tryLoadLootTable(compound)) {
            this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        }

        ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);
    }

    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.saveAdditional(compound, lookupProvider);
        if (!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems(compound, this.stacks, lookupProvider);
        }
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
        return this.saveWithFullMetadata(lookupProvider);
    }

    @Override
    public int getContainerSize() {
        return this.stacks.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.stacks) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public Component getDefaultName() {
        return Component.literal("treasure_chest_opening");
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new TreasureChestGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Treasure Chest");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.stacks;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> stacks) {
        this.stacks = stacks;
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return IntStream.range(0, this.getContainerSize()).toArray();
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
        return this.canPlaceItem(index, stack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        if (index == 0) {
            return false;
        } else if (index == 1) {
            return false;
        } else if (index == 2) {
            return false;
        } else if (index == 3) {
            return false;
        } else if (index == 4) {
            return false;
        } else if (index == 5) {
            return false;
        } else if (index == 6) {
            return false;
        } else if (index == 7) {
            return false;
        } else if (index == 8) {
            return false;
        } else if (index == 9) {
            return false;
        } else if (index == 10) {
            return false;
        } else if (index == 11) {
            return false;
        } else if (index == 12) {
            return false;
        } else if (index == 13) {
            return false;
        } else if (index == 14) {
            return false;
        } else if (index == 15) {
            return false;
        } else if (index == 16) {
            return false;
        } else if (index == 17) {
            return false;
        } else if (index == 18) {
            return false;
        } else if (index == 19) {
            return false;
        } else if (index == 20) {
            return false;
        } else if (index == 21) {
            return false;
        } else if (index == 22) {
            return false;
        } else if (index == 23) {
            return false;
        } else if (index == 24) {
            return false;
        } else {
            return index == 25 ? false : index != 26;
        }
    }


}
