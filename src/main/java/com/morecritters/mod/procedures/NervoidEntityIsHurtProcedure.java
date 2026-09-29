package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import com.morecritters.mod.entity.NervoidEntity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class NervoidEntityIsHurtProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (entity instanceof NervoidEntity) {
                ((NervoidEntity)entity).setAnimation("empty");
            }

            entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * -0.5, entity.getLookAngle().y * -0.5, entity.getLookAngle().z * -0.5));
            if (sourceentity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:encounter_nervoid"));
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
