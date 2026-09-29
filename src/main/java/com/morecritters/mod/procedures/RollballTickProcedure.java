package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.RollballEntity;
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

public class RollballTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean found = false;
            double rate = 0.0;
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            double epic_particle = 0.0;
            if (entity instanceof RollballEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(RollballEntity.DATA_idle, (entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_idle) : 0) - 1);
            }

            if (entity instanceof RollballEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(RollballEntity.DATA_roll, (entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_roll) : 0) - 1);
            }

            if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_idle) : 0) <= 1) {
                if (entity instanceof RollballEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(RollballEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 3);
                if (!found && !(entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6)) {
                    if (entity instanceof Mob _entity) {
                        _entity.getNavigation().stop();
                    }

                    if (rate == 1.0) {
                        if (entity instanceof RollballEntity) {
                            ((RollballEntity)entity).setAnimation("idle1");
                        }
                    } else if (rate == 2.0) {
                        if (entity instanceof RollballEntity) {
                            ((RollballEntity)entity).setAnimation("idle2");
                        }
                    } else if (rate == 3.0 && entity instanceof RollballEntity) {
                        ((RollballEntity)entity).setAnimation("idle3");
                    }
                }
            }

            if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_roll) : 0) <= 1) {
                if (entity instanceof RollballEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(RollballEntity.DATA_roll, Mth.nextInt(RandomSource.create(), 60, 200));
                }

                if (!((RollballEntity)entity).animationprocedure.equals("dance") && !((RollballEntity)entity).animationprocedure.equals("dance_epic")) {
                    if (entity instanceof RollballEntity) {
                        ((RollballEntity)entity).setAnimation("roll");
                    }

                    MoreCritters.queueServerWork(
                        10,
                        () -> {
                            if ((entity instanceof RollballEntity animatable ? animatable.getTexture() : "null").equals("rollball_rolled")) {
                                if (world instanceof Level _levelxxxxxx) {
                                    if (!_levelxxxxxx.isClientSide()) {
                                        _levelxxxxxx.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.unroll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _levelxxxxxx.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.unroll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if (entity instanceof RollballEntity animatable) {
                                    animatable.setTexture("rollball");
                                }
                            } else if ((entity instanceof RollballEntity animatable ? animatable.getTexture() : "null").equals("rollball")) {
                                if (world instanceof Level _levelxxxxx) {
                                    if (!_levelxxxxx.isClientSide()) {
                                        _levelxxxxx.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.roll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _levelxxxxx.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.roll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if (entity instanceof RollballEntity animatable) {
                                    animatable.setTexture("rollball_rolled");
                                }
                            } else if ((entity instanceof RollballEntity animatable ? animatable.getTexture() : "null").equals("rare_rollball_rolled")) {
                                if (world instanceof Level _levelxxxx) {
                                    if (!_levelxxxx.isClientSide()) {
                                        _levelxxxx.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.unroll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _levelxxxx.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.unroll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if (entity instanceof RollballEntity animatable) {
                                    animatable.setTexture("rare_rollball");
                                }
                            } else if ((entity instanceof RollballEntity animatable ? animatable.getTexture() : "null").equals("rare_rollball")) {
                                if (world instanceof Level _levelxxx) {
                                    if (!_levelxxx.isClientSide()) {
                                        _levelxxx.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.roll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _levelxxx.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.roll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if (entity instanceof RollballEntity animatable) {
                                    animatable.setTexture("rare_rollball_rolled");
                                }
                            } else if ((entity instanceof RollballEntity animatable ? animatable.getTexture() : "null").equals("epic_rollball_rolled")) {
                                if (world instanceof Level _levelxx) {
                                    if (!_levelxx.isClientSide()) {
                                        _levelxx.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.unroll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _levelxx.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.unroll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if (entity instanceof RollballEntity animatable) {
                                    animatable.setTexture("epic_rollball");
                                }
                            } else if ((entity instanceof RollballEntity animatable ? animatable.getTexture() : "null").equals("epic_rollball")) {
                                if (world instanceof Level _levelx) {
                                    if (!_levelx.isClientSide()) {
                                        _levelx.playSound(
                                            (Player)null,
                                            BlockPos.containing(x, y, z),
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.roll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F
                                        );
                                    } else {
                                        _levelx.playLocalSound(
                                            x,
                                            y,
                                            z,
                                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rollball.roll")),
                                            SoundSource.NEUTRAL,
                                            1.0F,
                                            1.0F,
                                            false
                                        );
                                    }
                                }

                                if (entity instanceof RollballEntity animatable) {
                                    animatable.setTexture("epic_rollball_rolled");
                                }
                            }
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
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock().getStateDefinition().getProperty("has_record") instanceof BooleanProperty _getbp41
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getValue(_getbp41)) {
                            found = true;
                        }

                        sz++;
                    }

                    sy++;
                }

                sx++;
            }

            if (found) {
                if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_variant) : 0) != 0
                    && (entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_variant) : 0) != 1) {
                    if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_variant) : 0) == 2
                        && entity instanceof RollballEntity) {
                        ((RollballEntity)entity).setAnimation("dance_epic");
                    }
                } else if (entity instanceof RollballEntity) {
                    ((RollballEntity)entity).setAnimation("dance");
                }
            }

            if (!found
                && (((RollballEntity)entity).animationprocedure.equals("dance") || ((RollballEntity)entity).animationprocedure.equals("dance_epic"))
                && entity instanceof RollballEntity) {
                ((RollballEntity)entity).setAnimation("empty");
            }

            if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_variant) : 0) == 0) {
                if (!(entity instanceof RollballEntity animatable ? animatable.getTexture() : "null").equals("rollball_rolled")
                    && entity instanceof RollballEntity animatable) {
                    animatable.setTexture("rollball");
                }
            } else if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_variant) : 0) == 1) {
                if (!(entity instanceof RollballEntity animatable ? animatable.getTexture() : "null").equals("rare_rollball_rolled")
                    && entity instanceof RollballEntity animatable) {
                    animatable.setTexture("rare_rollball");
                }
            } else if ((entity instanceof RollballEntity _datEntI ? _datEntI.getEntityData().get(RollballEntity.DATA_variant) : 0) == 2) {
                if (!(entity instanceof RollballEntity animatable ? animatable.getTexture() : "null").equals("epic_rollball_rolled")) {
                    if (entity instanceof RollballEntity animatable) {
                        animatable.setTexture("epic_rollball");
                    }

                    epic_particle = Mth.nextInt(RandomSource.create(), 1, 100);
                }

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
