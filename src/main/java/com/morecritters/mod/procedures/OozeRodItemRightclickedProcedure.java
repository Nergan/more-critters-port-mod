package com.morecritters.mod.procedures;

import java.util.Comparator;
import com.morecritters.mod.entity.FlyingOozeRodEntity;
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
import net.minecraft.world.phys.AABB;
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

                if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                    (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
                }

                if (world instanceof ServerLevel _level) {
                    Entity entityToSpawn = MoreCrittersModEntities.FLYING_OOZE_ROD
                        .get()
                        .spawn(_level, BlockPos.containing(x - 0.0, y + entity.getBbHeight() + 0.0, z - 0.0), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                    }
                }

                if (!world.getEntitiesOfClass(FlyingOozeRodEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).isEmpty()) {
                    world.getEntitiesOfClass(FlyingOozeRodEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null)
                        .setDeltaMovement(new Vec3(3.0 * entity.getLookAngle().x, 3.0 * entity.getLookAngle().y, 3.0 * entity.getLookAngle().z));
                }
            }
        }
    }
}
