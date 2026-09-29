package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.entity.CarrybugEntity;
import com.morecritters.mod.entity.EchoEntity;
import com.morecritters.mod.entity.HealEchoEntity;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.MoriRootsEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import com.morecritters.mod.entity.ShockCubeSmallEntity;
import com.morecritters.mod.entity.ShriekbombProjectileEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import com.morecritters.mod.entity.WebSackProjectileEntity;
import com.morecritters.mod.init.MoreCrittersModBlocks;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WebSackProjectileProjectileHitsLivingEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD))
                != Level.NETHER) {
                if (!(entity instanceof AncientSkeletonEntity)
                    && !(entity instanceof EchoEntity)
                    && !(entity instanceof HealEchoEntity)
                    && !(entity instanceof LargeEchoEntity)
                    && !(entity instanceof MoriRootsEntity)
                    && !(entity instanceof ShockCubeEntity)
                    && !(entity instanceof ShockCubeSmallEntity)
                    && !(entity instanceof WebEntityEntity)
                    && !(entity instanceof ShriekbombProjectileEntity)
                    && !(entity instanceof CarrybugEntity)
                    && !(entity instanceof Player)) {
                    if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1.0F) <= ServerConfig.CONFIG.webbedHealth.get()) {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.web_sack.hit")),
                                    SoundSource.AMBIENT,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.web_sack.hit")),
                                    SoundSource.AMBIENT,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.WEBBED, 2147483647, 0, false, false));
                        }

                        for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 5); index0++) {
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
                                        "/particle minecraft:snowflake ~ ~ ~ 0.5 0.8 0.5 0.03 10 force"
                                    );
                            }

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
                                        "/particle minecraft:snowflake ~ ~ ~ 0.5 0.8 0.5 0.03 10 force"
                                    );
                            }
                        }
                    } else {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(
                                    (Player)null,
                                    BlockPos.containing(x, y, z),
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.web_sack.hit")),
                                    SoundSource.AMBIENT,
                                    1.0F,
                                    1.0F
                                );
                            } else {
                                _level.playLocalSound(
                                    x,
                                    y,
                                    z,
                                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.web_sack.hit")),
                                    SoundSource.AMBIENT,
                                    1.0F,
                                    1.0F,
                                    false
                                );
                            }
                        }

                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + 1.0, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:snowflake ~ ~ ~ 0.5 0.8 0.5 0.03 10 force"
                                );
                        }

                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(x, y + 1.0, z),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle minecraft:block{block_state:\"more_critters:freezing_cobweb\"} ~ ~ ~ 0.2 0.2 0.2 0.03 10 force"
                                );
                        }

                        if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.AIR) {
                            world.setBlock(BlockPos.containing(x, y + 1.0, z), MoreCrittersModBlocks.FREEZING_COBWEB.get().defaultBlockState(), 3);
                        }

                        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.AIR) {
                            world.setBlock(BlockPos.containing(x, y, z), MoreCrittersModBlocks.FREEZING_COBWEB.get().defaultBlockState(), 3);
                        }
                    }
                } else {
                    Vec3 _center = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator instanceof WebSackProjectileEntity && !entityiterator.level().isClientSide()) {
                            entityiterator.discard();
                        }
                    }
                }
            }
        }
    }
}
