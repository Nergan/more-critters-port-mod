package com.morecritters.mod;

import com.morecritters.mod.init.MoreCrittersModArmorMaterials;
import com.morecritters.mod.init.MoreCrittersModBlockEntities;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModFluidTypes;
import com.morecritters.mod.init.MoreCrittersModFluids;
import com.morecritters.mod.init.MoreCrittersModGameRules;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.init.MoreCrittersModLootModifier;
import com.morecritters.mod.init.MoreCrittersModMenus;
import com.morecritters.mod.init.MoreCrittersModMobEffects;
import com.morecritters.mod.init.MoreCrittersModParticleTypes;
import com.morecritters.mod.init.MoreCrittersModPotions;
import com.morecritters.mod.init.MoreCrittersModSounds;
import com.morecritters.mod.init.MoreCrittersModTabs;
import com.morecritters.mod.network.MoreCrittersModVariables;
import com.morecritters.mod.world.features.StructureFeature;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Shared state of the port: mod id, logger, delayed server work and registry bootstrap.
 * The {@code @Mod} entry point is the Kotlin class {@code MoreCrittersMod}.
 */
public final class MoreCritters {
    public static final String MODID = "more_critters";
    public static final Logger LOGGER = LogManager.getLogger(MoreCritters.class);
    private static final Collection<SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    private MoreCritters() {
    }

    public static void bootstrap(IEventBus bus) {
        MoreCrittersModSounds.REGISTRY.register(bus);
        MoreCrittersModArmorMaterials.REGISTRY.register(bus);
        MoreCrittersModBlocks.REGISTRY.register(bus);
        MoreCrittersModBlockEntities.REGISTRY.register(bus);
        MoreCrittersModItems.REGISTRY.register(bus);
        MoreCrittersModEntities.REGISTRY.register(bus);
        MoreCrittersModTabs.REGISTRY.register(bus);
        StructureFeature.REGISTRY.register(bus);
        MoreCrittersModMobEffects.REGISTRY.register(bus);
        MoreCrittersModPotions.REGISTRY.register(bus);
        MoreCrittersModParticleTypes.REGISTRY.register(bus);
        MoreCrittersModMenus.REGISTRY.register(bus);
        MoreCrittersModFluids.REGISTRY.register(bus);
        MoreCrittersModFluidTypes.REGISTRY.register(bus);
        MoreCrittersModLootModifier.LOOT_MODIFIERS.register(bus);
        MoreCrittersModVariables.ATTACHMENT_TYPES.register(bus);
        MoreCrittersModGameRules.register();
        NeoForge.EVENT_BUS.addListener(MoreCritters::tick);
    }

    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
            workQueue.add(new SimpleEntry<>(action, tick));
        }
    }

    private static void tick(ServerTickEvent.Post event) {
        List<SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setValue(work.getValue() - 1);
            if (work.getValue() == 0) {
                actions.add(work);
            }
        });
        actions.forEach(e -> e.getKey().run());
        workQueue.removeAll(actions);
    }
}
