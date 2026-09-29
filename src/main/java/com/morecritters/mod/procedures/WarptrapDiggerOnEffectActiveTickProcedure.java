package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.WarptrapEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class WarptrapDiggerOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap") && world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:block{block_state:\"minecraft:warped_nylium\"} ~ ~ ~ 0.5 0 0.5 2 7 force"
                    );
            }

            if ((entity instanceof WarptrapEntity animatable ? animatable.getTexture() : "null").equals("warptrap_crimson")
                && world instanceof ServerLevel _level) {
                _level.getServer()
                    .getCommands()
                    .performPrefixedCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
                            .withSuppressedOutput(),
                        "/particle minecraft:block{block_state:\"minecraft:crimson_nylium\"} ~ ~ ~ 0.5 0 0.5 2 7 force"
                    );
            }
        }
    }
}
