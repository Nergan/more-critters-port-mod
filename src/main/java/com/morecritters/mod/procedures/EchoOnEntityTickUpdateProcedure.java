package com.morecritters.mod.procedures;

import com.morecritters.mod.entity.HealEchoEntity;
import com.morecritters.mod.entity.MightshroomEchoEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import com.morecritters.mod.entity.SmallHealEchoEntity;
import com.morecritters.mod.entity.TesterShriekEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class EchoOnEntityTickUpdateProcedure {
    public static void execute(double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            entity.lookAt(Anchor.EYES, new Vec3(x, y, z));
            entity.getPersistentData().putDouble("timer", entity.getPersistentData().getDouble("timer") - 1.0);
            if (entity.getPersistentData().getDouble("timer") < 0.0 && !entity.level().isClientSide()) {
                entity.discard();
            }

            if (entity.getPersistentData().getDouble("timer") == 30.0) {
                if (entity instanceof ShockCubeEntity animatable) {
                    animatable.setTexture("shock_cube2");
                }

                if (entity instanceof MightshroomEchoEntity animatable) {
                    animatable.setTexture("mightshroom_echo1");
                }

                if (entity instanceof HealEchoEntity animatable) {
                    animatable.setTexture("heal_echo2");
                }

                if (entity instanceof SmallHealEchoEntity animatable) {
                    animatable.setTexture("heal_echo2");
                }

                if (entity instanceof TesterShriekEntity animatable) {
                    animatable.setTexture("tester_shriek1");
                }
            }

            if (entity.getPersistentData().getDouble("timer") == 20.0) {
                if (entity instanceof ShockCubeEntity animatable) {
                    animatable.setTexture("shock_cube3");
                }

                if (entity instanceof HealEchoEntity animatable) {
                    animatable.setTexture("heal_echo3");
                }

                if (entity instanceof SmallHealEchoEntity animatable) {
                    animatable.setTexture("heal_echo3");
                }

                if (entity instanceof TesterShriekEntity animatable) {
                    animatable.setTexture("tester_shriek2");
                }
            }

            if (entity.getPersistentData().getDouble("timer") == 10.0) {
                if (entity instanceof ShockCubeEntity animatable) {
                    animatable.setTexture("shock_cube4");
                }

                if (entity instanceof HealEchoEntity animatable) {
                    animatable.setTexture("heal_echo4");
                }

                if (entity instanceof SmallHealEchoEntity animatable) {
                    animatable.setTexture("heal_echo4");
                }

                if (entity instanceof TesterShriekEntity animatable) {
                    animatable.setTexture("tester_shriek3");
                }
            }
        }
    }
}
