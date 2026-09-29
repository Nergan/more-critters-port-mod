package com.morecritters.mod.procedures;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
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

public class ClosedCritterlingSackRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double raterare = 0.0;
            double rateepic = 0.0;
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                == MoreCrittersModItems.CLOSED_CRITTERLING_SACK.get()) {
                if (entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.put_down")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.critterling_sack.put_down")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (entity instanceof LivingEntity _entity) {
                    ItemStack _setstack = new ItemStack(MoreCrittersModItems.CRITTERLING_SACK.get()).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().setChanged();
                    }
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 2);
                if (rate == 1.0) {
                    if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.closed_critterling_sack.jackpot")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.closed_critterling_sack.jackpot")),
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(
                                BuiltInRegistries.ITEM.getRandomElementOf(ItemTags.create(ResourceLocation.parse("minecraft:random_common")), RandomSource.create()).map(Holder::value).orElseGet(() -> Items.AIR)
                            )
                            .copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    raterare = Mth.nextInt(RandomSource.create(), 1, 20);
                    if (raterare == 1.0) {
                        if (entity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(
                                    BuiltInRegistries.ITEM.getRandomElementOf(ItemTags.create(ResourceLocation.parse("minecraft:random_rare")), RandomSource.create()).map(Holder::value).orElseGet(() -> Items.AIR)
                                )
                                .copy();
                            _setstack.setCount(1);
                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                            if (_entity instanceof Player _player) {
                                _player.getInventory().setChanged();
                            }
                        }

                        rateepic = Mth.nextInt(RandomSource.create(), 1, 7);
                        if (rateepic == 1.0 && entity instanceof LivingEntity _entity) {
                            ItemStack _setstack = new ItemStack(
                                    BuiltInRegistries.ITEM.getRandomElementOf(ItemTags.create(ResourceLocation.parse("minecraft:random_epic")), RandomSource.create()).map(Holder::value).orElseGet(() -> Items.AIR)
                                )
                                .copy();
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
    }
}
