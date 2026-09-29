package com.morecritters.mod.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class TaserAttackedProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double Grow = 0.0;
            double TrackZ = 0.0;
            double TrackY = 0.0;
            double TrackX = 0.0;
            if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()) {
                Entity index0 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                    .stream()
                    .sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z))
                    .findFirst()
                    .orElse(null);
                if ((index0 instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.TASER.get()) {
                    TrackX = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                            .stream()
                            .sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z))
                            .findFirst()
                            .orElse(null)
                            .getX()
                        - entity.getX();
                    TrackY = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                            .stream()
                            .sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z))
                            .findFirst()
                            .orElse(null)
                            .getY()
                        - entity.getY()
                        + world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).stream().sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z)).findFirst().orElse(null).getBbHeight() * 0.75
                        - entity.getBbHeight() * 0.75;
                    TrackZ = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                            .stream()
                            .sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z))
                            .findFirst()
                            .orElse(null)
                            .getZ()
                        - entity.getZ();
                    Grow = Grow;

                    for (int index0x = 0; index0x < 20; index0x++) {
                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(
                                MoreCrittersModParticleTypes.ZAP_SPARK.get(),
                                world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                                        .stream()
                                        .sorted((new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }).compareDistOf(x, y, z))
                                        .findFirst()
                                        .orElse(null)
                                        .getX()
                                    + TrackX * Grow,
                                world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                                        .stream()
                                        .sorted((new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }).compareDistOf(x, y, z))
                                        .findFirst()
                                        .orElse(null)
                                        .getY()
                                    + world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                                            .stream()
                                            .sorted((new Object() {
                                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                                }
                                            }).compareDistOf(x, y, z))
                                            .findFirst()
                                            .orElse(null)
                                            .getBbHeight()
                                        * 0.75
                                    + TrackY * Grow,
                                world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true)
                                        .stream()
                                        .sorted((new Object() {
                                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                            }
                                        }).compareDistOf(x, y, z))
                                        .findFirst()
                                        .orElse(null)
                                        .getZ()
                                    + TrackZ * Grow,
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
