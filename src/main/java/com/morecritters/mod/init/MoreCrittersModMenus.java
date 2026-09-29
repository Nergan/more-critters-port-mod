package com.morecritters.mod.init;

import net.minecraft.core.registries.Registries;
import com.morecritters.mod.world.inventory.CannonGuiMenu;
import com.morecritters.mod.world.inventory.CarrybugGuiMenu;
import com.morecritters.mod.world.inventory.CritterAtlasArmossillo2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasArmossilloMenu;
import com.morecritters.mod.world.inventory.CritterAtlasAvoider2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasAvoiderMenu;
import com.morecritters.mod.world.inventory.CritterAtlasBalloonRat2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasBalloonRatMenu;
import com.morecritters.mod.world.inventory.CritterAtlasBlubberfish2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasBlubberfishMenu;
import com.morecritters.mod.world.inventory.CritterAtlasBombJellyMenu;
import com.morecritters.mod.world.inventory.CritterAtlasBouncelizardMenu;
import com.morecritters.mod.world.inventory.CritterAtlasBunbug2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasBunbugMenu;
import com.morecritters.mod.world.inventory.CritterAtlasCorpseCrew2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasCorpseCrew3Menu;
import com.morecritters.mod.world.inventory.CritterAtlasCorpseCrew4Menu;
import com.morecritters.mod.world.inventory.CritterAtlasCorpseCrewMenu;
import com.morecritters.mod.world.inventory.CritterAtlasCreeblossom2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasCreeblossomMenu;
import com.morecritters.mod.world.inventory.CritterAtlasCritterlings2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasCritterlingsMenu;
import com.morecritters.mod.world.inventory.CritterAtlasCustodian2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasCustodianMenu;
import com.morecritters.mod.world.inventory.CritterAtlasDripperMenu;
import com.morecritters.mod.world.inventory.CritterAtlasGravedigger2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasGravediggerMenu;
import com.morecritters.mod.world.inventory.CritterAtlasIropod2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasIropodMenu;
import com.morecritters.mod.world.inventory.CritterAtlasKelpireMenu;
import com.morecritters.mod.world.inventory.CritterAtlasMightshroom2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasMightshroom3Menu;
import com.morecritters.mod.world.inventory.CritterAtlasMightshroomMenu;
import com.morecritters.mod.world.inventory.CritterAtlasNauticrawl2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasNauticrawlMenu;
import com.morecritters.mod.world.inventory.CritterAtlasNervoid2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasNervoidMenu;
import com.morecritters.mod.world.inventory.CritterAtlasRamchu2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasRamchuMenu;
import com.morecritters.mod.world.inventory.CritterAtlasRootPage2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasRootPageMenu;
import com.morecritters.mod.world.inventory.CritterAtlasShadelet2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasShadeletMenu;
import com.morecritters.mod.world.inventory.CritterAtlasShimmerwing2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasShimmerwingMenu;
import com.morecritters.mod.world.inventory.CritterAtlasShriekbat2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasShriekbatMenu;
import com.morecritters.mod.world.inventory.CritterAtlasSnowflakeSpider2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasSnowflakeSpiderMenu;
import com.morecritters.mod.world.inventory.CritterAtlasStincarp2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasStincarpMenu;
import com.morecritters.mod.world.inventory.CritterAtlasTreeplet2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasTreepletMenu;
import com.morecritters.mod.world.inventory.CritterAtlasViewMenu;
import com.morecritters.mod.world.inventory.CritterAtlasWarptrap2Menu;
import com.morecritters.mod.world.inventory.CritterAtlasWarptrapMenu;
import com.morecritters.mod.world.inventory.EvolutionTableGuiMenu;
import com.morecritters.mod.world.inventory.TreasureChestGuiMenu;
import com.morecritters.mod.world.inventory.WanderingTraderGuiMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredHolder;

