package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.RamchuEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public class RamchuRightClickedOnEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if ((entity instanceof RamchuEntity _datEntI ? _datEntI.getEntityData().get(RamchuEntity.DATA_state) : 0) == 1
                && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                if (sourceentity instanceof Player _player) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.RAMCHU_OIL_BOTTLE.get()).copy();
                    _setstack.setCount(1);
                    ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                }

                if (entity instanceof RamchuEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(RamchuEntity.DATA_state, 2);
                }

                entity.getPersistentData().putDouble("oil", Mth.nextDouble(RandomSource.create(), 400.0, 10000.0));
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ramchu.oil")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ramchu.oil")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }

            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.fill_fish")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.fill_fish")),
                            SoundSource.BLOCKS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if ((entity instanceof RamchuEntity _datEntI ? _datEntI.getEntityData().get(RamchuEntity.DATA_state) : 0) == 0) {
                    if (sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.RAMCHU_BUCKET_BUCKET.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if ((entity instanceof RamchuEntity _datEntI ? _datEntI.getEntityData().get(RamchuEntity.DATA_state) : 0) == 1) {
                    if (sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(MoreCrittersModItems.RAMCHU_BUCKET_NO_SHELL_BUCKET.get()).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }
                } else if ((entity instanceof RamchuEntity _datEntI ? _datEntI.getEntityData().get(RamchuEntity.DATA_state) : 0) == 2
                    && sourceentity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.RAMCHU_BUCKET_NO_OIL_BUCKET.get()).copy();
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
