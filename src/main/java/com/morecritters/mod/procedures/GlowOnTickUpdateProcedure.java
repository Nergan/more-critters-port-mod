package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class GlowOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel _level) {
            _level.getServer()
                .getCommands()
                .performPrefixedCommand(
                    new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                        .withSuppressedOutput(),
                    "/setblock ~ ~ ~ light"
                );
        }

        MoreCritters.queueServerWork(5, () -> world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3));
    }
}