public class MoreCrittersModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, "more_critters");
    public static final DeferredHolder<MenuType<?>, MenuType<WanderingTraderGuiMenu>> WANDERING_TRADER_GUI = REGISTRY.register(
        "wandering_trader_gui", () -> IMenuTypeExtension.create(WanderingTraderGuiMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CarrybugGuiMenu>> CARRYBUG_GUI = REGISTRY.register(
        "carrybug_gui", () -> IMenuTypeExtension.create(CarrybugGuiMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasViewMenu>> CRITTER_ATLAS_VIEW = REGISTRY.register(
        "critter_atlas_view", () -> IMenuTypeExtension.create(CritterAtlasViewMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasRootPageMenu>> CRITTER_ATLAS_ROOT_PAGE = REGISTRY.register(
        "critter_atlas_root_page", () -> IMenuTypeExtension.create(CritterAtlasRootPageMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasBunbugMenu>> CRITTER_ATLAS_BUNBUG = REGISTRY.register(
        "critter_atlas_bunbug", () -> IMenuTypeExtension.create(CritterAtlasBunbugMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasSnowflakeSpiderMenu>> CRITTER_ATLAS_SNOWFLAKE_SPIDER = REGISTRY.register(
        "critter_atlas_snowflake_spider", () -> IMenuTypeExtension.create(CritterAtlasSnowflakeSpiderMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasSnowflakeSpider2Menu>> CRITTER_ATLAS_SNOWFLAKE_SPIDER_2 = REGISTRY.register(
        "critter_atlas_snowflake_spider_2", () -> IMenuTypeExtension.create(CritterAtlasSnowflakeSpider2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasShriekbatMenu>> CRITTER_ATLAS_SHRIEKBAT = REGISTRY.register(
        "critter_atlas_shriekbat", () -> IMenuTypeExtension.create(CritterAtlasShriekbatMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasShriekbat2Menu>> CRITTER_ATLAS_SHRIEKBAT_2 = REGISTRY.register(
        "critter_atlas_shriekbat_2", () -> IMenuTypeExtension.create(CritterAtlasShriekbat2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCreeblossomMenu>> CRITTER_ATLAS_CREEBLOSSOM = REGISTRY.register(
        "critter_atlas_creeblossom", () -> IMenuTypeExtension.create(CritterAtlasCreeblossomMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCreeblossom2Menu>> CRITTER_ATLAS_CREEBLOSSOM_2 = REGISTRY.register(
        "critter_atlas_creeblossom_2", () -> IMenuTypeExtension.create(CritterAtlasCreeblossom2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasBouncelizardMenu>> CRITTER_ATLAS_BOUNCELIZARD = REGISTRY.register(
        "critter_atlas_bouncelizard", () -> IMenuTypeExtension.create(CritterAtlasBouncelizardMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasStincarpMenu>> CRITTER_ATLAS_STINCARP = REGISTRY.register(
        "critter_atlas_stincarp", () -> IMenuTypeExtension.create(CritterAtlasStincarpMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasStincarp2Menu>> CRITTER_ATLAS_STINCARP_2 = REGISTRY.register(
        "critter_atlas_stincarp_2", () -> IMenuTypeExtension.create(CritterAtlasStincarp2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasBalloonRatMenu>> CRITTER_ATLAS_BALLOON_RAT = REGISTRY.register(
        "critter_atlas_balloon_rat", () -> IMenuTypeExtension.create(CritterAtlasBalloonRatMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasBalloonRat2Menu>> CRITTER_ATLAS_BALLOON_RAT_2 = REGISTRY.register(
        "critter_atlas_balloon_rat_2", () -> IMenuTypeExtension.create(CritterAtlasBalloonRat2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasWarptrapMenu>> CRITTER_ATLAS_WARPTRAP = REGISTRY.register(
        "critter_atlas_warptrap", () -> IMenuTypeExtension.create(CritterAtlasWarptrapMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasWarptrap2Menu>> CRITTER_ATLAS_WARPTRAP_2 = REGISTRY.register(
        "critter_atlas_warptrap_2", () -> IMenuTypeExtension.create(CritterAtlasWarptrap2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasShimmerwingMenu>> CRITTER_ATLAS_SHIMMERWING = REGISTRY.register(
        "critter_atlas_shimmerwing", () -> IMenuTypeExtension.create(CritterAtlasShimmerwingMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasMightshroomMenu>> CRITTER_ATLAS_MIGHTSHROOM = REGISTRY.register(
        "critter_atlas_mightshroom", () -> IMenuTypeExtension.create(CritterAtlasMightshroomMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasMightshroom2Menu>> CRITTER_ATLAS_MIGHTSHROOM_2 = REGISTRY.register(
        "critter_atlas_mightshroom_2", () -> IMenuTypeExtension.create(CritterAtlasMightshroom2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasMightshroom3Menu>> CRITTER_ATLAS_MIGHTSHROOM_3 = REGISTRY.register(
        "critter_atlas_mightshroom_3", () -> IMenuTypeExtension.create(CritterAtlasMightshroom3Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasBombJellyMenu>> CRITTER_ATLAS_BOMB_JELLY = REGISTRY.register(
        "critter_atlas_bomb_jelly", () -> IMenuTypeExtension.create(CritterAtlasBombJellyMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasAvoiderMenu>> CRITTER_ATLAS_AVOIDER = REGISTRY.register(
        "critter_atlas_avoider", () -> IMenuTypeExtension.create(CritterAtlasAvoiderMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasAvoider2Menu>> CRITTER_ATLAS_AVOIDER_2 = REGISTRY.register(
        "critter_atlas_avoider_2", () -> IMenuTypeExtension.create(CritterAtlasAvoider2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasIropodMenu>> CRITTER_ATLAS_IROPOD = REGISTRY.register(
        "critter_atlas_iropod", () -> IMenuTypeExtension.create(CritterAtlasIropodMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasBlubberfishMenu>> CRITTER_ATLAS_BLUBBERFISH = REGISTRY.register(
        "critter_atlas_blubberfish", () -> IMenuTypeExtension.create(CritterAtlasBlubberfishMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasKelpireMenu>> CRITTER_ATLAS_KELPIRE = REGISTRY.register(
        "critter_atlas_kelpire", () -> IMenuTypeExtension.create(CritterAtlasKelpireMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasNauticrawlMenu>> CRITTER_ATLAS_NAUTICRAWL = REGISTRY.register(
        "critter_atlas_nauticrawl", () -> IMenuTypeExtension.create(CritterAtlasNauticrawlMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasNauticrawl2Menu>> CRITTER_ATLAS_NAUTICRAWL_2 = REGISTRY.register(
        "critter_atlas_nauticrawl_2", () -> IMenuTypeExtension.create(CritterAtlasNauticrawl2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasShimmerwing2Menu>> CRITTER_ATLAS_SHIMMERWING_2 = REGISTRY.register(
        "critter_atlas_shimmerwing_2", () -> IMenuTypeExtension.create(CritterAtlasShimmerwing2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CannonGuiMenu>> CANNON_GUI = REGISTRY.register("cannon_gui", () -> IMenuTypeExtension.create(CannonGuiMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<TreasureChestGuiMenu>> TREASURE_CHEST_GUI = REGISTRY.register(
        "treasure_chest_gui", () -> IMenuTypeExtension.create(TreasureChestGuiMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasRootPage2Menu>> CRITTER_ATLAS_ROOT_PAGE_2 = REGISTRY.register(
        "critter_atlas_root_page_2", () -> IMenuTypeExtension.create(CritterAtlasRootPage2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasShadeletMenu>> CRITTER_ATLAS_SHADELET = REGISTRY.register(
        "critter_atlas_shadelet", () -> IMenuTypeExtension.create(CritterAtlasShadeletMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasShadelet2Menu>> CRITTER_ATLAS_SHADELET_2 = REGISTRY.register(
        "critter_atlas_shadelet_2", () -> IMenuTypeExtension.create(CritterAtlasShadelet2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasTreepletMenu>> CRITTER_ATLAS_TREEPLET = REGISTRY.register(
        "critter_atlas_treeplet", () -> IMenuTypeExtension.create(CritterAtlasTreepletMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasTreeplet2Menu>> CRITTER_ATLAS_TREEPLET_2 = REGISTRY.register(
        "critter_atlas_treeplet_2", () -> IMenuTypeExtension.create(CritterAtlasTreeplet2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasNervoidMenu>> CRITTER_ATLAS_NERVOID = REGISTRY.register(
        "critter_atlas_nervoid", () -> IMenuTypeExtension.create(CritterAtlasNervoidMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasNervoid2Menu>> CRITTER_ATLAS_NERVOID_2 = REGISTRY.register(
        "critter_atlas_nervoid_2", () -> IMenuTypeExtension.create(CritterAtlasNervoid2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCorpseCrewMenu>> CRITTER_ATLAS_CORPSE_CREW = REGISTRY.register(
        "critter_atlas_corpse_crew", () -> IMenuTypeExtension.create(CritterAtlasCorpseCrewMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCorpseCrew2Menu>> CRITTER_ATLAS_CORPSE_CREW_2 = REGISTRY.register(
        "critter_atlas_corpse_crew_2", () -> IMenuTypeExtension.create(CritterAtlasCorpseCrew2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCorpseCrew3Menu>> CRITTER_ATLAS_CORPSE_CREW_3 = REGISTRY.register(
        "critter_atlas_corpse_crew_3", () -> IMenuTypeExtension.create(CritterAtlasCorpseCrew3Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasBunbug2Menu>> CRITTER_ATLAS_BUNBUG_2 = REGISTRY.register(
        "critter_atlas_bunbug_2", () -> IMenuTypeExtension.create(CritterAtlasBunbug2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasGravediggerMenu>> CRITTER_ATLAS_GRAVEDIGGER = REGISTRY.register(
        "critter_atlas_gravedigger", () -> IMenuTypeExtension.create(CritterAtlasGravediggerMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasGravedigger2Menu>> CRITTER_ATLAS_GRAVEDIGGER_2 = REGISTRY.register(
        "critter_atlas_gravedigger_2", () -> IMenuTypeExtension.create(CritterAtlasGravedigger2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasArmossilloMenu>> CRITTER_ATLAS_ARMOSSILLO = REGISTRY.register(
        "critter_atlas_armossillo", () -> IMenuTypeExtension.create(CritterAtlasArmossilloMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasArmossillo2Menu>> CRITTER_ATLAS_ARMOSSILLO_2 = REGISTRY.register(
        "critter_atlas_armossillo_2", () -> IMenuTypeExtension.create(CritterAtlasArmossillo2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasRamchuMenu>> CRITTER_ATLAS_RAMCHU = REGISTRY.register(
        "critter_atlas_ramchu", () -> IMenuTypeExtension.create(CritterAtlasRamchuMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasRamchu2Menu>> CRITTER_ATLAS_RAMCHU_2 = REGISTRY.register(
        "critter_atlas_ramchu_2", () -> IMenuTypeExtension.create(CritterAtlasRamchu2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasDripperMenu>> CRITTER_ATLAS_DRIPPER = REGISTRY.register(
        "critter_atlas_dripper", () -> IMenuTypeExtension.create(CritterAtlasDripperMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCustodianMenu>> CRITTER_ATLAS_CUSTODIAN = REGISTRY.register(
        "critter_atlas_custodian", () -> IMenuTypeExtension.create(CritterAtlasCustodianMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCustodian2Menu>> CRITTER_ATLAS_CUSTODIAN_2 = REGISTRY.register(
        "critter_atlas_custodian_2", () -> IMenuTypeExtension.create(CritterAtlasCustodian2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasBlubberfish2Menu>> CRITTER_ATLAS_BLUBBERFISH_2 = REGISTRY.register(
        "critter_atlas_blubberfish_2", () -> IMenuTypeExtension.create(CritterAtlasBlubberfish2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCorpseCrew4Menu>> CRITTER_ATLAS_CORPSE_CREW_4 = REGISTRY.register(
        "critter_atlas_corpse_crew_4", () -> IMenuTypeExtension.create(CritterAtlasCorpseCrew4Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<EvolutionTableGuiMenu>> EVOLUTION_TABLE_GUI = REGISTRY.register(
        "evolution_table_gui", () -> IMenuTypeExtension.create(EvolutionTableGuiMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCritterlingsMenu>> CRITTER_ATLAS_CRITTERLINGS = REGISTRY.register(
        "critter_atlas_critterlings", () -> IMenuTypeExtension.create(CritterAtlasCritterlingsMenu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasCritterlings2Menu>> CRITTER_ATLAS_CRITTERLINGS_2 = REGISTRY.register(
        "critter_atlas_critterlings_2", () -> IMenuTypeExtension.create(CritterAtlasCritterlings2Menu::new)
    );
    public static final DeferredHolder<MenuType<?>, MenuType<CritterAtlasIropod2Menu>> CRITTER_ATLAS_IROPOD_2 = REGISTRY.register(
        "critter_atlas_iropod_2", () -> IMenuTypeExtension.create(CritterAtlasIropod2Menu::new)
    );
}
