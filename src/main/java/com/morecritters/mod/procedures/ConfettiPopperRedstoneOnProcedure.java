package com.morecritters.mod.procedures;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ConfettiPopperRedstoneOnProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        int _value = 1;
        BlockPos _pos = BlockPos.containing(x, y, z);
        BlockState _bs = world.getBlockState(_pos);
        if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp
            && _integerProp.getPossibleValues().contains(_value)) {
            world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
        }

        if (world instanceof Level _level) {
            if (!_level.isClientSide()) {
                _level.playSound(
                    (Player)null,
                    BlockPos.containing(x, y, z),
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.confetti_popper.pop")),
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F
                );
            } else {
                _level.playLocalSound(
                    x,
                    y,
                    z,
                    BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:block.confetti_popper.pop")),
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F,
                    false
                );
            }
        }

        if (world instanceof ServerLevel _level) {
            _level.getServer()
                .getCommands()
                .performPrefixedCommand(
                    new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                    "/particle more_critters:confetti ~0.5 ~1.5 ~0.5 0 1 0 0.1 50 force"
                );
        }
    }
}
