package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.CarrybugEntity;
import com.morecritters.mod.entity.CarrybugNoSaddleEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;

public class CarrybugRightClickedOnEntityProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (ServerConfig.CONFIG.carrybugSaddle.get()
                && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.SHEARS) {
                if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                    ItemStack _ist = sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY;
                    if (world instanceof ServerLevel _serverLevel) {
                        _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                    }
                }

                if (sourceentity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")),
                            SoundSource.NEUTRAL,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sheep.shear")), SoundSource.NEUTRAL, 1.0F, 1.0F, false
                        );
                    }
                }

                if (world instanceof ServerLevel _level) {
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.SADDLE));
                    entityToSpawn.setPickUpDelay(10);
                    _level.addFreshEntity(entityToSpawn);
                }

                for (int index0 = 0; index0 < 3; index0++) {
                    if (world instanceof ServerLevel _level) {
                        ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.CHEST));
                        entityToSpawn.setPickUpDelay(10);
                        _level.addFreshEntity(entityToSpawn);
                    }
                }

                AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
                _iitemhandlerref.set(entity.getCapability(Capabilities.ItemHandler.ENTITY, null));
                if (_iitemhandlerref.get() != null) {
                    for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
                        ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
                        if (world instanceof ServerLevel _level) {
                            ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstackiterator);
                            entityToSpawn.setPickUpDelay(10);
                            _level.addFreshEntity(entityToSpawn);
                        }
                    }
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.CARRYBUG_NO_SADDLE
                        .get()
                        .spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_plains")) {
                    Entity var21 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var21 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_plains_nosaddle");
                    }
                } else if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_desert")) {
                    Entity var48 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var48 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_desert_nosaddle");
                    }
                } else if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_tundra")) {
                    Entity var49 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var49 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_tundra_nosaddle");
                    }
                } else if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_savanna")) {
                    Entity var50 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var50 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_savanna_nosaddle");
                    }
                } else if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_jungle")) {
                    Entity var51 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var51 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_jungle_nosaddle");
                    }
                } else if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_swamp")) {
                    Entity var52 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var52 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_swamp_nosaddle");
                    }
                } else if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_badlands")) {
                    Entity var53 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var53 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_badlands_nosaddle");
                    }
                } else if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_ocean")) {
                    Entity var54 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var54 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_ocean_nosaddle");
                    }
                } else if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_taiga")) {
                    Entity var55 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var55 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_taiga_nosaddle");
                    }
                } else if ((entity instanceof CarrybugEntity animatable ? animatable.getTexture() : "null").equals("carrybug_cave")) {
                    Entity var56 = world.getEntitiesOfClass(CarrybugNoSaddleEntity.class, AABB.ofSize(new Vec3(x, y, z), 2.0, 2.0, 2.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null);
                    if (var56 instanceof CarrybugNoSaddleEntity animatable) {
                        animatable.setTexture("carrybug_cave_nosaddle");
                    }
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }
            }
        }
    }
}
