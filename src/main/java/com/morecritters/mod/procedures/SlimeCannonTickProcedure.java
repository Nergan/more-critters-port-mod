package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class SlimeCannonTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        MoreCritters.queueServerWork(
            5,
            () -> {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:block{block_state:\"minecraft:slime_block\"} ~ ~ ~ 0.2 0.2 0.2 0.01 4 force"
                        );
                }
            }
        );
    }
}
