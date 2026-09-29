package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.EvoliteMawEntity;
import com.morecritters.mod.entity.EvolutionerEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class EvoliteMawOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 10, 0, false, false));
            }

            entity.getPersistentData().putDouble("despawning", 39.0);
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:witch ~ ~1 ~ 0.1 1 0.1 1 25 force"
                    );
            }

            MoreCritters.queueServerWork(
                10,
                () -> {
                    if (!world.isClientSide() && world instanceof Level _levelx) {
                        if (!_levelx.isClientSide()) {
                            _levelx.playSound(
                                (Player)null,
                                BlockPos.containing(x, y, z),
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker_fangs.attack")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F
                            );
                        } else {
                            _levelx.playLocalSound(
                                x,
                                y,
                                z,
                                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.evoker_fangs.attack")),
                                SoundSource.NEUTRAL,
                                1.0F,
                                1.0F,
                                false
                            );
                        }
                    }

                    if (entity instanceof EvoliteMawEntity) {
                        ((EvoliteMawEntity)entity).setAnimation("spawn");
                    }

                    MoreCritters.queueServerWork(
                        15,
                        () -> {
                            Vec3 _center = new Vec3(x, y, z);

                            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.5), e -> true)
                                .stream()
                                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                .toList()) {
                                if (!(entityiterator instanceof EvoliteMawEntity)
                                    && !(entityiterator instanceof EvolutionerEntity)
                                    && !(entityiterator instanceof Witch)
                                    && !(entityiterator instanceof Evoker)
                                    && !(entityiterator instanceof Pillager)
                                    && !(entityiterator instanceof Vindicator)
                                    && !(entityiterator instanceof Illusioner)) {
                                    entityiterator.hurt(
                                        new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
                                        7.0F
                                    );
                                }
                            }
                        }
                    );
                }
            );
        }
    }
}
