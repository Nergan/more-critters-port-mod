package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.MoriRootsEntity;
import com.morecritters.mod.init.MoreCrittersModEnchantments;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class FungalStaffLivingEntityIsHitWithToolProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
        if (entity != null && sourceentity != null) {
            double rate = 0.0;
            if (!(entity instanceof MoriRootsEntity)) {
                if (MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.LOVELY_SIDE, itemstack) != 0) {
                    rate = Mth.nextInt(RandomSource.create(), 1, 20);
                } else if (MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.DEADLY_SIDE, itemstack) != 0) {
                    rate = Mth.nextInt(RandomSource.create(), 1, 5);
                } else if (MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.LOVELY_SIDE, itemstack) == 0
                    || MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.DEADLY_SIDE, itemstack) == 0) {
                    rate = Mth.nextInt(RandomSource.create(), 1, 10);
                }

                if (rate != 1.0) {
                    if (!(sourceentity instanceof Player _plrCldCheck13 && _plrCldCheck13.getCooldowns().isOnCooldown(itemstack.getItem()))) {
                        if (MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.LOVELY_SIDE, itemstack) != 0) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.IMMINENT_DEATH, 10, 0, false, false));
                            }
                        } else if (MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.DEADLY_SIDE, itemstack) != 0) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.IMMINENT_DEATH, 40, 0, false, false));
                            }
                        } else if ((
                                MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.LOVELY_SIDE, itemstack) == 0
                                    || MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.DEADLY_SIDE, itemstack) == 0
                            )
                            && entity instanceof LivingEntity _entity
                            && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.IMMINENT_DEATH, 20, 0, false, false));
                        }

                        if (sourceentity instanceof Player _player) {
                            _player.getCooldowns().addCooldown(itemstack.getItem(), 20);
                        }
                    }
                } else if (!(sourceentity instanceof Player _plrCldCheck28 && _plrCldCheck28.getCooldowns().isOnCooldown(itemstack.getItem()))) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.IMMINENT_DEATH, 40, 0, false, false));
                    }

                    if (sourceentity instanceof Player _player) {
                        _player.getCooldowns().addCooldown(itemstack.getItem(), 60);
                    }

                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/summon more_critters:mori_roots"
                            );
                    }

                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mori_roots.bite")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mori_roots.bite")),
                                SoundSource.HOSTILE,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }
                }
            }
        }
    }
}
