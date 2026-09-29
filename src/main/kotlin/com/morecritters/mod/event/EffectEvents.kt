package com.morecritters.mod.event

import com.morecritters.mod.potion.EffectRemovedCallback
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.LivingEntity
import net.neoforged.bus.api.EventPriority
import net.neoforged.neoforge.common.NeoForge
import net.neoforged.neoforge.event.entity.living.MobEffectEvent

object EffectEvents {
    fun register() {
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, false, MobEffectEvent.Remove::class.java) {
            dispatchRemoved(it.entity, it.effectInstance)
        }
        NeoForge.EVENT_BUS.addListener(EventPriority.LOWEST, false, MobEffectEvent.Expired::class.java) {
            dispatchRemoved(it.entity, it.effectInstance)
        }
    }

    private fun dispatchRemoved(entity: LivingEntity, instance: MobEffectInstance?) {
        if (instance == null || entity.level().isClientSide) return
        (instance.effect.value() as? EffectRemovedCallback)?.onEffectRemoved(entity, instance.amplifier)
    }
}
