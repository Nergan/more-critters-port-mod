package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.RotPieceEntity;
import com.morecritters.mod.entity.RotSplashEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class RotSplashOnInitialEntitySpawnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            double sound = 0.0;
            if (entity instanceof RotSplashEntity) {
                ((RotSplashEntity)entity).setAnimation("start");
            }

            entity.getPersistentData().putDouble("timer", Mth.nextInt(RandomSource.create(), 100, 200));
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle more_critters:rot ~ ~ ~ 0.2 0 0.2 0.01 5 force"
                    );
            }

            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:block{block_state:\"minecraft:mycelium\"} ~ ~ ~ 0.3 0 0.3 0.01 2 force"
                    );
            }

            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1, false, false));
            }

            if (!world.isClientSide() && world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rot_splash.start")),
                        SoundSource.BLOCKS,
                        2.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x,
                        y,
                        z,
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.rot_splash.start")),
                        SoundSource.BLOCKS,
                        2.0F,
                        1.0F,
                        false
                    );
                }
            }

            if (world instanceof ServerLevel projectileLevel) {
                Projectile _entityToSpawn = (new Object() {
                    public Projectile getArrow(Level level, float damage, int knockback) {
                        RotPieceEntity entityToSpawn = new RotPieceEntity(MoreCrittersModEntities.ROT_PIECE.get(), level);
                        entityToSpawn.setBaseDamage(damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                    }
                }).getArrow(projectileLevel, 3.0F, 1);
                _entityToSpawn.setPos(x, y, z);
                _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 2.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 1.0F, 0.0F);
                projectileLevel.addFreshEntity(_entityToSpawn);
            }

            if (world instanceof ServerLevel projectileLevel) {
                Projectile _entityToSpawn = (new Object() {
                    public Projectile getArrow(Level level, float damage, int knockback) {
                        RotPieceEntity entityToSpawn = new RotPieceEntity(MoreCrittersModEntities.ROT_PIECE.get(), level);
                        entityToSpawn.setBaseDamage(damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                    }
                }).getArrow(projectileLevel, 3.0F, 1);
                _entityToSpawn.setPos(x, y, z);
                _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 2.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 1.0F, 0.0F);
                projectileLevel.addFreshEntity(_entityToSpawn);
            }

            if (world instanceof ServerLevel projectileLevel) {
                Projectile _entityToSpawn = (new Object() {
                    public Projectile getArrow(Level level, float damage, int knockback) {
                        RotPieceEntity entityToSpawn = new RotPieceEntity(MoreCrittersModEntities.ROT_PIECE.get(), level);
                        entityToSpawn.setBaseDamage(damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        return entityToSpawn;
                    }
                }).getArrow(projectileLevel, 3.0F, 1);
                _entityToSpawn.setPos(x, y, z);
                _entityToSpawn.shoot(Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 2.0, Mth.nextDouble(RandomSource.create(), -0.5, 0.5), 1.0F, 0.0F);
                projectileLevel.addFreshEntity(_entityToSpawn);
            }

            entity.getPersistentData().putDouble("size", 0.0);
        }
    }
}
