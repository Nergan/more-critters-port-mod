package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.EchoEntity;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.MightshroomEchoEntity;
import com.morecritters.mod.entity.MightshroomEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MightshroomEchoTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            entity.lookAt(Anchor.EYES, new Vec3(x, y, z));
            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            if (entity.getPersistentData().getDouble("timer") < 0.0 && !entity.level().isClientSide()) {
                entity.discard();
            }

            if (entity.getPersistentData().getDouble("timer") == 30.0 && entity instanceof MightshroomEchoEntity animatable) {
                animatable.setTexture("mightshroom_echo1");
            }

            if (entity.getPersistentData().getDouble("timer") == 20.0 && entity instanceof MightshroomEchoEntity animatable) {
                animatable.setTexture("mightshroom_echo2");
            }

            if (entity.getPersistentData().getDouble("timer") == 10.0 && entity instanceof MightshroomEchoEntity animatable) {
                animatable.setTexture("mightshroom_echo3");
            }

            rate = Mth.nextInt(RandomSource.create(), 1, 6);
            if (rate == 1.0) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (!(entityiterator instanceof ShockCubeEntity)
                        && !(entityiterator instanceof EchoEntity)
                        && !(entityiterator instanceof LargeEchoEntity)
                        && !(entityiterator instanceof MightshroomEntity)
                        && !(entityiterator instanceof MightshroomEchoEntity)) {
                        entityiterator.hurt(
                            new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.LIGHTNING_BOLT)),
                            (float)Mth.nextDouble(RandomSource.create(), 2.0, 6.0)
                        );
                    }
                }
            }
        }
    }
}
