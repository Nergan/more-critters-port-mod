package com.morecritters.mod.procedures;

import java.util.Comparator;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.FrightshroomEntity;
import com.morecritters.mod.entity.RotZombieEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class FrightDeathProcedure {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof FrightshroomEntity) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof RotZombieEntity) {
                        if (entityiterator instanceof LivingEntity _entity) {
                            _entity.setHealth(0.0F);
                        }

                        if (!entityiterator.level().isClientSide()) {
                            entityiterator.discard();
                        }

                        if (world instanceof ServerLevel _level) {
                            _level.getServer()
                                .getCommands()
                                .performPrefixedCommand(
                                    new CommandSourceStack(
                                            CommandSource.NULL,
                                            new Vec3(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()),
                                            Vec2.ZERO,
                                            _level,
                                            4,
                                            "",
                                            Component.literal(""),
                                            _level.getServer(),
                                            null
                                        )
                                        .withSuppressedOutput(),
                                    "/particle more_critters:rot ~ ~1 ~ 0.2 0.5 0.2 0.05 25 force"
                                );
                        }
                    }
                }
            }
        }
    }
}
