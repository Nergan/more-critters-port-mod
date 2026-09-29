package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.CobbleEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class CobbleTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean found = false;
            double rate = 0.0;
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            double epic_particle = 0.0;
            double flame = 0.0;
            double idle = 0.0;
            sx = -3.0;
            found = false;

            for (int index0 = 0; index0 < 6; index0++) {
                sy = -3.0;

                for (int index1 = 0; index1 < 6; index1++) {
                    sz = -3.0;

                    for (int index2 = 0; index2 < 6; index2++) {
                        if (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock() == Blocks.JUKEBOX
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock().getStateDefinition().getProperty("has_record") instanceof BooleanProperty _getbp3
                            && world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getValue(_getbp3)) {
                            found = true;
                        }

                        sz++;
                    }

                    sy++;
                }

                sx++;
            }

            if (found && (entity instanceof CobbleEntity _datEntI ? _datEntI.getEntityData().get(CobbleEntity.DATA_variant) : 0) == 2) {
                Entity _ent = entity;
                _ent.setYRot(entity.getYRot() + 1.0F);
                _ent.setXRot(0.0F);
                _ent.setYBodyRot(_ent.getYRot());
                _ent.setYHeadRot(_ent.getYRot());
                _ent.yRotO = _ent.getYRot();
                _ent.xRotO = _ent.getXRot();
                if (_ent instanceof LivingEntity _entity) {
                    _entity.yBodyRotO = _entity.getYRot();
                    _entity.yHeadRotO = _entity.getYRot();
                }
            }

            if ((entity instanceof CobbleEntity _datEntI ? _datEntI.getEntityData().get(CobbleEntity.DATA_variant) : 0) == 0) {
                if (entity instanceof CobbleEntity animatable) {
                    animatable.setTexture("cobble");
                }
            } else if ((entity instanceof CobbleEntity _datEntI ? _datEntI.getEntityData().get(CobbleEntity.DATA_variant) : 0) == 1) {
                if (entity instanceof CobbleEntity animatable) {
                    animatable.setTexture("cobble_rare");
                }
            } else if ((entity instanceof CobbleEntity _datEntI ? _datEntI.getEntityData().get(CobbleEntity.DATA_variant) : 0) == 2) {
                if (entity instanceof CobbleEntity animatable) {
                    animatable.setTexture("cobble_epic");
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

            if (!(entity instanceof CobbleEntity _datEntL21 && _datEntL21.getEntityData().get(CobbleEntity.DATA_rotated))) {
                if (entity instanceof CobbleEntity _datEntSetL) {
                    _datEntSetL.getEntityData().set(CobbleEntity.DATA_rotated, true);
                }

                Entity _ent = entity;
                _ent.setYRot(Mth.nextInt(RandomSource.create(), -180, 180));
                _ent.setXRot(0.0F);
                _ent.setYBodyRot(_ent.getYRot());
                _ent.setYHeadRot(_ent.getYRot());
                _ent.yRotO = _ent.getYRot();
                _ent.xRotO = _ent.getXRot();
                if (_ent instanceof LivingEntity _entity) {
                    _entity.yBodyRotO = _entity.getYRot();
                    _entity.yHeadRotO = _entity.getYRot();
                }
            }
        }
    }
}
