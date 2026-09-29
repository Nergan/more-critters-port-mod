package com.morecritters.mod.event

import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.loading.FMLEnvironment

object ModSetup {
    fun init(modBus: IEventBus, modContainer: ModContainer) {
        EffectEvents.register()
        if (FMLEnvironment.dist == Dist.CLIENT) {
            com.morecritters.mod.client.ClientModEvents.init(modBus, modContainer)
        }
    }
}
