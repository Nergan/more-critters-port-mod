package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WebEntityOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            entity.lookAt(Anchor.EYES, new Vec3(x, y, z));
            Entity index0 = world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true)
                .stream()
                .sorted((new Object() {
                    Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                        return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                    }
                }).compareDistOf(x, y, z))
                .findFirst()
                .orElse(null);
            if (!(index0 instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MoreCrittersModMobEffects.WEBBED))
                && entity
                    == world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 1.0, 1.0, 1.0), e -> true).stream().sorted((new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }).compareDistOf(x, y, z)).findFirst().orElse(null)) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                for (int index0x = 0; index0x < Mth.nextInt(RandomSource.create(), 2, 5); index0x++) {
                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:block{block_state:\"more_critters:freezing_cobweb\"} ~ ~ ~ 0.2 0.2 0.2 0.03 10 force"
                            );
                    }

                    if (world instanceof ServerLevel _level) {
                        _level.getServer()
                            .getCommands()
                            .performPrefixedCommand(
                                new CommandSourceStack(
                                        CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                    )
                                    .withSuppressedOutput(),
                                "/particle minecraft:block{block_state:\"more_critters:freezing_cobweb\"} ~ ~1 ~ 0.2 0.2 0.2 0.03 10 force"
                            );
                    }
                }
            }
        }
    }
}
