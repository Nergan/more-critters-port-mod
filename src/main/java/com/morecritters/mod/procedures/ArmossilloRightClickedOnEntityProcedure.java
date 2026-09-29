package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.ArmossilloEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class ArmossilloRightClickedOnEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.GLOW_BERRIES
                && (entity instanceof ArmossilloEntity _datEntI ? _datEntI.getEntityData().get(ArmossilloEntity.DATA_sneeze) : 0) <= 0) {
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.dolphin.eat")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.dolphin.eat")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                        );
                    }
                }

                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (entity instanceof ArmossilloEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(ArmossilloEntity.DATA_sneeze, 20);
                }

                MoreCritters.queueServerWork(
                    7,
                    () -> {
                        if (!world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.armossillo.sneeze_ready")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.armossillo.sneeze_ready")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    }
                );
                if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                    (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                }

                if (entity instanceof ArmossilloEntity) {
                    ((ArmossilloEntity)entity).setAnimation("empty");
                }

                if (entity instanceof ArmossilloEntity) {
                    ((ArmossilloEntity)entity).setAnimation("sneeze");
                }
            }
        }
    }
}
