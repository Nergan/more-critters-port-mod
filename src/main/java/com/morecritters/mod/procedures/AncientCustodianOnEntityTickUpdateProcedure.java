package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.AncientCustodianEntity;
import com.morecritters.mod.entity.CustodianEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AncientCustodianOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if ((entity instanceof AncientCustodianEntity _datEntI ? _datEntI.getEntityData().get(AncientCustodianEntity.DATA_fed) : 0) == 1) {
                if (entity instanceof AncientCustodianEntity) {
                    ((AncientCustodianEntity)entity).setAnimation("feed1");
                }
            } else if ((entity instanceof AncientCustodianEntity _datEntI ? _datEntI.getEntityData().get(AncientCustodianEntity.DATA_fed) : 0) == 2) {
                if (entity instanceof AncientCustodianEntity) {
                    ((AncientCustodianEntity)entity).setAnimation("feed2");
                }
            } else if ((entity instanceof AncientCustodianEntity _datEntI ? _datEntI.getEntityData().get(AncientCustodianEntity.DATA_fed) : 0) == 3
                && !((AncientCustodianEntity)entity).animationprocedure.equals("openup")) {
                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.open")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.open")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (entity instanceof AncientCustodianEntity) {
                    ((AncientCustodianEntity)entity).setAnimation("openup");
                }

                MoreCritters.queueServerWork(
                    35,
                    () -> {
                        if (!entity.level().isClientSide()) {
                            entity.discard();
                        }

                        if (world instanceof ServerLevel _levelx) {
                            Entity entityToSpawn = MoreCrittersModEntities.CUSTODIAN
                                .get()
                                .spawn(_levelx, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                            if (entityToSpawn != null) {
                                entityToSpawn.setYRot(entity.getYRot());
                                entityToSpawn.setYBodyRot(entity.getYRot());
                                entityToSpawn.setYHeadRot(entity.getYRot());
                                entityToSpawn.setXRot(entity.getXRot());
                                entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                            }
                        }

                        Entity patt3387$temp = world.getEntitiesOfClass(CustodianEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                            .stream()
                            .sorted((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                                }
                            }).compareDistOf(x, y, z))
                            .findFirst()
                            .orElse(null);
                        if (patt3387$temp instanceof CustodianEntity animatable) {
                            animatable.setTexture("ancient_custodian");
                        }
                    }
                );
            }
        }
    }
}
