package com.morecritters.mod.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import com.morecritters.mod.entity.CubefrogEntity;
import com.morecritters.mod.entity.DungerEntity;
import com.morecritters.mod.entity.EchoEntity;
import com.morecritters.mod.entity.HealEchoEntity;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.MightshroomEchoEntity;
import com.morecritters.mod.entity.OpalcrabEntity;
import com.morecritters.mod.entity.PinkMonsterEntity;
import com.morecritters.mod.entity.PlainswyrmEntity;
import com.morecritters.mod.entity.RollballEntity;
import com.morecritters.mod.entity.ScowlEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import com.morecritters.mod.entity.ShockCubeSmallEntity;
import com.morecritters.mod.entity.SmallHealEchoEntity;
import com.morecritters.mod.entity.SnekEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import com.morecritters.mod.item.TaserItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TaserRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity != null) {
            double TrackX = 0.0;
            double TrackY = 0.0;
            double TrackZ = 0.0;
            double Grow = 0.0;
            double rate = 0.0;
            if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
                if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 12.0, 12.0, 12.0), e -> true).isEmpty()
                    && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.taser.tase")),
                            SoundSource.PLAYERS,
                            2.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.taser.tase")),
                            SoundSource.PLAYERS,
                            2.0F,
                            1.0F,
                            false
                        );
                    }
                }

                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof LivingEntity
                        && !(
                            entityiterator instanceof TamableAnimal _tamIsTamedBy && entity instanceof LivingEntity _livEnt && _tamIsTamedBy.isOwnedBy(_livEnt)
                        )
                        && !(entityiterator instanceof EchoEntity)
                        && !(entityiterator instanceof LargeEchoEntity)
                        && !(entityiterator instanceof PinkMonsterEntity)
                        && !(entityiterator instanceof WebEntityEntity)
                        && !(entityiterator instanceof ShockCubeEntity)
                        && !(entityiterator instanceof ShockCubeSmallEntity)
                        && !(entityiterator instanceof AncientSkeletonEntity)
                        && !(entityiterator instanceof HealEchoEntity)
                        && !(entityiterator instanceof SmallHealEchoEntity)
                        && !(entityiterator instanceof MightshroomEchoEntity)
                        && !(entityiterator instanceof CubefrogEntity)
                        && !(entityiterator instanceof RollballEntity)
                        && !(entityiterator instanceof ScowlEntity)
                        && !(entityiterator instanceof PlainswyrmEntity)
                        && !(entityiterator instanceof DungerEntity)
                        && !(entityiterator instanceof SnekEntity)
                        && !(entityiterator instanceof SnekEntity)
                        && !(entityiterator instanceof OpalcrabEntity)
                        && !(entityiterator instanceof AncientSkeletonExhibitEntity)
                        && entityiterator != entity) {
                        if (itemstack.getItem() instanceof TaserItem) {
                            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString("geckoAnim", "taze"));
                        }

                        if (entity instanceof Player _player) {
                            _player.getCooldowns().addCooldown(itemstack.getItem(), 20);
                        }

                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                            ItemStack _ist = itemstack;
                            if (world instanceof ServerLevel _serverLevel) {
                                _ist.hurtAndBreak(1, _serverLevel, null, _item -> {});
                            }
                        }

                        entityiterator.hurt(
                            new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                            (float)Mth.nextDouble(RandomSource.create(), 5.0, 9.0)
                        );
                        if (world instanceof ServerLevel _level) {
                            _level.sendParticles(
                                MoreCrittersModParticleTypes.ZAP.get(),
                                entityiterator.getX(),
                                entityiterator.getY(),
                                entityiterator.getZ(),
                                5,
                                0.5,
                                0.5,
                                0.5,
                                0.0
                            );
                        }
                    }
                }
            }
        }
    }
}
