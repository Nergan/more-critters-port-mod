package com.morecritters.mod.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class RotZombieEntityIsHurtProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        for (int index0 = 0; index0 < 7; index0++) {
            if (world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle more_critters:rot ~ ~1 ~ 0.3 0.4 0.3 0.06 2 force"
                    );
            }
        }
    }
}
