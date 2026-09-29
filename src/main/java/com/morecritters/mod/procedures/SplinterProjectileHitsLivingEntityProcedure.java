package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import com.morecritters.mod.entity.EchoEntity;
import com.morecritters.mod.entity.HealEchoEntity;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.MoriRootsEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import com.morecritters.mod.entity.ShockCubeSmallEntity;
import com.morecritters.mod.entity.ShriekbombProjectileEntity;
import com.morecritters.mod.entity.SplinterEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SplinterProjectileHitsLivingEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (!(entity instanceof AncientSkeletonEntity)
                && !(entity instanceof EchoEntity)
                && !(entity instanceof HealEchoEntity)
                && !(entity instanceof LargeEchoEntity)
                && !(entity instanceof MoriRootsEntity)
                && !(entity instanceof ShockCubeEntity)
                && !(entity instanceof ShockCubeSmallEntity)
                && !(entity instanceof WebEntityEntity)
                && !(entity instanceof ShriekbombProjectileEntity)
                && !(entity instanceof AncientSkeletonExhibitEntity)) {
                if (entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                        _entity.addEffect(
                            new MobEffectInstance(
                                MobEffects.MOVEMENT_SLOWDOWN,
                                60,
                                (
                                        entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)
                                            ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier()
                                            : 0
                                    )
                                    + 1,
                                false,
                                true
                            )
                        );
                    }
                } else if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, true));
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.eerie_dart.hit")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.eerie_dart.hit")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            } else {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof SplinterEntity && !entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                    }
                }
            }
        }
    }
}
