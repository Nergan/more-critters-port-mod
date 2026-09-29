package com.morecritters.mod.client

import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.neoforge.client.gui.ConfigurationScreen
import net.neoforged.neoforge.client.gui.IConfigScreenFactory

object ClientModEvents {
    fun init(@Suppress("UNUSED_PARAMETER") modBus: IEventBus, modContainer: ModContainer) {
        modContainer.registerExtensionPoint(
            IConfigScreenFactory::class.java,
            IConfigScreenFactory { container, currentScreen -> ConfigurationScreen(container, currentScreen) },
        )
    }
}
