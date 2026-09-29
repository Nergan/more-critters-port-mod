package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.IroballEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class IroballRightClickedOnEntityProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (entity instanceof IroballEntity _datEntL3 && _datEntL3.getEntityData().get(IroballEntity.DATA_sturdy)) {
                    if (sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.SPIKED_IROBALL.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if (sourceentity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.IROBALL_ITEM.get()).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }
            }
        }
    }
}
