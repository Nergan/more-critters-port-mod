package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.ShadeletEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SpookedEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 49, false, false));
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0, false, true));
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.0), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (entityiterator instanceof ShadeletEntity) {
                    entity.lookAt(Anchor.EYES, new Vec3(entityiterator.getX(), entityiterator.getY() + entityiterator.getBbHeight(), entityiterator.getZ()));
                }
            }
        }
    }
}
