package com.morecritters.mod.procedures;

import net.minecraft.tags.EntityTypeTags;
import java.util.Comparator;
import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class NervoidBrainOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        double rate = 0.0;
        double rate2 = 0.0;
        if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != MoreCrittersModBlocks.NERVOID_BRAIN.get()
            && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() != MoreCrittersModBlocks.ICED_NERVOID_BRAIN.get()) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.DECOMPOSING_NERVOID_BRAIN.get()
                || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.ICED_DECOMPOSING_NERVOID_BRAIN.get()) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof LivingEntity _livEnt16 && _livEnt16.getType().is(EntityTypeTags.UNDEAD) && entityiterator instanceof Mob _entity) {
                        _entity.getNavigation().moveTo(x, y, z, 1.0);
                    }
                }

                Vec3 _center2 = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center2, _center2).inflate(0.5), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center2)))
                    .toList()) {
                    if (entityiterator instanceof LivingEntity _livEnt19 && _livEnt19.getType().is(EntityTypeTags.UNDEAD)) {
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(world.getBlockState(BlockPos.containing(x, y, z))));
                        BlockPos _pos = BlockPos.containing(x, y, z);
                        Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
                        world.destroyBlock(_pos, false);
                    }
                }
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.ROTTEN_NERVOID_BRAIN.get()
                || world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.ICED_ROTTEN_NERVOID_BRAIN.get()) {
                Vec3 _center = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5.0), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList()) {
                    if (entityiterator instanceof LivingEntity _livEnt28 && _livEnt28.getType().is(EntityTypeTags.UNDEAD) && entityiterator instanceof Mob _entity) {
                        _entity.getNavigation().moveTo(x, y, z, 1.0);
                    }
                }

                Vec3 _center3 = new Vec3(x, y, z);

                for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center3, _center3).inflate(0.5), e -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center3)))
                    .toList()) {
                    if (entityiterator instanceof LivingEntity _livEnt31 && _livEnt31.getType().is(EntityTypeTags.UNDEAD)) {
                        world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(world.getBlockState(BlockPos.containing(x, y, z))));
                        BlockPos _pos = BlockPos.containing(x, y, z);
                        Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
                        world.destroyBlock(_pos, false);
                    }
                }
            }
        } else {
            Vec3 _center = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30.0), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList()) {
                if (entityiterator instanceof LivingEntity _livEnt4 && _livEnt4.getType().is(EntityTypeTags.UNDEAD) && entityiterator instanceof Mob _entity) {
                    _entity.getNavigation().moveTo(x, y, z, 1.0);
                }
            }

            Vec3 _center4 = new Vec3(x, y, z);

            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center4, _center4).inflate(0.5), e -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center4)))
                .toList()) {
                if (entityiterator instanceof LivingEntity _livEnt7 && _livEnt7.getType().is(EntityTypeTags.UNDEAD)) {
                    world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(world.getBlockState(BlockPos.containing(x, y, z))));
                    BlockPos _pos = BlockPos.containing(x, y, z);
                    Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
                    world.destroyBlock(_pos, false);
                }
            }
        }

        rate = Mth.nextInt(RandomSource.create(), 1, 200);
        rate2 = Mth.nextInt(RandomSource.create(), 1, 5);
        if (rate == 1.0) {
            if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.NERVOID_BRAIN.get()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockState _bs = MoreCrittersModBlocks.DECOMPOSING_NERVOID_BRAIN.get().defaultBlockState();
                BlockState _bso = world.getBlockState(_bp);
                for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                    if (_property != null && _bs.getValue(_property) != null) {
                        try {
                            _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                        } catch (Exception var19) {
                        }
                    }
                }

                world.setBlock(_bp, _bs, 3);
            } else if (world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.DECOMPOSING_NERVOID_BRAIN.get()) {
                BlockPos _bp = BlockPos.containing(x, y, z);
                BlockState _bs = MoreCrittersModBlocks.ROTTEN_NERVOID_BRAIN.get().defaultBlockState();
                BlockState _bso = world.getBlockState(_bp);
                for (Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
                    Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
                    if (_property != null && _bs.getValue(_property) != null) {
                        try {
                            _bs = _bs.setValue(_property, (Comparable) entry.getValue());
                        } catch (Exception var18) {
                        }
                    }
                }

                world.setBlock(_bp, _bs, 3);
            }
        }

        if (rate2 == 1.0
            && world.getBlockState(BlockPos.containing(x, y, z)).getBlock() == MoreCrittersModBlocks.ROTTEN_NERVOID_BRAIN.get()
            && world instanceof ServerLevel _level) {
            _level.sendParticles(
                MoreCrittersModParticleTypes.STINK.get(), x + 0.5, y + 0.5, z + 0.5, (int)Mth.nextDouble(RandomSource.create(), 2.0, 3.0), 0.2, 0.2, 0.2, 0.0
            );
        }
    }
}
