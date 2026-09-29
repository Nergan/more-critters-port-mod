package com.morecritters.mod.procedures;

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
import com.morecritters.mod.entity.ThrownInfestedHardtackEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ThrownInfestedHardtackProjectileHitsLivingEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
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
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:item{item:\"more_critters:hardtack\"} ~ ~1 ~ 0.2 0.2 0.2 0.01 5 force"
                        );
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.STUNNED, 60, 0, false, false));
                }
            } else {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof ThrownInfestedHardtackEntity && !entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                    }
                }
            }
        }
    }
}
