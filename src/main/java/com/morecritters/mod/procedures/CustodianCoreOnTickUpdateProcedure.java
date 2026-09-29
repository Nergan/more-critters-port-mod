package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Comparator;
import com.morecritters.mod.entity.CustodianEntity;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CustodianCoreOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing(x, y + 1.0, z)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x + 1.0, y - 1.0, z)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x + 1.0, y - 0.0, z)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x - 1.0, y - 1.0, z)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x - 1.0, y - 0.0, z)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z + 1.0)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x, y - 0.0, z + 1.0)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x, y + 1.0, z + 1.0)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x, y - 1.0, z - 1.0)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x, y - 0.0, z - 1.0)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x, y + 1.0, z - 1.0)).getBlock() == Blocks.DEEPSLATE_BRICKS
            && world.getBlockState(BlockPos.containing(x + 1.0, y + -1.0, z + 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x + 1.0, y + 0.0, z + 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z + 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x - 1.0, y + -1.0, z + 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x - 1.0, y + 0.0, z + 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z + 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x - 1.0, y + -1.0, z - 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x - 1.0, y + 0.0, z - 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x - 1.0, y + 1.0, z - 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x + 1.0, y + -1.0, z - 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x + 1.0, y + 0.0, z - 1.0)).getBlock() == Blocks.BONE_BLOCK
            && world.getBlockState(BlockPos.containing(x + 1.0, y + 1.0, z - 1.0)).getBlock() == Blocks.BONE_BLOCK) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
            world.destroyBlock(BlockPos.containing(x + -1.0, y + -1.0, z + -1.0), false);
            world.destroyBlock(BlockPos.containing(x + -1.0, y + 0.0, z + -1.0), false);
            world.destroyBlock(BlockPos.containing(x + -1.0, y + 1.0, z + -1.0), false);
            world.destroyBlock(BlockPos.containing(x + 0.0, y + -1.0, z + -1.0), false);
            world.destroyBlock(BlockPos.containing(x + 0.0, y + 0.0, z + -1.0), false);
            world.destroyBlock(BlockPos.containing(x + 0.0, y + 1.0, z + -1.0), false);
            world.destroyBlock(BlockPos.containing(x + 1.0, y + -1.0, z + -1.0), false);
            world.destroyBlock(BlockPos.containing(x + 1.0, y + 0.0, z + -1.0), false);
            world.destroyBlock(BlockPos.containing(x + 1.0, y + 1.0, z + -1.0), false);
            world.destroyBlock(BlockPos.containing(x + -1.0, y + -1.0, z + 0.0), false);
            world.destroyBlock(BlockPos.containing(x + -1.0, y + 0.0, z + 0.0), false);
            world.destroyBlock(BlockPos.containing(x + -1.0, y + 1.0, z + 0.0), false);
            world.destroyBlock(BlockPos.containing(x + 0.0, y + -1.0, z + 0.0), false);
            world.destroyBlock(BlockPos.containing(x + 0.0, y + 1.0, z + 0.0), false);
            world.destroyBlock(BlockPos.containing(x + 1.0, y + -1.0, z + 0.0), false);
            world.destroyBlock(BlockPos.containing(x + 1.0, y + 0.0, z + 0.0), false);
            world.destroyBlock(BlockPos.containing(x + 1.0, y + 1.0, z + 0.0), false);
            world.destroyBlock(BlockPos.containing(x + -1.0, y + -1.0, z + 1.0), false);
            world.destroyBlock(BlockPos.containing(x + -1.0, y + 0.0, z + 1.0), false);
            world.destroyBlock(BlockPos.containing(x + -1.0, y + 1.0, z + 1.0), false);
            world.destroyBlock(BlockPos.containing(x + 0.0, y + -1.0, z + 1.0), false);
            world.destroyBlock(BlockPos.containing(x + 0.0, y + 0.0, z + 1.0), false);
            world.destroyBlock(BlockPos.containing(x + 0.0, y + 1.0, z + 1.0), false);
            world.destroyBlock(BlockPos.containing(x + 1.0, y + -1.0, z + 1.0), false);
            world.destroyBlock(BlockPos.containing(x + 1.0, y + 0.0, z + 1.0), false);
            world.destroyBlock(BlockPos.containing(x + 1.0, y + 1.0, z + 1.0), false);
            if (world instanceof ServerLevel _level) {
                Entity entityToSpawn = MoreCrittersModEntities.CUSTODIAN.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setDeltaMovement(0.0, 0.0, 0.0);
                }
            }

            if (!world.isClientSide() && world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(
                        (Player)null,
                        BlockPos.containing(x, y, z),
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.open")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F
                    );
                } else {
                    _level.playLocalSound(
                        x,
                        y,
                        z,
                        BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.custodian.open")),
                        SoundSource.NEUTRAL,
                        1.0F,
                        1.0F,
                        false
                    );
                }
            }

            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12.5), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 25.0, 25.0, 25.0), e -> true).isEmpty()
                    && entityiterator instanceof Player
                    && entityiterator instanceof ServerPlayer _player) {
                    AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:create_custodian"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        for (String criteria : _ap.getRemainingCriteria()) {
                            _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
            }

            if (world.getEntitiesOfClass(CustodianEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true).stream().sorted((new Object() {
                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                    return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                }
            }).compareDistOf(x, y, z)).findFirst().orElse(null) instanceof CustodianEntity) {
                ((CustodianEntity)world.getEntitiesOfClass(CustodianEntity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), e -> true)
                        .stream()
                        .sorted((new Object() {
                            Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                            }
                        }).compareDistOf(x, y, z))
                        .findFirst()
                        .orElse(null))
                    .setAnimation("openup");
            }
        }
    }
}
