package com.morecritters.mod.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.CustodianEntity;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class LazerCustodianProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(
                event,
                event.getEntity().level(),
                event.getEntity().getX(),
                event.getEntity().getY(),
                event.getEntity().getZ(),
                event.getEntity(),
                event.getSource().getEntity()
            );
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        execute(null, world, x, y, z, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            double Grow = 0.0;
            double TrackZ = 0.0;
            double TrackY = 0.0;
            double TrackX = 0.0;
            if (sourceentity == entity) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof CustodianEntity && entityiterator.getPersistentData().getDouble("shot") > 0.0) {
                        TrackX = entityiterator.getX() - entity.getX();
                        TrackY = entityiterator.getY() - entity.getY() + (entityiterator.getBbHeight() * 0.75 + 2.0) - entity.getBbHeight() * 0.75;
                        TrackZ = entityiterator.getZ() - entity.getZ();
                        Grow = Grow;

                        for (int index0 = 0; index0 < 20; index0++) {
                            if (world instanceof ServerLevel _level) {
                                _level.sendParticles(
                                    MoreCrittersModParticleTypes.CUSTODIAN_LAZER.get(),
                                    entityiterator.getX() + TrackX * Grow,
                                    entityiterator.getY() + entityiterator.getBbHeight() * 0.75 + 0.8 + TrackY * Grow,
                                    entityiterator.getZ() + TrackZ * Grow,
                                    5,
                                    0.05,
                                    0.05,
                                    0.05,
                                    0.0
                                );
                            }

                            if (world instanceof ServerLevel _level) {
                                _level.sendParticles(
                                    ParticleTypes.SMOKE,
                                    entityiterator.getX() + TrackX * Grow,
                                    entityiterator.getY() + entityiterator.getBbHeight() * 0.75 + 0.8 + TrackY * Grow,
                                    entityiterator.getZ() + TrackZ * Grow,
                                    5,
                                    0.05,
                                    0.05,
                                    0.05,
                                    0.0
                                );
                            }

                            Grow -= 0.05;
                        }
                    }
                }
            }
        }
    }
}
