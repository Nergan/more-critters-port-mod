package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class UnderControlOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            double rate = 0.0;
            if (!(entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                entity.push(Mth.nextDouble(RandomSource.create(), -0.3, 0.3), -0.1, Mth.nextDouble(RandomSource.create(), -0.3, 0.3));
                Entity _ent = entity;
                _ent.setYRot((float)(entity.getYRot() + Mth.nextDouble(RandomSource.create(), -5.0, 5.0)));
                _ent.setXRot((float)entity.getLookAngle().y);
                _ent.setYBodyRot(_ent.getYRot());
                _ent.setYHeadRot(_ent.getYRot());
                _ent.yRotO = _ent.getYRot();
                _ent.xRotO = _ent.getXRot();
                if (_ent instanceof LivingEntity _entity) {
                    _entity.yBodyRotO = _entity.getYRot();
                    _entity.yHeadRotO = _entity.getYRot();
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 10);
                if (rate == 1.0 && entity.onGround()) {
                    entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.4, entity.getDeltaMovement().z()));
                }
            }
        }
    }
}
