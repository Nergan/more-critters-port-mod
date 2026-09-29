package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.AncientCustodianEntity;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import com.morecritters.mod.entity.CustodianEntity;
import com.morecritters.mod.entity.EchoEntity;
import com.morecritters.mod.entity.HealEchoEntity;
import com.morecritters.mod.entity.IroballEntity;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.MoriRootsEntity;
import com.morecritters.mod.entity.RotSplashEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import com.morecritters.mod.entity.ShockCubeSmallEntity;
import com.morecritters.mod.entity.ShriekbatEntity;
import com.morecritters.mod.entity.ShriekbombProjectileEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ShriekbombProjectileProjectileHitsBlockProcedure {
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
                && !(entity instanceof AncientSkeletonExhibitEntity)
                && !(entity instanceof AncientCustodianEntity)
                && !(entity instanceof CustodianEntity)
                && !(entity instanceof IroballEntity)
                && !(entity instanceof RotSplashEntity)) {
                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.LARGE_ECHO
                        .get()
                        .spawn(_level, BlockPos.containing(x, y + 1.0, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriek_bomb.shriek")),
                            SoundSource.AMBIENT,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriek_bomb.shriek")),
                            SoundSource.AMBIENT,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (!(entityiterator instanceof ShriekbatEntity)
                        && !(entityiterator instanceof AncientSkeletonEntity)
                        && !(entityiterator instanceof AncientSkeletonExhibitEntity)
                        && !(entityiterator instanceof AncientCustodianEntity)
                        && !(entityiterator instanceof CustodianEntity)
                        && !(entityiterator instanceof RotSplashEntity)
                        && !(entityiterator instanceof IroballEntity)
                        && entityiterator instanceof Mob _entity) {
                        _entity.getNavigation().moveTo(x, y, z, 2.0);
                    }
                }
            } else {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof ShriekbombProjectileEntity && !entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                    }
                }
            }
        }
    }
}
