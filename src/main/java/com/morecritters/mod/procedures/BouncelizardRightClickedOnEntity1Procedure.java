package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.BouncelizardEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class BouncelizardRightClickedOnEntity1Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.isBaby())) {
                if (!(entity instanceof BouncelizardEntity _datEntL1 && _datEntL1.getEntityData().get(BouncelizardEntity.DATA_sleeping))) {
                    if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                        == MoreCrittersModItems.BOUNCEBERRY.get()) {
                        (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                            .setCount((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
                        if (sourceentity instanceof LivingEntity _entity) {
                            _entity.swing(InteractionHand.MAIN_HAND, true);
                        }

                        for (int index0 = 0; index0 < 4; index0++) {
                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(x, y, z),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle minecraft:item{item:\"more_critters:bounceberry\"} ~ ~0.3 ~ 0.1 0.02 0.01 0.02 5 normal"
                                    );
                            }
                        }

                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.strider.eat")),
                                    SoundSource.VOICE,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.strider.eat")),
                                    SoundSource.VOICE,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (entity instanceof BouncelizardEntity _datEntSetL) {
                            _datEntSetL.getEntityData().set(BouncelizardEntity.DATA_sleeping, true);
                        }
                    }
                } else if (entity instanceof BouncelizardEntity _datEntL12
                    && _datEntL12.getEntityData().get(BouncelizardEntity.DATA_sleeping)
                    && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.MILK_BUCKET) {
                    if (sourceentity instanceof LivingEntity _entity) {
                        ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player _player) {
                            _player.getInventory().setChanged();
                        }
                    }

                    if (sourceentity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.drink")),
                                SoundSource.VOICE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.generic.drink")),
                                SoundSource.VOICE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof BouncelizardEntity _datEntSetL) {
                        _datEntSetL.getEntityData().set(BouncelizardEntity.DATA_sleeping, false);
                    }
                }
            }
        }
    }
}
