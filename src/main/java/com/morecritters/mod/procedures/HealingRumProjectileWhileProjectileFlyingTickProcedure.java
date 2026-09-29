package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.CorpseCaptainEntity;
import com.morecritters.mod.entity.CorpseMateEntity;
import com.morecritters.mod.entity.CorpseParrotEntity;
import com.morecritters.mod.entity.CorpseQuartermasterEntity;
import com.morecritters.mod.entity.CorpseTankEntity;
import com.morecritters.mod.entity.HealingRumProjectileEntity;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class HealingRumProjectileWhileProjectileFlyingTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!world.getEntitiesOfClass(CorpseMateEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true).isEmpty()
            || !world.getEntitiesOfClass(CorpseQuartermasterEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true).isEmpty()) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (entityiterator instanceof HealingRumProjectileEntity) {
                    if (world.isClientSide() && world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.healing_rum.break")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _level.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.healing_rum.break")),
                                SoundSource.BLOCKS,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (!entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                    }
                }
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                            )
                            .withSuppressedOutput(),
                        "/particle more_critters:heal_plus ~ ~1 ~ 0.5 0.5 0.5 0.01 6"
                    );
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(
                                CommandSource.NULL, new Vec3(x + 0.5, y, z + 0.5), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                            )
                            .withSuppressedOutput(),
                        "/particle minecraft:item{item:\"minecraft:glass_bottle\"} ~ ~1 ~ 0.2 0.2 0.2 0.01 4"
                    );
            }

            Vec3 _center2 = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center2, _center2).inflate(6.0), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center2)))
                .toList()) {
                if ((
                        entityiterator instanceof CorpseMateEntity
                            || entityiterator instanceof CorpseQuartermasterEntity
                            || entityiterator instanceof CorpseTankEntity
                            || entityiterator instanceof CorpseCaptainEntity
                            || entityiterator instanceof CorpseParrotEntity
                    )
                    && entityiterator.isAlive()
                    && entityiterator instanceof LivingEntity _entity) {
                    _entity.setHealth(
                        (float)(
                            (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1.0F) + Mth.nextDouble(RandomSource.create(), 5.0, 10.0)
                        )
                    );
                }
            }
        }

        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.WATER
            || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.WATER
            || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == Blocks.BUBBLE_COLUMN) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (entityiterator instanceof HealingRumProjectileEntity && !entityiterator.level().isClientSide()) {
                    entityiterator.discard();
                }
            }
        }
    }
}
