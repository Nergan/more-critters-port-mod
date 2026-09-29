package com.morecritters.mod.procedures;

import net.neoforged.bus.api.ICancellableEvent;
import javax.annotation.Nullable;
import com.morecritters.mod.MoreCritters;
import com.morecritters.mod.entity.AncientCustodianEntity;
import com.morecritters.mod.entity.CustodianEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class CustodianDamageProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingIncomingDamageEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
        execute(null, world, damagesource, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
        if (damagesource != null && entity != null && sourceentity != null) {
            double rate = 0.0;
            if (entity instanceof CustodianEntity && sourceentity instanceof Warden) {
                if (event instanceof ICancellableEvent _cancellable) {
                    _cancellable.setCanceled(true);
                }

                rate = Mth.nextInt(RandomSource.create(), 1, 2);
                if (!(entity instanceof CustodianEntity _datEntL3 && _datEntL3.getEntityData().get(CustodianEntity.DATA_charging))
                    && !(entity instanceof CustodianEntity _datEntL4 && _datEntL4.getEntityData().get(CustodianEntity.DATA_closed))
                    && !((CustodianEntity)entity).animationprocedure.equals("open2")) {
                    if (rate == 1.0) {
                        if (entity instanceof CustodianEntity) {
                            ((CustodianEntity)entity).setAnimation("hurt1");
                        }

                        MoreCritters.queueServerWork(10, () -> {
                            if (entity instanceof CustodianEntity) {
                                ((CustodianEntity)entity).setAnimation("empty");
                            }
                        });
                    } else if (rate == 2.0) {
                        if (entity instanceof CustodianEntity) {
                            ((CustodianEntity)entity).setAnimation("hurt2");
                        }

                        MoreCritters.queueServerWork(10, () -> {
                            if (entity instanceof CustodianEntity) {
                                ((CustodianEntity)entity).setAnimation("empty");
                            }
                        });
                    }
                }
            }

            if (entity instanceof AncientCustodianEntity) {
                if (event instanceof ICancellableEvent _cancellable) {
                    _cancellable.setCanceled(true);
                }
            }

            if (sourceentity instanceof CustodianEntity && damagesource.isDirect()) {
                if (event instanceof ICancellableEvent _cancellable) {
                    _cancellable.setCanceled(true);
                }
            }
        }
    }
}
