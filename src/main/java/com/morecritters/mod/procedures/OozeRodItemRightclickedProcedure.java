package com.morecritters.mod.procedures;

import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class OozeRodItemRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity != null) {
            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == MoreCrittersModItems.OOZE_ROD.get()
                && !(entity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown(itemstack.getItem()))) {
                if (entity instanceof LivingEntity _entity) {
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (entity instanceof Player _player) {
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 50);
                }

                if (world instanceof ServerLevel _level) {
                    Vec3 look = entity.getLookAngle();
                    Vec3 motion = look.scale(1.5);
                    Entity entityToSpawn = MoreCrittersModEntities.FLYING_OOZE_ROD
                        .get()
                        .spawn(
                            _level,
                            BlockPos.containing(x + look.x, y + entity.getEyeHeight() * 0.5, z + look.z),
                            MobSpawnType.MOB_SUMMONED
                        );
                    if (entityToSpawn != null) {
                        entityToSpawn.setPos(x + look.x * 0.6, y + entity.getEyeHeight() - 0.2, z + look.z * 0.6);
                        entityToSpawn.setNoGravity(true);
                        entityToSpawn.setDeltaMovement(motion);
                        entityToSpawn.getPersistentData().putDouble("vx", motion.x);
                        entityToSpawn.getPersistentData().putDouble("vy", motion.y);
                        entityToSpawn.getPersistentData().putDouble("vz", motion.z);
                        if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                            itemstack.shrink(1);
                        }
                    }
                }
            }
        }
    }
}
