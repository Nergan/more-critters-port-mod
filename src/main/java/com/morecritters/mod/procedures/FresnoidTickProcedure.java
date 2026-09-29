package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.FresnoidEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class FresnoidTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean found = false;
            double rate = 0.0;
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            double epic_particle = 0.0;
            double flame = 0.0;
            double yawn = 0.0;
            if (entity instanceof FresnoidEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(FresnoidEntity.DATA_idle, (entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_idle) : 0) - 1);
            }

            if ((entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_idle) : 0) <= 1) {
                if (entity instanceof FresnoidEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(FresnoidEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 3);
                if (!found
                    && !(entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6)
                    && !((FresnoidEntity)entity).animationprocedure.equals("dance")
                    && !((FresnoidEntity)entity).animationprocedure.equals("dance_epic")) {
                    if (entity instanceof Mob _entity) {
                        _entity.getNavigation().stop();
                    }

                    yawn = Mth.nextInt(RandomSource.create(), 1, 100);
                    if (yawn == 1.0) {
                        if (!world.isClientSide() && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.fresnoid.yawn_goofy")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.fresnoid.yawn_goofy")),
                                    SoundSource.NEUTRAL,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }
                    } else if (!world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.fresnoid.yawn")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.fresnoid.yawn")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof FresnoidEntity) {
                        ((FresnoidEntity)entity).setAnimation("idle1");
                    }

                    MoreCritters.queueServerWork(50, () -> {
                        if (entity instanceof FresnoidEntity) {
                            ((FresnoidEntity)entity).setAnimation("empty");
                        }
                    });
                    MoreCritters.queueServerWork(
                        13,
                        () -> {
                            if ((entity instanceof FresnoidEntity _datEntIxxx ? _datEntIxxx.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 0) {
                                if (entity instanceof FresnoidEntity animatable) {
                                    animatable.setTexture("fresnoid_yawn");
                                }
                            } else if ((entity instanceof FresnoidEntity _datEntIxx ? _datEntIxx.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 1) {
                                if (entity instanceof FresnoidEntity animatable) {
                                    animatable.setTexture("fresnoid_rare_yawn");
                                }
                            } else if ((entity instanceof FresnoidEntity _datEntIx ? _datEntIx.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 2
                                && entity instanceof FresnoidEntity animatable) {
                                animatable.setTexture("fresnoid_epic_yawn");
                            }

                            MoreCritters.queueServerWork(
                                28,
                                () -> {
                                    if ((entity instanceof FresnoidEntity _datEntIxxxxxx ? _datEntIxxxxxx.getEntityData().get(FresnoidEntity.DATA_variant) : 0)
                                        == 0) {
                                        if (entity instanceof FresnoidEntity animatablexxx) {
                                            animatablexxx.setTexture("fresnoid");
                                        }
                                    } else if ((
                                            entity instanceof FresnoidEntity _datEntIxxxxx ? _datEntIxxxxx.getEntityData().get(FresnoidEntity.DATA_variant) : 0
                                        )
                                        == 1) {
                                        if (entity instanceof FresnoidEntity animatablexx) {
                                            animatablexx.setTexture("fresnoid_rare");
                                        }
                                    } else if ((
                                                entity instanceof FresnoidEntity _datEntIxxxx
                                                    ? _datEntIxxxx.getEntityData().get(FresnoidEntity.DATA_variant)
                                                    : 0
                                            )
                                            == 2
                                        && entity instanceof FresnoidEntity animatablex) {
                                        animatablex.setTexture("fresnoid_epic");
                                    }
                                }
                            );
                        }
                    );
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
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock().getStateDefinition().getProperty("has_record") instanceof BooleanProperty _getbp35
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getValue(_getbp35)) {
                            found = true;
                        }

                        sz++;
                    }

                    sy++;
                }

                sx++;
            }

            if (found) {
                if ((entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_variant) : 0) != 0
                    && (entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_variant) : 0) != 1) {
                    if ((entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 2
                        && entity instanceof FresnoidEntity) {
                        ((FresnoidEntity)entity).setAnimation("dance_epic");
                    }
                } else if (entity instanceof FresnoidEntity) {
                    ((FresnoidEntity)entity).setAnimation("dance");
                }
            }

            if (!found
                && (((FresnoidEntity)entity).animationprocedure.equals("dance") || ((FresnoidEntity)entity).animationprocedure.equals("dance_epic"))
                && entity instanceof FresnoidEntity) {
                ((FresnoidEntity)entity).setAnimation("empty");
            }

            if (!((FresnoidEntity)entity).animationprocedure.equals("idle1")) {
                if ((entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 0) {
                    if (entity instanceof FresnoidEntity animatable) {
                        animatable.setTexture("fresnoid");
                    }
                } else if ((entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 1) {
                    if (entity instanceof FresnoidEntity animatable) {
                        animatable.setTexture("fresnoid_rare");
                    }
                } else if ((entity instanceof FresnoidEntity _datEntI ? _datEntI.getEntityData().get(FresnoidEntity.DATA_variant) : 0) == 2) {
                    if (entity instanceof FresnoidEntity animatable) {
                        animatable.setTexture("fresnoid_epic");
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
            }
        }
    }
}
