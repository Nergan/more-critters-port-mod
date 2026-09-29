package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class NauticrawlEntityIsHurtProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity != null) {
            for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 3, 5); index0++) {
                if (world instanceof ServerLevel _level) {
                    _level.getServer()
                        .getCommands()
                        .performPrefixedCommand(
                            new CommandSourceStack(
                                    CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null
                                )
                                .withSuppressedOutput(),
                            "/particle minecraft:squid_ink ~ ~ ~ 0 0 0 0.1 1 force"
                        );
                }
            }

            if (sourceentity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:encounter_nauticrawl"));
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
