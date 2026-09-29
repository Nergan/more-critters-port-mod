package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.OpalcrabEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class OpalcrabTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean found = false;
            double rate = 0.0;
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            double epic_particle = 0.0;
            if (entity instanceof OpalcrabEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(OpalcrabEntity.DATA_idle, (entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_idle) : 0) - 1);
            }

            if ((entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_idle) : 0) <= 1) {
                if (entity instanceof OpalcrabEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(OpalcrabEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 3);
                if (!found && !(entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6)) {
                    if (entity instanceof Mob _entity) {
                        _entity.getNavigation().stop();
                    }

                    if (rate == 1.0) {
                        if (entity instanceof OpalcrabEntity) {
                            ((OpalcrabEntity)entity).setAnimation("idle1");
                        }
                    } else if (rate == 2.0) {
                        if (entity instanceof OpalcrabEntity) {
                            ((OpalcrabEntity)entity).setAnimation("idle2");
                        }
                    } else if (rate == 3.0 && entity instanceof OpalcrabEntity) {
                        ((OpalcrabEntity)entity).setAnimation("idle3");
                    }
                }
            }

            sx = -3.0;
            found = false;

            for (int index0 = 0; index0 < 6; index0++) {
                sy = -3.0;

                for (int index1 = 0; index1 < 6; index1++) {
                    sz = -3.0;

                    for (int index2 = 0; index2 < 6; index2++) {
                        if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == Blocks.JUKEBOX
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock().getStateDefinition().getProperty("has_record") instanceof BooleanProperty _getbp14
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getValue(_getbp14)) {
                            found = true;
                        }

                        sz++;
                    }

                    sy++;
                }

                sx++;
            }

            if (found) {
                if ((entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_variant) : 0) != 0
                    && (entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_variant) : 0) != 1) {
                    if ((entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_variant) : 0) == 2
                        && entity instanceof OpalcrabEntity) {
                        ((OpalcrabEntity)entity).setAnimation("dance_epic");
                    }
                } else if (entity instanceof OpalcrabEntity) {
                    ((OpalcrabEntity)entity).setAnimation("dance");
                }
            }

            if (!found
                && (((OpalcrabEntity)entity).animationprocedure.equals("dance") || ((OpalcrabEntity)entity).animationprocedure.equals("dance_epic"))
                && entity instanceof OpalcrabEntity) {
                ((OpalcrabEntity)entity).setAnimation("empty");
            }

            if ((entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_variant) : 0) == 0) {
                if (entity instanceof OpalcrabEntity animatable) {
                    animatable.setTexture("opalcrab");
                }
            } else if ((entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_variant) : 0) == 1) {
                if (entity instanceof OpalcrabEntity animatable) {
                    animatable.setTexture("rare_opalcrab");
                }
            } else if ((entity instanceof OpalcrabEntity _datEntI ? _datEntI.getEntityData().get(OpalcrabEntity.DATA_variant) : 0) == 2) {
                if (entity instanceof OpalcrabEntity animatable) {
                    animatable.setTexture("epic_opalcrab");
                }

                epic_particle = Mth.nextInt(RandomSource.create(), 1, 100);
                if (epic_particle == 1.0) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle more_critters:epic_particle ~ ~ ~ 0.3 0.3 0.3 0.01 3 force"
                            );
                    }

                    MoreCritters.queueServerWork(
                        3,
                        () -> {
                            if (world instanceof ServerLevel _levelx) {
                                _levelx.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(x, y, z),
                                                Vec2.ZERO,
                                                _levelx,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _levelx.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle more_critters:epic_particle ~ ~ ~ 0.3 0.3 0.3 0.01 3 force"
                                    );
                            }

                            MoreCritters.queueServerWork(
                                3,
                                () -> {
                                    if (world instanceof ServerLevel _levelxx) {
                                        _levelxx.getServer()
                                            .getCommands()
                                            .performPrefixedCommand(
                                                new CommandSourceStack(
                                                        CommandSource.NULL,
                                                        new Vec3(x, y, z),
                                                        Vec2.ZERO,
                                                        _levelxx,
                                                        4,
                                                        "",
                                                        Component.literal(""),
                                                        _levelxx.getServer(),
                                                        null
                                                    )
                                                    .withSuppressedOutput(),
                                                "/particle more_critters:epic_particle ~ ~ ~ 0.3 0.3 0.3 0.01 3 force"
                                            );
                                    }

                                    MoreCritters.queueServerWork(
                                        3,
                                        () -> {
                                            if (world instanceof ServerLevel _levelxxx) {
                                                _levelxxx.getServer()
                                                    .getCommands()
                                                    .performPrefixedCommand(
                                                        new CommandSourceStack(
                                                                CommandSource.NULL,
                                                                new Vec3(x, y, z),
                                                                Vec2.ZERO,
                                                                _levelxxx,
                                                                4,
                                                                "",
                                                                Component.literal(""),
                                                                _levelxxx.getServer(),
                                                                null
                                                            )
                                                            .withSuppressedOutput(),
                                                        "/particle more_critters:epic_particle ~ ~ ~ 0.3 0.3 0.3 0.01 3 force"
                                                    );
                                            }
                                        }
                                    );
                                }
                            );
                        }
                    );
                }
            }

            if (entity.isInWaterOrBubble()) {
                entity.setAirSupply(10);
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 1, false, false));
                }
            }
        }
    }
}
