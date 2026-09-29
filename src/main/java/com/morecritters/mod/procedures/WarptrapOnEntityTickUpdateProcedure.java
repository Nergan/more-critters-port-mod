package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.WarptrapEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WarptrapOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity.isShiftKeyDown()) {
                if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap_crimson")
                    && entity instanceof WarptrapEntity animatable) {
                    animatable.setTexture("warptrap_crimson_dig");
                }

                if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap")
                    && entity instanceof WarptrapEntity animatable) {
                    animatable.setTexture("warptrap_dig");
                }
            } else if (!entity.isShiftKeyDown()) {
                if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap_crimson_dig")
                    && entity instanceof WarptrapEntity animatable) {
                    animatable.setTexture("warptrap_crimson");
                }

                if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap_dig")
                    && entity instanceof WarptrapEntity animatable) {
                    animatable.setTexture("warptrap");
                }
            }

            if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap_crimson_dig")
                && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != Blocks.CRIMSON_NYLIUM) {
                entity.setShiftKeyDown(false);
            }

            if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap_dig")
                && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() != Blocks.WARPED_NYLIUM) {
                entity.setShiftKeyDown(false);
            }

            if (!((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)) {
                if (!entity.isShiftKeyDown()) {
                    if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap_crimson")
                        && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.CRIMSON_NYLIUM) {
                        if (!(entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(MoreCrittersModMobEffects.WARPTRAP_DIGGER))
                            && entity instanceof LivingEntity _entity
                            && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.WARPTRAP_DIGGER, 40, 0, false, false));
                        }

                        MoreCritters.queueServerWork(40, () -> entity.setShiftKeyDown(true));
                    }

                    if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap")
                        && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.WARPED_NYLIUM) {
                        if (!(entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(MoreCrittersModMobEffects.WARPTRAP_DIGGER))
                            && entity instanceof LivingEntity _entity
                            && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.WARPTRAP_DIGGER, 40, 0, false, false));
                        }

                        MoreCritters.queueServerWork(40, () -> entity.setShiftKeyDown(true));
                    }
                }
            } else if ((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity && entity.isShiftKeyDown()) {
                if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap_crimson_dig")
                    && world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:block{block_state:\"minecraft:crimson_nylium\"} ~ ~ ~ 0.5 0 0.5 2 7 force"
                        );
                }

                if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap_dig")
                    && world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:block{block_state:\"minecraft:warped_nylium\"} ~ ~ ~ 0.5 0 0.5 2 7 force"
                        );
                }
            }
        }
    }
}
