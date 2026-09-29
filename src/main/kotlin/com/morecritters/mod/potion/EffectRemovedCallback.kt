package com.morecritters.mod.potion

import net.minecraft.world.entity.LivingEntity

/**
 * Stand-in for 1.20.1's entity-aware `MobEffect#removeAttributeModifiers`, which the original mod
 * used as its "effect expires" trigger. Dispatched by [com.morecritters.mod.event.EffectEvents].
 */
fun interface EffectRemovedCallback {
    fun onEffectRemoved(entity: LivingEntity, amplifier: Int)
}
