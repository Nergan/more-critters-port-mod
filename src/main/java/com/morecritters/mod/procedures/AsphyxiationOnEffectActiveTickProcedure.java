package com.morecritters.mod.procedures;

import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.BalloonRatEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AsphyxiationOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (!(entity instanceof BalloonRatEntity)) {
                if (entity.isInWaterOrBubble()) {
                    MoreCritters.queueServerWork(10, () -> entity.setAirSupply(entity.getAirSupply() - 1));
                    entity.getPersistentData().putDouble("drown", 1.0);
                } else {
                    if (entity.getPersistentData().getDouble("drown") == 0.0) {
                        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DROWN)), 1.0F);

                        for (int index0 = 0; index0 < (int)Mth.nextDouble(RandomSource.create(), 3.0, 6.0); index0++) {
                            if (world instanceof ServerLevel _level) {
                                _level.getServer()
                                    .getCommands()
                                    .performPrefixedCommand(
                                        new CommandSourceStack(
                                                CommandSource.NULL,
                                                new Vec3(x, y + entity.getBbHeight(), z),
                                                Vec2.ZERO,
                                                _level,
                                                4,
                                                "",
                                                Component.literal(""),
                                                _level.getServer(),
                                                null
                                            )
                                            .withSuppressedOutput(),
                                        "/particle more_critters:drown_bubble ~ ~ ~ 0 0 0 0.02 1 force"
                                    );
                            }
                        }

                        entity.getPersistentData().putDouble("drown", 20.0);
                    }

                    entity.getPersistentData().putDouble("drown", entity.getPersistentData().getDouble("drown") - 1.0);
                }
            }
        }
    }
}
