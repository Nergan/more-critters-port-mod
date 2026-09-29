package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Map.Entry;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class BounceberryBushPlantRightClickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(
                    (Player)null,
                    BlockPos.containing(x, y, z),
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sweet_berry_bush.break")),
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F
                );
            } else {
                _level.playLocalSound(
                    x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sweet_berry_bush.break")), SoundSource.BLOCKS, 1.0F, 1.0F, false
                );
            }
        }

        BlockPos _bp = BlockPos.containing(x, y, z);
        BlockState _bs = MoreCrittersModBlocks.BOUNCEBERRY_BUSH_EMPTY.get().defaultBlockState();
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

        for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 2.0, 3.0); index0++) {
            if (world instanceof ServerLevel _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y + 0.5, z + 0.5, new ItemStack(MoreCrittersModItems.BOUNCEBERRY.get()));
                entityToSpawn.setPickUpDelay(10);
                _level.addFreshEntity(entityToSpawn);
            }
        }
    }
}
