package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.MothkidEntity;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class MothkidOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean found = false;
            double rate = 0.0;
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            double epic_particle = 0.0;
            if (entity instanceof MothkidEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(MothkidEntity.DATA_idle, (entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_idle) : 0) - 1);
            }

            if (entity instanceof MothkidEntity _datEntSetI) {
                _datEntSetI.getEntityData()
                    .set(MothkidEntity.DATA_jump, (entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_jump) : 0) - 1);
            }

            if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_idle) : 0) <= 1) {
                if (entity instanceof MothkidEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(MothkidEntity.DATA_idle, Mth.nextInt(RandomSource.create(), 200, 400));
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 3);
                if (!found && !(entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6)) {
                    if (entity instanceof Mob _entity) {
                        _entity.getNavigation().stop();
                    }

                    if (rate == 1.0) {
                        if (entity instanceof MothkidEntity) {
                            ((MothkidEntity)entity).setAnimation("idle1");
                        }
                    } else if (rate == 2.0) {
                        if (entity instanceof MothkidEntity) {
                            ((MothkidEntity)entity).setAnimation("idle2");
                        }
                    } else if (rate == 3.0 && entity instanceof MothkidEntity) {
                        ((MothkidEntity)entity).setAnimation("idle3");
                    }
                }
            }

            if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_jump) : 0) <= 1) {
                if (entity instanceof MothkidEntity _datEntSetI) {
                    _datEntSetI.getEntityData().set(MothkidEntity.DATA_jump, Mth.nextInt(RandomSource.create(), 100, 200));
                }

                if (!((MothkidEntity)entity).animationprocedure.equals("dance")
                    && !((MothkidEntity)entity).animationprocedure.equals("dance_epic")
                    && entity.onGround()) {
                    if (entity instanceof MothkidEntity) {
                        ((MothkidEntity)entity).setAnimation("empty");
                    }

                    Entity _ent = entity;
                    _ent.setYRot((float)Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
                    _ent.setXRot(0.0F);
                    _ent.setYBodyRot(_ent.getYRot());
                    _ent.setYHeadRot(_ent.getYRot());
                    _ent.yRotO = _ent.getYRot();
                    _ent.xRotO = _ent.getXRot();
                    if (_ent instanceof LivingEntity _entity) {
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                    }

                    entity.setDeltaMovement(new Vec3(Mth.nextDouble(RandomSource.create(), -0.2, 0.2), 0.5, Mth.nextDouble(RandomSource.create(), -0.2, 0.2)));
                    MoreCritters.queueServerWork(
                        2,
                        () -> {
                            if (world instanceof Level _levelx) {
                                if (!_levelx.isClientSide()) {
                                    _levelx.playSound(
                                        (Player)null,
                                        BlockPos.containing(x, y, z),
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mothkid.fly")),
                                        SoundSource.NEUTRAL,
                                        1.0F,
                                        1.0F
                                    );
                                } else {
                                    _levelx.playLocalSound(
                                        x,
                                        y,
                                        z,
                                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.mothkid.fly")),
                                        SoundSource.NEUTRAL,
                                        1.0F,
                                        1.0F,
                                        false
                                    );
                                }
                            }
                        }
                    );
                }
            }

            if (!entity.onGround()) {
                if (entity instanceof MothkidEntity) {
                    ((MothkidEntity)entity).setAnimation("empty");
                }

                if (entity instanceof MothkidEntity) {
                    ((MothkidEntity)entity).setAnimation("fly");
                }
            }

            if (((MothkidEntity)entity).animationprocedure.equals("fly") && entity.onGround() && entity instanceof MothkidEntity) {
                ((MothkidEntity)entity).setAnimation("reset");
            }

            sx = -3.0;
            found = false;

            for (int index0 = 0; index0 < 6; index0++) {
                sy = -3.0;

                for (int index1 = 0; index1 < 6; index1++) {
                    sz = -3.0;

                    for (int index2 = 0; index2 < 6; index2++) {
                        if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == Blocks.JUKEBOX
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock().getStateDefinition().getProperty("has_record") instanceof BooleanProperty _getbp36
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getValue(_getbp36)) {
                            found = true;
                        }

                        sz++;
                    }

                    sy++;
                }

                sx++;
            }

            if (found) {
                if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_variant) : 0) != 0
                    && (entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_variant) : 0) != 1) {
                    if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_variant) : 0) == 2
                        && entity instanceof MothkidEntity) {
                        ((MothkidEntity)entity).setAnimation("dance_epic");
                    }
                } else if (entity instanceof MothkidEntity) {
                    ((MothkidEntity)entity).setAnimation("dance");
                }
            }

            if (!found
                && (((MothkidEntity)entity).animationprocedure.equals("dance") || ((MothkidEntity)entity).animationprocedure.equals("dance_epic"))
                && entity instanceof MothkidEntity) {
                ((MothkidEntity)entity).setAnimation("empty");
            }

            if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_variant) : 0) == 0) {
                if (entity instanceof MothkidEntity animatable) {
                    animatable.setTexture("mothkid");
                }
            } else if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_variant) : 0) == 1) {
                if (entity instanceof MothkidEntity animatable) {
                    animatable.setTexture("rare_mothkid");
                }
            } else if ((entity instanceof MothkidEntity _datEntI ? _datEntI.getEntityData().get(MothkidEntity.DATA_variant) : 0) == 2) {
                if (entity instanceof MothkidEntity animatable) {
                    animatable.setTexture("epic_mothkid");
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
