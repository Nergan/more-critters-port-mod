package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.init.MoreCrittersModEnchantments;
import com.morecritters.mod.init.MoreCrittersModItems;
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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class FungalStaffRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity != null) {
            if (entity.isShiftKeyDown()) {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.fungal_staff.big_heal")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.fungal_staff.big_heal")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.5), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof LivingEntity
                        && (
                            entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)
                                || entityiterator instanceof Player
                        )) {
                        if (entity instanceof Player _player) {
                            _player.getCooldowns().addCooldown(itemstack.getItem(), 500);
                        }

                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                        )
                                        .withSuppressedOutput(),
                                    "/summon more_critters:heal_echo"
                                );
                        }

                        for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 3.0, 5.0); index0++) {
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
                                        "/particle more_critters:yellow_stripe ~ ~ ~ 2 0.2 2 0 8 force"
                                    );
                            }
                        }

                        if (MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.LOVELY_SIDE, itemstack) != 0) {
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.GIFT_OF_LIFE, 40, 0, false, false));
                            }
                        } else if (MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.DEADLY_SIDE, itemstack) != 0) {
                            if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.GIFT_OF_LIFE, 10, 0, false, false));
                            }
                        } else if ((
                                MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.LOVELY_SIDE, itemstack) == 0
                                    || MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.DEADLY_SIDE, itemstack) == 0
                            )
                            && entityiterator instanceof LivingEntity _entity
                            && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.GIFT_OF_LIFE, 30, 0, false, false));
                        }

                        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
                            == MoreCrittersModItems.FUNGAL_STAFF.get()) {
                            if (entity instanceof LivingEntity _entity) {
                                _entity.swing(InteractionHand.MAIN_HAND, true);
                            }
                        } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                                == MoreCrittersModItems.FUNGAL_STAFF.get()
                            && entity instanceof LivingEntity _entity) {
                            _entity.swing(InteractionHand.OFF_HAND, true);
                        }
                    }
                }
            } else {
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.fungal_staff.heal")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.fungal_staff.heal")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (entity instanceof Player _player) {
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 200);
                }

                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:small_heal_echo"
                        );
                }

                for (int index1 = 0; index1 < (int)Mth.nextDouble(RandomSource.create(), 3.0, 5.0); index1++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle more_critters:yellow_stripe ~ ~ ~ 0.5 0.2 0.5 0 8 force"
                            );
                    }
                }

                if (MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.LOVELY_SIDE, itemstack) != 0) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.GIFT_OF_LIFE, 40, 0, false, false));
                    }
                } else if (MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.DEADLY_SIDE, itemstack) != 0) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.GIFT_OF_LIFE, 10, 0, false, false));
                    }
                } else if ((
                        MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.LOVELY_SIDE, itemstack) == 0
                            || MoreCrittersModEnchantments.getLevel(MoreCrittersModEnchantments.DEADLY_SIDE, itemstack) == 0
                    )
                    && entity instanceof LivingEntity _entity
                    && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.GIFT_OF_LIFE, 30, 0, false, false));
                }

                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.FUNGAL_STAFF.get()
                    )
                 {
                    if (entity instanceof LivingEntity _entity) {
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                    }
                } else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()
                        == MoreCrittersModItems.FUNGAL_STAFF.get()
                    && entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.OFF_HAND, true);
                }
            }
        }
    }
}
