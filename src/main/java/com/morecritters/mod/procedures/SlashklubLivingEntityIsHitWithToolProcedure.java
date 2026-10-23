package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.entity.SlashEffectEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class SlashklubLivingEntityIsHitWithToolProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
        if (entity != null && sourceentity != null) {
            if (!(sourceentity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))
                && sourceentity.isShiftKeyDown()) {
                if (sourceentity instanceof Player _player) {
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 100);
                }

                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MoreCrittersModMobEffects.TREMBLE, 20, 0, false, false));
                }

                if (world instanceof ServerLevel _level) {
                    SlashEffectEntity slash = MoreCrittersModEntities.SLASH_EFFECT.get().create(_level);
                    if (slash != null) {
                        slash.moveTo(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ(), sourceentity.getYRot(), sourceentity.getXRot());
                        slash.setYBodyRot(sourceentity.getYRot());
                        slash.yBodyRotO = sourceentity.getYRot();
                        slash.setYHeadRot(sourceentity.getYRot());
                        slash.yHeadRotO = sourceentity.getYRot();
                        slash.finalizeSpawn(_level, _level.getCurrentDifficultyAt(slash.blockPosition()), MobSpawnType.MOB_SUMMONED, null);
                        _level.addFreshEntity(slash);
                    }
                }

                if (!world.isClientSide() && world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(
                            (Player)null,
                            BlockPos.containing(x, y, z),
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.slashklub.attack")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F
                        );
                    } else {
                        _level.playLocalSound(
                            x,
                            y,
                            z,
                            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:item.slashklub.attack")),
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F,
                            false
                        );
                    }
                }

                if (!(sourceentity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                    ItemStack _ist = itemstack;
                    if (world instanceof ServerLevel _serverLevel) {
                        _ist.hurtAndBreak(3, _serverLevel, null, _item -> {});
                    }
                }
            }
        }
    }
}
