package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.SlashEffectEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SlashEffectOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.setDeltaMovement(new Vec3(0.3 * entity.getLookAngle().x, 0.0, 0.3 * entity.getLookAngle().z));
            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            if (entity.getPersistentData().getDouble("timer") < 0.0 && !entity.level().isClientSide()) {
                entity.discard();
            }

            if (entity.getPersistentData().getDouble("timer") == 25.0 && entity instanceof SlashEffectEntity animatable) {
                animatable.setTexture("slash_effect2");
            }

            if (entity.getPersistentData().getDouble("timer") == 20.0 && entity instanceof SlashEffectEntity animatable) {
                animatable.setTexture("slash_effect3");
            }

            if (entity.getPersistentData().getDouble("timer") == 15.0 && entity instanceof SlashEffectEntity animatable) {
                animatable.setTexture("slash_effect4");
            }

            if (entity.getPersistentData().getDouble("timer") == 10.0 && entity instanceof SlashEffectEntity animatable) {
                animatable.setTexture("slash_effect5");
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2.5), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (entityiterator instanceof LivingEntity && !(entityiterator instanceof SlashEffectEntity) && !(entityiterator instanceof Player)) {
                    entityiterator.lookAt(Anchor.EYES, new Vec3(x, y, z));
                    entityiterator.push(-0.5 * entityiterator.getLookAngle().x, -0.5 * entityiterator.getLookAngle().y, -0.5 * entityiterator.getLookAngle().z);
                    entityiterator.hurt(
                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 3.0F
                    );
                }
            }
        }
    }
}
