package com.morecritters.mod.procedures;

import javax.annotation.Nullable;
import com.morecritters.mod.entity.FrightshroomEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class FrightshroomAttackProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, Entity sourceentity) {
        execute(null, world, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity) {
        if (sourceentity != null) {
            if (sourceentity instanceof FrightshroomEntity) {
                for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 2.0, 3.0); index0++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL,
                                        new Vec3(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()),
                                        Vec2.ZERO,
                                        _level,
                                        4,
                                        "",
                                        Component.literal(""),
                                        _level.getServer(),
                                        null
                                    )
                                    .withSuppressedOutput(),
                                "/particle more_critters:rot ~ ~2 ~ 0.5 0.5 0.5 0 5 force"
                            );
                    }
                }
            }
        }
    }
}
