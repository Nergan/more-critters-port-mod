package com.morecritters.mod

import com.morecritters.mod.config.ServerConfig
import com.morecritters.mod.event.ModSetup
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig

@Mod(MoreCritters.MODID)
class MoreCrittersMod(modBus: IEventBus, container: ModContainer) {
    init {
        MoreCritters.bootstrap(modBus)
        container.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC)
        ModSetup.init(modBus, container)
    }
}
