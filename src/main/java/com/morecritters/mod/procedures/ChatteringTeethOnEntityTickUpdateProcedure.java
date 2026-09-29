package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.AncientCustodianEntity;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import com.morecritters.mod.entity.ChatteringTeethEntity;
import com.morecritters.mod.entity.CustodianEntity;
import com.morecritters.mod.entity.EchoEntity;
import com.morecritters.mod.entity.HealEchoEntity;
import com.morecritters.mod.entity.IroballEntity;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.MoriRootsEntity;
import com.morecritters.mod.entity.RotSplashEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import com.morecritters.mod.entity.ShockCubeSmallEntity;
import com.morecritters.mod.entity.ShriekbombProjectileEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ChatteringTeethOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.0), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (!(entityiterator instanceof ChatteringTeethEntity)) {
                    if (!(entityiterator instanceof ItemEntity)) {
                        if (!(entityiterator instanceof AncientSkeletonEntity)
                            && !(entityiterator instanceof EchoEntity)
                            && !(entityiterator instanceof HealEchoEntity)
                            && !(entityiterator instanceof LargeEchoEntity)
                            && !(entityiterator instanceof MoriRootsEntity)
                            && !(entityiterator instanceof ShockCubeEntity)
                            && !(entityiterator instanceof ShockCubeSmallEntity)
                            && !(entityiterator instanceof WebEntityEntity)
                            && !(entityiterator instanceof ShriekbombProjectileEntity)
                            && !(entityiterator instanceof AncientSkeletonExhibitEntity)
                            && !(entityiterator instanceof AncientCustodianEntity)
                            && !(entityiterator instanceof CustodianEntity)
                            && !(entityiterator instanceof IroballEntity)
                            && !(entityiterator instanceof RotSplashEntity)) {
                            entityiterator.hurt(
                                new DamageSource(
                                    world.registryAccess()
                                        .registryOrThrow(Registries.DAMAGE_TYPE)
                                        .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("more_critters:chatter")))
                                ),
                                5.0F
                            );
                        }

                        if (entity.onGround()) {
                            entity.push(0.05 * entity.getLookAngle().x, -0.5, 0.05 * entity.getLookAngle().z);
                        }
                    } else if (entity.onGround()) {
                        entity.push(0.1 * entity.getLookAngle().x, -0.5, 0.1 * entity.getLookAngle().z);
                    }
                } else if (entity.onGround()) {
                    entity.push(0.1 * entity.getLookAngle().x, -0.5, 0.1 * entity.getLookAngle().z);
                }
            }

            entity.setSprinting(true);
            if (entity.isInWaterOrBubble()) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.CHATTERING_TEETH_ITEM.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.chattering_teeth.end")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.chattering_teeth.end")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }

            if (world.getBlockState(BlockPos.containing(x + 0.5, y, z)).canOcclude()
                || world.getBlockState(BlockPos.containing(x - 0.5, y, z)).canOcclude()
                || world.getBlockState(BlockPos.containing(x, y, z + 0.5)).canOcclude()
                || world.getBlockState(BlockPos.containing(x, y, z - 0.5)).canOcclude()) {
                if (!entity.level().isClientSide()) {
                    entity.discard();
                }

                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MoreCrittersModItems.CHATTERING_TEETH_ITEM.get()));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.chattering_teeth.end")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.chattering_teeth.end")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }
            }
        }
    }
}
