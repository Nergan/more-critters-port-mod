package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import java.util.Comparator;
import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class MossClumpOnBoneMealSuccessProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        BlockPos _bp = BlockPos.containing(x, y, z);
        BlockState _bs = Blocks.AIR.defaultBlockState();
        BlockState _bso = world.getBlockState(_bp);
        for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
            Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
            if (_property != null && _bs.getValue(_property) != null) {
                try {
                    _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                } catch (Exception var14) {
                }
            }
        }

        world.setBlock(_bp, _bs, 3);
        if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = MoreCrittersModEntities.BABY_ARMOSSILLO.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
                entityToSpawn.setYRot((float)Math.random());
                entityToSpawn.setYBodyRot((float)Math.random());
                entityToSpawn.setYHeadRot((float)Math.random());
                entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
            }
        }

        if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).isEmpty()) {
            Entity var18 = world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 20.0, 20.0, 20.0), e -> true).stream().sorted((new Object() {
                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                }
            }).compareDistOf(x, y, z)).findFirst().orElse(null);
            if (var18 instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:breed_armossillo"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }
        }
    }
}
