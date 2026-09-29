package com.morecritters.mod.procedures;

import net.minecraft.advancements.AdvancementHolder;
import javax.annotation.Nullable;
import com.morecritters.mod.entity.CorpseCaptainEntity;
import com.morecritters.mod.entity.CorpseLookoutEntity;
import com.morecritters.mod.entity.CorpseMateEntity;
import com.morecritters.mod.entity.CorpseParrotEntity;
import com.morecritters.mod.entity.CorpseQuartermasterEntity;
import com.morecritters.mod.entity.CorpseTankEntity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class CorpseMemberDiesProcedure {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity(), event.getSource().getEntity());
        }
    }

    public static void execute(Entity entity, Entity sourceentity) {
        execute(null, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if ((
                    entity instanceof CorpseCaptainEntity
                        || entity instanceof CorpseParrotEntity
                        || entity instanceof CorpseMateEntity
                        || entity instanceof CorpseTankEntity
                        || entity instanceof CorpseLookoutEntity
                        || entity instanceof CorpseQuartermasterEntity
                )
                && sourceentity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:kill_corpse_crew_member"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }

            if (entity instanceof CorpseCaptainEntity && sourceentity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:kill_captain"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }

            if (entity instanceof CorpseLookoutEntity && sourceentity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:kill_corpse_lookout"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }

            if (entity instanceof CorpseTankEntity
                && !(entity instanceof CorpseTankEntity _datEntL12 && _datEntL12.getEntityData().get(CorpseTankEntity.DATA_HasShot))
                && sourceentity instanceof ServerPlayer _player) {
                AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("more_critters:kill_tank_before_shooting"));
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
