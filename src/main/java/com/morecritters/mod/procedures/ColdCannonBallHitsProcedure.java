package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.ColdCannonBallProjectileEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ColdCannonBallHitsProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof Level _level && !_level.isClientSide()) {
            _level.explode(null, x, y, z, 4.0F, ExplosionInteraction.BLOCK);
        }

        if (!world.getEntitiesOfClass(ColdCannonBallProjectileEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()
            && !world.getEntitiesOfClass(ColdCannonBallProjectileEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                .stream()
                .sorted((new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }).compareDistOf(x, y, z))
                .findFirst()
                .orElse(null)
                .level()
                .isClientSide()) {
            world.getEntitiesOfClass(ColdCannonBallProjectileEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                .stream()
                .sorted((new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }).compareDistOf(x, y, z))
                .findFirst()
                .orElse(null)
                .discard();
        }

        if (world instanceof ServerLevel _level) {
            _level.getServer()
                .getCommands()
                .performPrefixedCommand(
                    new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                    "/particle minecraft:snowflake ~ ~ ~ 2 2 2 0.01 10 force"
                );
        }

        Vec3 _center = new Vec3(x, y, z);

        for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7.5), e -> true)
            .stream()
            .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
            .toList()) {
            if (entityiterator instanceof LivingEntity && entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.FROSTBITE, 400, 0, false, true));
            }
        }

        if (!world.isClientSide() && world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(
                    (Player)null,
                    BlockPos.containing(x, y, z),
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.cannon_ball_cold.hit")),
                    SoundSource.BLOCKS,
                    2.0F,
                    1.0F
                );
            } else {
                _level.playLocalSound(
                    x,
                    y,
                    z,
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.cannon_ball_cold.hit")),
                    SoundSource.BLOCKS,
                    2.0F,
                    1.0F,
                    false
                );
            }
        }
    }
}
