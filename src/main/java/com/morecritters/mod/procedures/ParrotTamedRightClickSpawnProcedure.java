package com.morecritters.mod.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ParrotTamedRightClickSpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
        if (direction != null && entity != null) {
            itemstack.shrink(1);
            if (direction == Direction.UP) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:tamed_corpse_parrot ~0.5 ~1 ~0.5 {Owner:XXX}".replace("XXX", entity.getDisplayName().getString())
                        );
                }

                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(ParticleTypes.HEART, x + 0.5, y + 1.0, z + 0.5, 5, 0.5, 0.5, 0.5, 1.0);
                }
            } else if (direction == Direction.DOWN) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:tamed_corpse_parrot ~0.5 ~-1 ~0.5 {Owner:XXX}".replace("XXX", entity.getDisplayName().getString())
                        );
                }

                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(ParticleTypes.HEART, x + 0.5, y - 1.0, z + 0.5, 5, 0.5, 0.5, 0.5, 1.0);
                }
            } else if (direction == Direction.NORTH) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:tamed_corpse_parrot ~0.5 ~ ~-1 {Owner:XXX}".replace("XXX", entity.getDisplayName().getString())
                        );
                }

                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(ParticleTypes.HEART, x + 0.5, y - 0.0, z - 1.0, 5, 0.5, 0.5, 0.5, 1.0);
                }
            } else if (direction == Direction.SOUTH) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:tamed_corpse_parrot ~0.5 ~ ~1.5 {Owner:XXX}".replace("XXX", entity.getDisplayName().getString())
                        );
                }

                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(ParticleTypes.HEART, x + 0.5, y - 0.0, z + 1.5, 5, 0.5, 0.5, 0.5, 1.0);
                }
            } else if (direction == Direction.WEST) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:tamed_corpse_parrot ~-1 ~ ~0.5 {Owner:XXX}".replace("XXX", entity.getDisplayName().getString())
                        );
                }

                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(ParticleTypes.HEART, x - 1.0, y - 0.0, z + 0.5, 5, 0.5, 0.5, 0.5, 1.0);
                }
            } else if (direction == Direction.EAST) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/summon more_critters:tamed_corpse_parrot ~1.5 ~ ~0.5 {Owner:XXX}".replace("XXX", entity.getDisplayName().getString())
                        );
                }

                if (world instanceof ServerLevel _level) {
                    _level.sendParticles(ParticleTypes.HEART, x + 1.5, y - 0.0, z + 0.5, 5, 0.5, 0.5, 0.5, 1.0);
                }
            }
        }
    }
}
