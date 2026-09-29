package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.KelpireEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class KelpireOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean found = false;
            double sx = 0.0;
            double sy = 0.0;
            double sz = 0.0;
            if (entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame()) {
                if (!entity.getDisplayName().getString().equals("Crusty") && !entity.getDisplayName().getString().equals("crusty")) {
                    if (entity instanceof KelpireEntity animatable) {
                        animatable.setTexture("kelpire_tamed");
                    }
                } else if (entity instanceof KelpireEntity animatable) {
                    animatable.setTexture("kelpire_crusty");
                }

                if (!(entity instanceof KelpireEntity _datEntL5 && _datEntL5.getEntityData().get(KelpireEntity.DATA_sit))
                    && !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)) {
                    Vec3 _center = new Vec3(x, y, z);

                    for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50.0), e -> true)
                        .stream()
                        .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                        .toList()) {
                        if (entityiterator == (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) && entity instanceof Mob _entity) {
                            _entity.getNavigation()
                                .moveTo(
                                    (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getX(),
                                    (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getY(),
                                    (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getZ(),
                                    1.0
                                );
                        }
                    }
                }
            } else if (world.getBlockState(BlockPos.containing(x + 1.0, y, z)).getBlock() != Blocks.KELP_PLANT
                && world.getBlockState(BlockPos.containing(x - 1.0, y, z)).getBlock() != Blocks.KELP_PLANT
                && world.getBlockState(BlockPos.containing(x, y, z + 1.0)).getBlock() != Blocks.KELP_PLANT
                && world.getBlockState(BlockPos.containing(x, y, z - 1.0)).getBlock() != Blocks.KELP_PLANT
                && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != Blocks.KELP_PLANT) {
                if (!entity.getDisplayName().getString().equals("Crusty") && !entity.getDisplayName().getString().equals("crusty")) {
                    if (entity instanceof KelpireEntity animatable) {
                        animatable.setTexture("kelpire");
                    }
                } else if (entity instanceof KelpireEntity animatable) {
                    animatable.setTexture("kelpire_crusty");
                }
            } else if (!entity.getDisplayName().getString().equals("Crusty") && !entity.getDisplayName().getString().equals("crusty")) {
                if (entity instanceof KelpireEntity animatable) {
                    animatable.setTexture("kelpire_invisible");
                }
            } else if (entity instanceof KelpireEntity animatable) {
                animatable.setTexture("kelpire_crusty");
            }

            if (entity instanceof KelpireEntity _datEntL36
                && _datEntL36.getEntityData().get(KelpireEntity.DATA_sit)
                && entity.isInWaterOrBubble()
                && entity instanceof KelpireEntity) {
                ((KelpireEntity)entity).setAnimation("sitting");
            }

            if (!(entity instanceof KelpireEntity _datEntL39 && _datEntL39.getEntityData().get(KelpireEntity.DATA_sit))
                && entity.isInWaterOrBubble()
                && !((entity instanceof Mob _mobEnt ? _mobEnt.getTarget() : null) instanceof LivingEntity)
                && entity instanceof TamableAnimal _tamEnt
                && _tamEnt.isTame()
                && (
                        (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null) != null
                            ? entity.distanceTo(entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null)
                            : -1.0F
                    )
                    >= 15.0F
                && (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).isInWaterOrBubble()) {
                Entity _ent = entity;
                _ent.teleportTo(
                    (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getX(),
                    (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getY(),
                    (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getZ()
                );
                if (_ent instanceof ServerPlayer _serverPlayer) {
                    _serverPlayer.connection
                        .teleport(
                            (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getX(),
                            (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getY(),
                            (entity instanceof TamableAnimal _tamEntx ? _tamEntx.getOwner() : null).getZ(),
                            _ent.getYRot(),
                            _ent.getXRot()
                        );
                }
            }

            if (entity instanceof LivingEntity _livEnt55 && _livEnt55.isBaby()) {
                entity.getPersistentData().putDouble("size", 0.5);
            } else {
                entity.getPersistentData().putDouble("size", 1.2);
            }

            entity.getPersistentData().putDouble("down", entity.getPersistentData().getDouble("down") - 1.0);
            if (entity.getPersistentData().getDouble("down") <= -1.0) {
                entity.getPersistentData().putDouble("down", Mth.nextInt(RandomSource.create(), 60, 200));
                if (world.getBlockState(BlockPos.containing(x, y + 2.0, z)).getBlock() == Blocks.AIR
                    && !(entity instanceof TamableAnimal _tamEnt && _tamEnt.isTame())
                    && entity instanceof Mob _entity) {
                    _entity.getNavigation().moveTo(x, y - 5.0, z, 1.0);
                }
            }

            if (!entity.isInWaterOrBubble()) {
                if (entity instanceof KelpireEntity) {
                    ((KelpireEntity)entity).setAnimation("land");
                }
            } else if (((KelpireEntity)entity).animationprocedure.equals("land") && entity instanceof KelpireEntity) {
                ((KelpireEntity)entity).setAnimation("empty");
            }

            if (entity.isInWaterOrBubble()) {
                entity.getPersistentData().putDouble("air", 200.0);
            } else {
                entity.getPersistentData().putDouble("air", entity.getPersistentData().getDouble("air") - 1.0);
            }

            if (entity.getPersistentData().getDouble("air") <= 1.0) {
                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DRY_OUT)), 1.0F);
                entity.getPersistentData().putDouble("air", 20.0);
            }
        }
    }
}
