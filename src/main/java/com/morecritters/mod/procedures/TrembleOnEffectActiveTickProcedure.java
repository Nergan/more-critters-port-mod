package com.morecritters.mod.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class TrembleOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity != null) {
            Entity _ent = entity;
            _ent.setYRot((float)(entity.getYRot() + Mth.nextDouble(RandomSource.create(), -3.0, 3.0)));
            _ent.setXRot((float)(entity.getXRot() + Mth.nextDouble(RandomSource.create(), -3.0, 3.0)));
            _ent.setYBodyRot(_ent.getYRot());
            _ent.setYHeadRot(_ent.getYRot());
            _ent.yRotO = _ent.getYRot();
            _ent.xRotO = _ent.getXRot();
            if (_ent instanceof LivingEntity _entity) {
                _entity.yBodyRotO = _entity.getYRot();
                _entity.yHeadRotO = _entity.getYRot();
            }
        }
    }
}
