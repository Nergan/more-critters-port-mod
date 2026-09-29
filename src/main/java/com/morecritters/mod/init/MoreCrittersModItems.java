package com.morecritters.mod.init;

import net.minecraft.core.registries.Registries;
import com.morecritters.mod.block.display.ConfettiPopperDisplayItem;
import com.morecritters.mod.block.display.GravediggerJarDisplayItem;
import com.morecritters.mod.block.display.ShipWheelDisplayItem;
import com.morecritters.mod.block.display.TatteredJollyRogerDisplayItem;
import com.morecritters.mod.item.AmalgamSpawnDollItem;
import com.morecritters.mod.item.AncientBoneItem;
import com.morecritters.mod.item.AncientCustodianSpawnDollItem;
import com.morecritters.mod.item.AncientSkeletonExhibitItemItem;
import com.morecritters.mod.item.AncientSkeletonItemItem;
import com.morecritters.mod.item.AvoiderBucketItem;
import com.morecritters.mod.item.AvoiderFryBucketItem;
import com.morecritters.mod.item.AvoiderTailItem;
import com.morecritters.mod.item.BirchSnowCone1Item;
import com.morecritters.mod.item.BirchSnowCone2Item;
import com.morecritters.mod.item.BirchSnowCone3Item;
import com.morecritters.mod.item.BirchSnowConeItem;
import com.morecritters.mod.item.BitingShieldItem;
import com.morecritters.mod.item.BlackIropodBucketItem;
import com.morecritters.mod.item.BlackResinBrickItem;
import com.morecritters.mod.item.BlackResinClumpItem;
import com.morecritters.mod.item.BlossombushSeedItem;
import com.morecritters.mod.item.BlubberfishBucketItem;
import com.morecritters.mod.item.BlubberfishFryBucketItem;
import com.morecritters.mod.item.BoosterPumpItem;
import com.morecritters.mod.item.BottleoElectricityItem;
import com.morecritters.mod.item.BounceberryItem;
import com.morecritters.mod.item.BounceberryJamItem;
import com.morecritters.mod.item.BounceberrySandwichItem;
import com.morecritters.mod.item.BunbugBurgerItem;
import com.morecritters.mod.item.BunbugCaviarItem;
import com.morecritters.mod.item.BunbugCrustIcedChocolateItem;
import com.morecritters.mod.item.BunbugCrustIcedChocolateSprinkledBounceberriesItem;
import com.morecritters.mod.item.BunbugCrustIcedChocolateSprinkledGlowBerriesItem;
import com.morecritters.mod.item.BunbugCrustIcedChocolateSprinkledItem;
import com.morecritters.mod.item.BunbugCrustIcedChocolateSprinkledSweetBerriesItem;
import com.morecritters.mod.item.BunbugCrustIcedSugarItem;
import com.morecritters.mod.item.BunbugCrustIcedSugarSprinkledBounceberriesItem;
import com.morecritters.mod.item.BunbugCrustIcedSugarSprinkledGlowBerriesItem;
import com.morecritters.mod.item.BunbugCrustIcedSugarSprinkledItem;
import com.morecritters.mod.item.BunbugCrustIcedSugarSprinkledSweetBerriesItem;
import com.morecritters.mod.item.BunbugCrustItem;
import com.morecritters.mod.item.BunbugCrustStrawberrySprinkledCandleItem;
import com.morecritters.mod.item.BunbugEggsItem;
import com.morecritters.mod.item.CannonBallItem;
import com.morecritters.mod.item.CaptainsHeartItem;
import com.morecritters.mod.item.ChatteringTeethItemItem;
import com.morecritters.mod.item.ClosedCritterlingSackItem;
import com.morecritters.mod.item.CookedBlubberfishItem;
import com.morecritters.mod.item.CookedBouncelizardEggItem;
import com.morecritters.mod.item.CookedBunbugMeatItem;
import com.morecritters.mod.item.CookedNerveItem;
import com.morecritters.mod.item.CorpseCaptainSpawnDollItem;
import com.morecritters.mod.item.CorpseLookoutSpawnDollItem;
import com.morecritters.mod.item.CorpseMateSpawnDollItem;
import com.morecritters.mod.item.CorpseParrotItemItem;
import com.morecritters.mod.item.CorpseParrotSpawnDollItem;
import com.morecritters.mod.item.CorpseQuartermasterSpawnDollItem;
import com.morecritters.mod.item.CorpseTankSpawnDollItem;
import com.morecritters.mod.item.CritterAtlasItem;
import com.morecritters.mod.item.CritterFossil10Item;
import com.morecritters.mod.item.CritterFossil1Item;
import com.morecritters.mod.item.CritterFossil2Item;
import com.morecritters.mod.item.CritterFossil3Item;
import com.morecritters.mod.item.CritterFossil4Item;
import com.morecritters.mod.item.CritterFossil5Item;
import com.morecritters.mod.item.CritterFossil6Item;
import com.morecritters.mod.item.CritterFossil7Item;
import com.morecritters.mod.item.CritterFossil8Item;
import com.morecritters.mod.item.CritterFossil9Item;
import com.morecritters.mod.item.CritterKebab2Item;
import com.morecritters.mod.item.CritterKebab3Item;
import com.morecritters.mod.item.CritterKebabItem;
import com.morecritters.mod.item.CritterlingFossil1Item;
import com.morecritters.mod.item.CritterlingFossil2Item;
import com.morecritters.mod.item.CritterlingFossil3Item;
import com.morecritters.mod.item.CritterlingSackCobbleEpicItem;
import com.morecritters.mod.item.CritterlingSackCobbleItem;
import com.morecritters.mod.item.CritterlingSackCobbleRareItem;
import com.morecritters.mod.item.CritterlingSackCritterEaterItem;
import com.morecritters.mod.item.CritterlingSackCubefrogEpicItem;
import com.morecritters.mod.item.CritterlingSackCubefrogItem;
import com.morecritters.mod.item.CritterlingSackCubefrogRareItem;
import com.morecritters.mod.item.CritterlingSackDominicEpicItem;
import com.morecritters.mod.item.CritterlingSackDominicItem;
import com.morecritters.mod.item.CritterlingSackDominicRareItem;
import com.morecritters.mod.item.CritterlingSackDungerEpicItem;
import com.morecritters.mod.item.CritterlingSackDungerItem;
import com.morecritters.mod.item.CritterlingSackDungerRareItem;
import com.morecritters.mod.item.CritterlingSackExpyEpicItem;
import com.morecritters.mod.item.CritterlingSackExpyItem;
import com.morecritters.mod.item.CritterlingSackExpyRareItem;
import com.morecritters.mod.item.CritterlingSackFlargEpicItem;
import com.morecritters.mod.item.CritterlingSackFlargItem;
import com.morecritters.mod.item.CritterlingSackFlargRareItem;
import com.morecritters.mod.item.CritterlingSackFresnoidEpicItem;
import com.morecritters.mod.item.CritterlingSackFresnoidItem;
import com.morecritters.mod.item.CritterlingSackFresnoidRareItem;
import com.morecritters.mod.item.CritterlingSackGillmunchEpicItem;
import com.morecritters.mod.item.CritterlingSackGillmunchItem;
import com.morecritters.mod.item.CritterlingSackGillmunchRareItem;
import com.morecritters.mod.item.CritterlingSackItem;
import com.morecritters.mod.item.CritterlingSackMangotriceEpicItem;
import com.morecritters.mod.item.CritterlingSackMangotriceItem;
import com.morecritters.mod.item.CritterlingSackMangotriceRareItem;
import com.morecritters.mod.item.CritterlingSackMothkidEpicItem;
import com.morecritters.mod.item.CritterlingSackMothkidItem;
import com.morecritters.mod.item.CritterlingSackMothkidRareItem;
import com.morecritters.mod.item.CritterlingSackOlmerEpicItem;
import com.morecritters.mod.item.CritterlingSackOlmerItem;
import com.morecritters.mod.item.CritterlingSackOlmerRareItem;
import com.morecritters.mod.item.CritterlingSackOpalcrabEpicItem;
import com.morecritters.mod.item.CritterlingSackOpalcrabItem;
import com.morecritters.mod.item.CritterlingSackOpalcrabRareItem;
import com.morecritters.mod.item.CritterlingSackPiranheedEpicItem;
import com.morecritters.mod.item.CritterlingSackPiranheedItem;
import com.morecritters.mod.item.CritterlingSackPiranheedRareItem;
import com.morecritters.mod.item.CritterlingSackPlainswyrmEpicItem;
import com.morecritters.mod.item.CritterlingSackPlainswyrmItem;
import com.morecritters.mod.item.CritterlingSackPlainswyrmRareItem;
import com.morecritters.mod.item.CritterlingSackRollballEpicItem;
import com.morecritters.mod.item.CritterlingSackRollballItem;
import com.morecritters.mod.item.CritterlingSackRollballRareItem;
import com.morecritters.mod.item.CritterlingSackScowlEpicItem;
import com.morecritters.mod.item.CritterlingSackScowlItem;
import com.morecritters.mod.item.CritterlingSackScowlRareItem;
import com.morecritters.mod.item.CritterlingSackSnekEpicItem;
import com.morecritters.mod.item.CritterlingSackSnekItem;
import com.morecritters.mod.item.CritterlingSackSnekRareItem;
import com.morecritters.mod.item.CritterlingSackStalkEpicItem;
import com.morecritters.mod.item.CritterlingSackStalkItem;
import com.morecritters.mod.item.CritterlingSackStalkRareItem;
import com.morecritters.mod.item.CupcakeAsphyxiationItem;
import com.morecritters.mod.item.CupcakeBrittlenessItem;
import com.morecritters.mod.item.CupcakeHallucinaziumItem;
import com.morecritters.mod.item.CupcakeItem;
import com.morecritters.mod.item.CupcakeMuscleAcheItem;
import com.morecritters.mod.item.CupcakeStagnationItem;
import com.morecritters.mod.item.CutlassItem;
import com.morecritters.mod.item.DeathStewItem;
import com.morecritters.mod.item.DripperRemainsItem;
import com.morecritters.mod.item.EctometalItem;
import com.morecritters.mod.item.EerieBarkItem;
import com.morecritters.mod.item.EerieDartItem;
import com.morecritters.mod.item.EndDustBunnyItem;
import com.morecritters.mod.item.EndDustItem;
import com.morecritters.mod.item.EvoliteItem;
import com.morecritters.mod.item.ExplosiveJellyItem;
import com.morecritters.mod.item.FishBoneItem;
import com.morecritters.mod.item.FreezingStringItem;
import com.morecritters.mod.item.FrightshroomSpawnDollItem;
import com.morecritters.mod.item.FungalFleshItem;
import com.morecritters.mod.item.FungalStaffItem;
import com.morecritters.mod.item.FungalZombieSpawnDollItem;
import com.morecritters.mod.item.GlowingOozeItem;
import com.morecritters.mod.item.GraveBrushItem;
import com.morecritters.mod.item.GravediggerAppendageItem;
import com.morecritters.mod.item.HardtackItem;
import com.morecritters.mod.item.HardtackPieceItem;
import com.morecritters.mod.item.HealingRumItem;
import com.morecritters.mod.item.Icon10Item;
import com.morecritters.mod.item.Icon11Item;
import com.morecritters.mod.item.Icon12Item;
import com.morecritters.mod.item.Icon13Item;
import com.morecritters.mod.item.Icon14Item;
import com.morecritters.mod.item.Icon15Item;
import com.morecritters.mod.item.Icon16Item;
import com.morecritters.mod.item.Icon17Item;
import com.morecritters.mod.item.Icon18Item;
import com.morecritters.mod.item.Icon19Item;
import com.morecritters.mod.item.Icon1Item;
import com.morecritters.mod.item.Icon20Item;
import com.morecritters.mod.item.Icon2Item;
import com.morecritters.mod.item.Icon3Item;
import com.morecritters.mod.item.Icon4Item;
import com.morecritters.mod.item.Icon5Item;
import com.morecritters.mod.item.Icon6Item;
import com.morecritters.mod.item.Icon7Item;
import com.morecritters.mod.item.Icon8Item;
import com.morecritters.mod.item.Icon9Item;
import com.morecritters.mod.item.InfestedHardtackItem;
import com.morecritters.mod.item.InfusedCannonBallColdItem;
import com.morecritters.mod.item.InfusedCannonBallCombustingItem;
import com.morecritters.mod.item.InfusedCannonBallElectricItem;
import com.morecritters.mod.item.InfusedCannonBallFireItem;
import com.morecritters.mod.item.InfusedCannonBallSlimeItem;
import com.morecritters.mod.item.IroballItemItem;
import com.morecritters.mod.item.IropodBucketItem;
import com.morecritters.mod.item.IropodHelmetItem;
import com.morecritters.mod.item.JellyTorpedoItemItem;
import com.morecritters.mod.item.KelpireRollPieceItem;
import com.morecritters.mod.item.LargeBombJellyItem;
import com.morecritters.mod.item.LifeStewItem;
import com.morecritters.mod.item.LostNerveItem;
import com.morecritters.mod.item.MediumBombJellyItem;
import com.morecritters.mod.item.MightshroomRibsItem;
import com.morecritters.mod.item.MoldedShellItem;
import com.morecritters.mod.item.MusicDiscGrooveyardItem;
import com.morecritters.mod.item.MusicDiscPartyItem;
import com.morecritters.mod.item.MusicDiscReaperItem;
import com.morecritters.mod.item.MusicDiscSailsItem;
import com.morecritters.mod.item.MusicDiscWaddleItem;
import com.morecritters.mod.item.MysteriousVirusBottleItem;
import com.morecritters.mod.item.NauticalAxeItem;
import com.morecritters.mod.item.NauticalHelmetItem;
import com.morecritters.mod.item.NauticrawlTentacleItem;
import com.morecritters.mod.item.NervalSaladItem;
import com.morecritters.mod.item.NightshroomSpawnDollItem;
import com.morecritters.mod.item.OozeRodItem;
import com.morecritters.mod.item.PartyHatItem;
import com.morecritters.mod.item.PearlItem;
import com.morecritters.mod.item.PebbleIconItem;
import com.morecritters.mod.item.PirateItem;
import com.morecritters.mod.item.PlantFossil1Item;
import com.morecritters.mod.item.PlantFossil2Item;
import com.morecritters.mod.item.PlantFossil3Item;
import com.morecritters.mod.item.PlantFossil4Item;
import com.morecritters.mod.item.PoppedNervalMixtureItem;
import com.morecritters.mod.item.PurgatorialMixtureItem;
import com.morecritters.mod.item.RamchuBucketItem;
import com.morecritters.mod.item.RamchuBucketNoOilItem;
import com.morecritters.mod.item.RamchuBucketNoShellItem;
import com.morecritters.mod.item.RamchuFryBucketItem;
import com.morecritters.mod.item.RamchuOilBottleItem;
import com.morecritters.mod.item.RawBlubberfishItem;
import com.morecritters.mod.item.RawBunbugMeatItem;
import com.morecritters.mod.item.RegenerativeFleshItem;
import com.morecritters.mod.item.RotZombieSpawnDollItem;
import com.morecritters.mod.item.SackofFreezingItem;
import com.morecritters.mod.item.SculkEssenceItem;
import com.morecritters.mod.item.SharkToothItem;
import com.morecritters.mod.item.ShellPiecesItem;
import com.morecritters.mod.item.ShimmerwormItemItem;
import com.morecritters.mod.item.ShriekBombItem;
import com.morecritters.mod.item.ShriekbatSoupItem;
import com.morecritters.mod.item.ShriekbatWingItem;
import com.morecritters.mod.item.SlashklubItem;
import com.morecritters.mod.item.SmallBombJellyItem;
import com.morecritters.mod.item.SoulRumItem;
import com.morecritters.mod.item.SpikedIroballItem;
import com.morecritters.mod.item.SpinalFluidBottleItem;
import com.morecritters.mod.item.SprinklesItem;
import com.morecritters.mod.item.StinarpBucketItem;
import com.morecritters.mod.item.SturdyItem;
import com.morecritters.mod.item.SturdyShellsItem;
import com.morecritters.mod.item.TabIconItem;
import com.morecritters.mod.item.TaserItem;
import com.morecritters.mod.item.TatteredClothItem;
import com.morecritters.mod.item.TazegunItem;
import com.morecritters.mod.item.ToothMelterItem;
import com.morecritters.mod.item.ToothSyringeItem;
import com.morecritters.mod.item.ToxinBladderAsphyxiationItem;
import com.morecritters.mod.item.ToxinBladderBrittlenessItem;
import com.morecritters.mod.item.ToxinBladderHallucinaziumItem;
import com.morecritters.mod.item.ToxinBladderMuscleAcheItem;
import com.morecritters.mod.item.ToxinBladderStagnationItem;
import com.morecritters.mod.item.TreasureKeyItem;
import com.morecritters.mod.item.WebSackItem;
import com.morecritters.mod.item.ZombieNauticrawlSpawnDollItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(bus = Bus.MOD, value = Dist.CLIENT)
public class MoreCrittersModItems {
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(Registries.ITEM, "more_critters");
    public static final DeferredHolder<Item, Item> WANDERING_COLLECTOR_SPAWN_EGG = REGISTRY.register(
        "wandering_collector_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.WANDERING_COLLECTOR, -6804417, -4290452, new Properties())
    );
    public static final DeferredHolder<Item, Item> CARRYBUG_SPAWN_EGG = REGISTRY.register(
        "carrybug_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.CARRYBUG, -14079188, -1118482, new Properties())
    );
    public static final DeferredHolder<Item, Item> BUNBUG_SPAWN_EGG = REGISTRY.register(
        "bunbug_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.BUNBUG, -9324, -7779546, new Properties())
    );
    public static final DeferredHolder<Item, Item> BUNBUG_EGGS = REGISTRY.register("bunbug_eggs", () -> new BunbugEggsItem());
    public static final DeferredHolder<Item, Item> RAW_BUNBUG_MEAT = REGISTRY.register("raw_bunbug_meat", () -> new RawBunbugMeatItem());
    public static final DeferredHolder<Item, Item> COOKED_BUNBUG_MEAT = REGISTRY.register("cooked_bunbug_meat", () -> new CookedBunbugMeatItem());
    public static final DeferredHolder<Item, Item> SNOWFLAKE_SPIDER_SPAWN_EGG = REGISTRY.register(
        "snowflake_spider_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.SNOWFLAKE_SPIDER, -789517, -16726017, new Properties())
    );
    public static final DeferredHolder<Item, Item> SACKOF_FREEZING = REGISTRY.register("sackof_freezing", () -> new SackofFreezingItem());
    public static final DeferredHolder<Item, Item> FREEZING_STRING = REGISTRY.register("freezing_string", () -> new FreezingStringItem());
    public static final DeferredHolder<Item, Item> FREEZING_COBWEB = block(MoreCrittersModBlocks.FREEZING_COBWEB);
    public static final DeferredHolder<Item, Item> COLDSTONE = block(MoreCrittersModBlocks.COLDSTONE);
    public static final DeferredHolder<Item, Item> COLDSTONE_STAIRS = block(MoreCrittersModBlocks.COLDSTONE_STAIRS);
    public static final DeferredHolder<Item, Item> COLDSTONE_SLAB = block(MoreCrittersModBlocks.COLDSTONE_SLAB);
    public static final DeferredHolder<Item, Item> COLDSTONE_WALL = block(MoreCrittersModBlocks.COLDSTONE_WALL);
    public static final DeferredHolder<Item, Item> COLDSTONE_BRICKS = block(MoreCrittersModBlocks.COLDSTONE_BRICKS);
    public static final DeferredHolder<Item, Item> COLDSTONE_BRICK_STAIRS = block(MoreCrittersModBlocks.COLDSTONE_BRICK_STAIRS);
    public static final DeferredHolder<Item, Item> COLDSTONE_BRICK_SLAB = block(MoreCrittersModBlocks.COLDSTONE_BRICK_SLAB);
    public static final DeferredHolder<Item, Item> COLDSTONE_BRICK_WALL = block(MoreCrittersModBlocks.COLDSTONE_BRICK_WALL);
    public static final DeferredHolder<Item, Item> CHISELED_COLDSTONE = block(MoreCrittersModBlocks.CHISELED_COLDSTONE);
    public static final DeferredHolder<Item, Item> POLISHED_COLDSTONE = block(MoreCrittersModBlocks.POLISHED_COLDSTONE);
    public static final DeferredHolder<Item, Item> POLISHED_COLDSTONE_STAIRS = block(MoreCrittersModBlocks.POLISHED_COLDSTONE_STAIRS);
    public static final DeferredHolder<Item, Item> POLISHED_COLDSTONE_SLAB = block(MoreCrittersModBlocks.POLISHED_COLDSTONE_SLAB);
    public static final DeferredHolder<Item, Item> POLISHED_COLDSTONE_WALL = block(MoreCrittersModBlocks.POLISHED_COLDSTONE_WALL);
    public static final DeferredHolder<Item, Item> WEB_SACK = REGISTRY.register("web_sack", () -> new WebSackItem());
    public static final DeferredHolder<Item, Item> SHRIEKBAT_SPAWN_EGG = REGISTRY.register(
        "shriekbat_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.SHRIEKBAT, -14998484, -3127417, new Properties())
    );
    public static final DeferredHolder<Item, Item> SHRIEKBAT_WING = REGISTRY.register("shriekbat_wing", () -> new ShriekbatWingItem());
    public static final DeferredHolder<Item, Item> SHRIEK_BOMB = REGISTRY.register("shriek_bomb", () -> new ShriekBombItem());
    public static final DeferredHolder<Item, Item> SHRIEKBAT_SOUP = REGISTRY.register("shriekbat_soup", () -> new ShriekbatSoupItem());
    public static final DeferredHolder<Item, Item> CREEBLOSSOM_SPAWN_EGG = REGISTRY.register(
        "creeblossom_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.CREEBLOSSOM, -3551409, -10283217, new Properties())
    );
    public static final DeferredHolder<Item, Item> BLOSSOMBUSH_SEED = REGISTRY.register("blossombush_seed", () -> new BlossombushSeedItem());
    public static final DeferredHolder<Item, Item> BLOSSOMBUSH = block(MoreCrittersModBlocks.BLOSSOMBUSH);
    public static final DeferredHolder<Item, Item> CLOSED_BLOSSOMBUSH = block(MoreCrittersModBlocks.CLOSED_BLOSSOMBUSH);
    public static final DeferredHolder<Item, Item> BOUNCELIZARD_EGG = block(MoreCrittersModBlocks.BOUNCELIZARD_EGG);
    public static final DeferredHolder<Item, Item> BOUNCELIZARD_SPAWN_EGG = REGISTRY.register(
        "bouncelizard_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.BOUNCELIZARD, -13664860, -1, new Properties())
    );
    public static final DeferredHolder<Item, Item> BOUNCEBERRY = REGISTRY.register("bounceberry", () -> new BounceberryItem());
    public static final DeferredHolder<Item, Item> STINCARP_SPAWN_EGG = REGISTRY.register(
        "stincarp_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.STINCARP, -4750281, -8716314, new Properties())
    );
    public static final DeferredHolder<Item, Item> BOTTLEO_ELECTRICITY = REGISTRY.register("bottleo_electricity", () -> new BottleoElectricityItem());
    public static final DeferredHolder<Item, Item> TASER = REGISTRY.register("taser", () -> new TaserItem());
    public static final DeferredHolder<Item, Item> ELECTRIC_BLOSSOMBUSH = block(MoreCrittersModBlocks.ELECTRIC_BLOSSOMBUSH);
    public static final DeferredHolder<Item, Item> CLOSED_ELECTRIC_BLOSSOMBUSH = block(MoreCrittersModBlocks.CLOSED_ELECTRIC_BLOSSOMBUSH);
    public static final DeferredHolder<Item, Item> BALLOON_RAT_SPAWN_EGG = REGISTRY.register(
        "balloon_rat_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.BALLOON_RAT, -15660537, -2064341, new Properties())
    );
    public static final DeferredHolder<Item, Item> WARPTRAP_SPAWN_EGG = REGISTRY.register(
        "warptrap_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.WARPTRAP, -6772828, -15623291, new Properties())
    );
    public static final DeferredHolder<Item, Item> STURDY_SHELLS = REGISTRY.register("sturdy_shells", () -> new SturdyShellsItem());
    public static final DeferredHolder<Item, Item> STURDY_SHELL_BLOCK = block(MoreCrittersModBlocks.STURDY_SHELL_BLOCK);
    public static final DeferredHolder<Item, Item> BUNBUG_BURGER = REGISTRY.register("bunbug_burger", () -> new BunbugBurgerItem());
    public static final DeferredHolder<Item, Item> STURDY_CHESTPLATE = REGISTRY.register("sturdy_chestplate", () -> new SturdyItem.Chestplate());
    public static final DeferredHolder<Item, Item> BITING_SHIELD = REGISTRY.register("biting_shield", () -> new BitingShieldItem());
    public static final DeferredHolder<Item, Item> END_DUST = REGISTRY.register("end_dust", () -> new EndDustItem());
    public static final DeferredHolder<Item, Item> SHIMMERWORM_ITEM = REGISTRY.register("shimmerworm_item", () -> new ShimmerwormItemItem());
    public static final DeferredHolder<Item, Item> SHIMMERING_CHRYSALIS = block(MoreCrittersModBlocks.SHIMMERING_CHRYSALIS);
    public static final DeferredHolder<Item, Item> SHIMMERWING_SPAWN_EGG = REGISTRY.register(
        "shimmerwing_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.SHIMMERWING, -7974530, -6366977, new Properties())
    );
    public static final DeferredHolder<Item, Item> MIGHTSHROOM_SPAWN_EGG = REGISTRY.register(
        "mightshroom_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.MIGHTSHROOM, -14276832, -8750470, new Properties())
    );
    public static final DeferredHolder<Item, Item> VITA_SHROOM = block(MoreCrittersModBlocks.VITA_SHROOM);
    public static final DeferredHolder<Item, Item> MORI_SHROOM = block(MoreCrittersModBlocks.MORI_SHROOM);
    public static final DeferredHolder<Item, Item> PURGATORIAL_MIXTURE = REGISTRY.register("purgatorial_mixture", () -> new PurgatorialMixtureItem());
    public static final DeferredHolder<Item, Item> LIFE_STEW = REGISTRY.register("life_stew", () -> new LifeStewItem());
    public static final DeferredHolder<Item, Item> DEATH_STEW = REGISTRY.register("death_stew", () -> new DeathStewItem());
    public static final DeferredHolder<Item, Item> ANCIENT_BONE = REGISTRY.register("ancient_bone", () -> new AncientBoneItem());
    public static final DeferredHolder<Item, Item> REGENERATIVE_FLESH = REGISTRY.register("regenerative_flesh", () -> new RegenerativeFleshItem());
    public static final DeferredHolder<Item, Item> FUNGAL_FLESH = REGISTRY.register("fungal_flesh", () -> new FungalFleshItem());
    public static final DeferredHolder<Item, Item> VITA_SHROOM_BLOCK = block(MoreCrittersModBlocks.VITA_SHROOM_BLOCK);
    public static final DeferredHolder<Item, Item> MORI_SHROOM_BLOCK = block(MoreCrittersModBlocks.MORI_SHROOM_BLOCK);
    public static final DeferredHolder<Item, Item> POT_BLOSSOMBUSH = block(MoreCrittersModBlocks.POT_BLOSSOMBUSH);
    public static final DeferredHolder<Item, Item> POT_ELECTRIC_BLOSSOMBUSH = block(MoreCrittersModBlocks.POT_ELECTRIC_BLOSSOMBUSH);
    public static final DeferredHolder<Item, Item> POT_VITA = block(MoreCrittersModBlocks.POT_VITA);
    public static final DeferredHolder<Item, Item> POT_MORI = block(MoreCrittersModBlocks.POT_MORI);
    public static final DeferredHolder<Item, Item> ANCIENT_SKELETON_ITEM = REGISTRY.register("ancient_skeleton_item", () -> new AncientSkeletonItemItem());
    public static final DeferredHolder<Item, Item> CHISELED_MUSHROOM_STEM_EYE = block(MoreCrittersModBlocks.CHISELED_MUSHROOM_STEM_EYE);
    public static final DeferredHolder<Item, Item> CHISELED_MUSHROOM_STEM_SPIRAL = block(MoreCrittersModBlocks.CHISELED_MUSHROOM_STEM_SPIRAL);
    public static final DeferredHolder<Item, Item> CHISELED_MUSHROOM_STEM_BIRD = block(MoreCrittersModBlocks.CHISELED_MUSHROOM_STEM_BIRD);
    public static final DeferredHolder<Item, Item> CHISELED_MUSHROOM_STEM_MUSHROOM = block(MoreCrittersModBlocks.CHISELED_MUSHROOM_STEM_MUSHROOM);
    public static final DeferredHolder<Item, Item> CHISELED_MUSHROOM_STEM_FIRE = block(MoreCrittersModBlocks.CHISELED_MUSHROOM_STEM_FIRE);
    public static final DeferredHolder<Item, Item> CHISELED_MUSHROOM_STEM_THING = block(MoreCrittersModBlocks.CHISELED_MUSHROOM_STEM_THING);
    public static final DeferredHolder<Item, Item> FUNGAL_ZOMBIE_SPAWN_DOLL = REGISTRY.register("fungal_zombie_spawn_doll", () -> new FungalZombieSpawnDollItem());
    public static final DeferredHolder<Item, Item> FRIGHTSHROOM_SPAWN_DOLL = REGISTRY.register("frightshroom_spawn_doll", () -> new FrightshroomSpawnDollItem());
    public static final DeferredHolder<Item, Item> FUNGAL_STAFF = REGISTRY.register("fungal_staff", () -> new FungalStaffItem());
    public static final DeferredHolder<Item, Item> NIGHTSHROOM_SPAWN_DOLL = REGISTRY.register("nightshroom_spawn_doll", () -> new NightshroomSpawnDollItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK = REGISTRY.register("critterling_sack", () -> new CritterlingSackItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_CUBEFROG = REGISTRY.register("critterling_sack_cubefrog", () -> new CritterlingSackCubefrogItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_PLAINSWYRM = REGISTRY.register(
        "critterling_sack_plainswyrm", () -> new CritterlingSackPlainswyrmItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_DUNGER = REGISTRY.register("critterling_sack_dunger", () -> new CritterlingSackDungerItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_SNEK = REGISTRY.register("critterling_sack_snek", () -> new CritterlingSackSnekItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_EXPY = REGISTRY.register("critterling_sack_expy", () -> new CritterlingSackExpyItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_SCOWL = REGISTRY.register("critterling_sack_scowl", () -> new CritterlingSackScowlItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_ROLLBALL = REGISTRY.register("critterling_sack_rollball", () -> new CritterlingSackRollballItem());
    public static final DeferredHolder<Item, Item> FOSSIL_BLOCK = block(MoreCrittersModBlocks.FOSSIL_BLOCK);
    public static final DeferredHolder<Item, Item> DEEPSLATE_FOSSIL_BLOCK = block(MoreCrittersModBlocks.DEEPSLATE_FOSSIL_BLOCK);
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_1 = REGISTRY.register("critter_fossil_1", () -> new CritterFossil1Item());
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_2 = REGISTRY.register("critter_fossil_2", () -> new CritterFossil2Item());
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_3 = REGISTRY.register("critter_fossil_3", () -> new CritterFossil3Item());
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_4 = REGISTRY.register("critter_fossil_4", () -> new CritterFossil4Item());
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_5 = REGISTRY.register("critter_fossil_5", () -> new CritterFossil5Item());
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_6 = REGISTRY.register("critter_fossil_6", () -> new CritterFossil6Item());
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_7 = REGISTRY.register("critter_fossil_7", () -> new CritterFossil7Item());
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_8 = REGISTRY.register("critter_fossil_8", () -> new CritterFossil8Item());
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_9 = REGISTRY.register("critter_fossil_9", () -> new CritterFossil9Item());
    public static final DeferredHolder<Item, Item> CRITTER_FOSSIL_10 = REGISTRY.register("critter_fossil_10", () -> new CritterFossil10Item());
    public static final DeferredHolder<Item, Item> CRITTERLING_FOSSIL_1 = REGISTRY.register("critterling_fossil_1", () -> new CritterlingFossil1Item());
    public static final DeferredHolder<Item, Item> CRITTERLING_FOSSIL_2 = REGISTRY.register("critterling_fossil_2", () -> new CritterlingFossil2Item());
    public static final DeferredHolder<Item, Item> CRITTERLING_FOSSIL_3 = REGISTRY.register("critterling_fossil_3", () -> new CritterlingFossil3Item());
    public static final DeferredHolder<Item, Item> PLANT_FOSSIL_1 = REGISTRY.register("plant_fossil_1", () -> new PlantFossil1Item());
    public static final DeferredHolder<Item, Item> PLANT_FOSSIL_2 = REGISTRY.register("plant_fossil_2", () -> new PlantFossil2Item());
    public static final DeferredHolder<Item, Item> PLANT_FOSSIL_3 = REGISTRY.register("plant_fossil_3", () -> new PlantFossil3Item());
    public static final DeferredHolder<Item, Item> PLANT_FOSSIL_4 = REGISTRY.register("plant_fossil_4", () -> new PlantFossil4Item());
    public static final DeferredHolder<Item, Item> CRITTER_ATLAS = REGISTRY.register("critter_atlas", () -> new CritterAtlasItem());
    public static final DeferredHolder<Item, Item> TAB_ICON = REGISTRY.register("tab_icon", () -> new TabIconItem());
    public static final DeferredHolder<Item, Item> BUNBUG_CAVIAR = REGISTRY.register("bunbug_caviar", () -> new BunbugCaviarItem());
    public static final DeferredHolder<Item, Item> BOUNCEBERRY_JAM = REGISTRY.register("bounceberry_jam", () -> new BounceberryJamItem());
    public static final DeferredHolder<Item, Item> COOKED_BOUNCELIZARD_EGG = REGISTRY.register("cooked_bouncelizard_egg", () -> new CookedBouncelizardEggItem());
    public static final DeferredHolder<Item, Item> BOUNCEBERRY_SANDWICH = REGISTRY.register("bounceberry_sandwich", () -> new BounceberrySandwichItem());
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY = block(MoreCrittersModBlocks.FOSSIL_DISPLAY);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_1 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_1);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_2 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_2);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_3 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_3);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_4 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_4);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_5 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_5);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_6 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_6);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_7 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_7);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_8 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_8);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_9 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_9);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_10 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_10);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_11 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_11);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_12 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_12);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_13 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_13);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_14 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_14);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_15 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_15);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_16 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_16);
    public static final DeferredHolder<Item, Item> FOSSIL_DISPLAY_17 = block(MoreCrittersModBlocks.FOSSIL_DISPLAY_17);
    public static final DeferredHolder<Item, Item> ICON_1 = REGISTRY.register("icon_1", () -> new Icon1Item());
    public static final DeferredHolder<Item, Item> ICON_2 = REGISTRY.register("icon_2", () -> new Icon2Item());
    public static final DeferredHolder<Item, Item> ICON_3 = REGISTRY.register("icon_3", () -> new Icon3Item());
    public static final DeferredHolder<Item, Item> ICON_4 = REGISTRY.register("icon_4", () -> new Icon4Item());
    public static final DeferredHolder<Item, Item> ICON_5 = REGISTRY.register("icon_5", () -> new Icon5Item());
    public static final DeferredHolder<Item, Item> ICON_6 = REGISTRY.register("icon_6", () -> new Icon6Item());
    public static final DeferredHolder<Item, Item> ICON_7 = REGISTRY.register("icon_7", () -> new Icon7Item());
    public static final DeferredHolder<Item, Item> MUSIC_DISC_REAPER = REGISTRY.register("music_disc_reaper", () -> new MusicDiscReaperItem());
    public static final DeferredHolder<Item, Item> EXPLOSIVE_JELLY = REGISTRY.register("explosive_jelly", () -> new ExplosiveJellyItem());
    public static final DeferredHolder<Item, Item> BOMB_JELLY_SPAWN_EGG = REGISTRY.register(
        "bomb_jelly_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.BOMB_JELLY, -2024372, -16054261, new Properties())
    );
    public static final DeferredHolder<Item, Item> SMALL_BOMB_JELLY_BUCKET = REGISTRY.register("small_bomb_jelly_bucket", () -> new SmallBombJellyItem());
    public static final DeferredHolder<Item, Item> MEDIUM_BOMB_JELLY_BUCKET = REGISTRY.register("medium_bomb_jelly_bucket", () -> new MediumBombJellyItem());
    public static final DeferredHolder<Item, Item> LARGE_BOMB_JELLY_BUCKET = REGISTRY.register("large_bomb_jelly_bucket", () -> new LargeBombJellyItem());
    public static final DeferredHolder<Item, Item> AVOIDER_SPAWN_EGG = REGISTRY.register(
        "avoider_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.AVOIDER, -9600110, -2500135, new Properties())
    );
    public static final DeferredHolder<Item, Item> AVOIDER_TAIL = REGISTRY.register("avoider_tail", () -> new AvoiderTailItem());
    public static final DeferredHolder<Item, Item> AVOIDER_BUCKET_BUCKET = REGISTRY.register("avoider_bucket_bucket", () -> new AvoiderBucketItem());
    public static final DeferredHolder<Item, Item> BOOSTER_PUMP = REGISTRY.register("booster_pump", () -> new BoosterPumpItem());
    public static final DeferredHolder<Item, Item> JELLY_TORPEDO_ITEM = REGISTRY.register("jelly_torpedo_item", () -> new JellyTorpedoItemItem());
    public static final DeferredHolder<Item, Item> IROPOD_SPAWN_EGG = REGISTRY.register(
        "iropod_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.IROPOD, -6974059, -14013897, new Properties())
    );
    public static final DeferredHolder<Item, Item> MOLDED_SHELL = REGISTRY.register("molded_shell", () -> new MoldedShellItem());
    public static final DeferredHolder<Item, Item> IROPOD_BUCKET_BUCKET = REGISTRY.register("iropod_bucket_bucket", () -> new IropodBucketItem());
    public static final DeferredHolder<Item, Item> BLACK_IROPOD_BUCKET_BUCKET = REGISTRY.register("black_iropod_bucket_bucket", () -> new BlackIropodBucketItem());
    public static final DeferredHolder<Item, Item> IROPOD_HELMET_HELMET = REGISTRY.register("iropod_helmet_helmet", () -> new IropodHelmetItem.Helmet());
    public static final DeferredHolder<Item, Item> BLUBBERFISH_SPAWN_EGG = REGISTRY.register(
        "blubberfish_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.BLUBBERFISH, -7043514, -333383, new Properties())
    );
    public static final DeferredHolder<Item, Item> RAW_BLUBBERFISH = REGISTRY.register("raw_blubberfish", () -> new RawBlubberfishItem());
    public static final DeferredHolder<Item, Item> COOKED_BLUBBERFISH = REGISTRY.register("cooked_blubberfish", () -> new CookedBlubberfishItem());
    public static final DeferredHolder<Item, Item> BLUBBERFISH_BUCKET_BUCKET = REGISTRY.register("blubberfish_bucket_bucket", () -> new BlubberfishBucketItem());
    public static final DeferredHolder<Item, Item> KELPIRE_SPAWN_EGG = REGISTRY.register(
        "kelpire_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.KELPIRE, -11706853, -10900688, new Properties())
    );
    public static final DeferredHolder<Item, Item> NAUTICRAWL_SPAWN_EGG = REGISTRY.register(
        "nauticrawl_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.NAUTICRAWL, -14143957, -1846828, new Properties())
    );
    public static final DeferredHolder<Item, Item> SHELL_PIECES = REGISTRY.register("shell_pieces", () -> new ShellPiecesItem());
    public static final DeferredHolder<Item, Item> NAUTICAL_HELMET_HELMET = REGISTRY.register("nautical_helmet_helmet", () -> new NauticalHelmetItem.Helmet());
    public static final DeferredHolder<Item, Item> NAUTICRAWL_SHELL = block(MoreCrittersModBlocks.NAUTICRAWL_SHELL);
    public static final DeferredHolder<Item, Item> BLUBBERFISH_FRY_BUCKET_BUCKET = REGISTRY.register(
        "blubberfish_fry_bucket_bucket", () -> new BlubberfishFryBucketItem()
    );
    public static final DeferredHolder<Item, Item> AVOIDER_FRY_BUCKET_BUCKET = REGISTRY.register("avoider_fry_bucket_bucket", () -> new AvoiderFryBucketItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_OPALCRAB = REGISTRY.register("critterling_sack_opalcrab", () -> new CritterlingSackOpalcrabItem());
    public static final DeferredHolder<Item, Item> NAUTICAL_AXE = REGISTRY.register("nautical_axe", () -> new NauticalAxeItem());
    public static final DeferredHolder<Item, Item> ICON_8 = REGISTRY.register("icon_8", () -> new Icon8Item());
    public static final DeferredHolder<Item, Item> ICON_9 = REGISTRY.register("icon_9", () -> new Icon9Item());
    public static final DeferredHolder<Item, Item> ICON_10 = REGISTRY.register("icon_10", () -> new Icon10Item());
    public static final DeferredHolder<Item, Item> STINARP_BUCKET_BUCKET = REGISTRY.register("stinarp_bucket_bucket", () -> new StinarpBucketItem());
    public static final DeferredHolder<Item, Item> ANCIENT_SKELETON_EXHIBIT_ITEM = REGISTRY.register(
        "ancient_skeleton_exhibit_item", () -> new AncientSkeletonExhibitItemItem()
    );
    public static final DeferredHolder<Item, Item> MUSIC_DISC_SAILS = REGISTRY.register("music_disc_sails", () -> new MusicDiscSailsItem());
    public static final DeferredHolder<Item, Item> CUPCAKE = REGISTRY.register("cupcake", () -> new CupcakeItem());
    public static final DeferredHolder<Item, Item> CUPCAKE_STAGNATION = REGISTRY.register("cupcake_stagnation", () -> new CupcakeStagnationItem());
    public static final DeferredHolder<Item, Item> CUPCAKE_MUSCLE_ACHE = REGISTRY.register("cupcake_muscle_ache", () -> new CupcakeMuscleAcheItem());
    public static final DeferredHolder<Item, Item> CUPCAKE_BRITTLENESS = REGISTRY.register("cupcake_brittleness", () -> new CupcakeBrittlenessItem());
    public static final DeferredHolder<Item, Item> CUPCAKE_HALLUCINAZIUM = REGISTRY.register("cupcake_hallucinazium", () -> new CupcakeHallucinaziumItem());
    public static final DeferredHolder<Item, Item> CUPCAKE_ASPHYXIATION = REGISTRY.register("cupcake_asphyxiation", () -> new CupcakeAsphyxiationItem());
    public static final DeferredHolder<Item, Item> TOXIN_BLADDER_STAGNATION = REGISTRY.register("toxin_bladder_stagnation", () -> new ToxinBladderStagnationItem());
    public static final DeferredHolder<Item, Item> TOXIN_BLADDER_MUSCLE_ACHE = REGISTRY.register("toxin_bladder_muscle_ache", () -> new ToxinBladderMuscleAcheItem());
    public static final DeferredHolder<Item, Item> TOXIN_BLADDER_BRITTLENESS = REGISTRY.register("toxin_bladder_brittleness", () -> new ToxinBladderBrittlenessItem());
    public static final DeferredHolder<Item, Item> TOXIN_BLADDER_HALLUCINAZIUM = REGISTRY.register(
        "toxin_bladder_hallucinazium", () -> new ToxinBladderHallucinaziumItem()
    );
    public static final DeferredHolder<Item, Item> TOXIN_BLADDER_ASPHYXIATION = REGISTRY.register(
        "toxin_bladder_asphyxiation", () -> new ToxinBladderAsphyxiationItem()
    );
    public static final DeferredHolder<Item, Item> ICON_11 = REGISTRY.register("icon_11", () -> new Icon11Item());
    public static final DeferredHolder<Item, Item> SHADELET_SPAWN_EGG = REGISTRY.register(
        "shadelet_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.SHADELET, -2431773, -14526376, new Properties())
    );
    public static final DeferredHolder<Item, Item> TOOTH_MELTER = REGISTRY.register("tooth_melter", () -> new ToothMelterItem());
    public static final DeferredHolder<Item, Item> TREEPLET_SPAWN_EGG = REGISTRY.register(
        "treeplet_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.TREEPLET, -987413, -13224918, new Properties())
    );
    public static final DeferredHolder<Item, Item> EERIE_BARK = REGISTRY.register("eerie_bark", () -> new EerieBarkItem());
    public static final DeferredHolder<Item, Item> BLACK_RESIN_BRICK = REGISTRY.register("black_resin_brick", () -> new BlackResinBrickItem());
    public static final DeferredHolder<Item, Item> BLACK_RESIN_CLUMP = REGISTRY.register("black_resin_clump", () -> new BlackResinClumpItem());
    public static final DeferredHolder<Item, Item> EERIE_BIRCH_LOG = block(MoreCrittersModBlocks.EERIE_BIRCH_LOG);
    public static final DeferredHolder<Item, Item> EERIE_BIRCH_WOOD = block(MoreCrittersModBlocks.EERIE_BIRCH_WOOD);
    public static final DeferredHolder<Item, Item> BLACK_RESIN_BLOCK = block(MoreCrittersModBlocks.BLACK_RESIN_BLOCK);
    public static final DeferredHolder<Item, Item> BLACK_RESIN_BRICKS = block(MoreCrittersModBlocks.BLACK_RESIN_BRICKS);
    public static final DeferredHolder<Item, Item> CHISELED_BLACK_RESIN_BRICKS = block(MoreCrittersModBlocks.CHISELED_BLACK_RESIN_BRICKS);
    public static final DeferredHolder<Item, Item> BLACK_RESIN_BRICK_STAIRS = block(MoreCrittersModBlocks.BLACK_RESIN_BRICK_STAIRS);
    public static final DeferredHolder<Item, Item> BLACK_RESIN_BRICK_SLAB = block(MoreCrittersModBlocks.BLACK_RESIN_BRICK_SLAB);
    public static final DeferredHolder<Item, Item> BLACK_RESIN_BRICK_WALL = block(MoreCrittersModBlocks.BLACK_RESIN_BRICK_WALL);
    public static final DeferredHolder<Item, Item> EERIE_DART = REGISTRY.register("eerie_dart", () -> new EerieDartItem());
    public static final DeferredHolder<Item, Item> SPINAL_FLUID_BOTTLE = REGISTRY.register("spinal_fluid_bottle", () -> new SpinalFluidBottleItem());
    public static final DeferredHolder<Item, Item> MYSTERIOUS_VIRUS_BOTTLE = REGISTRY.register("mysterious_virus_bottle", () -> new MysteriousVirusBottleItem());
    public static final DeferredHolder<Item, Item> LOST_NERVE = REGISTRY.register("lost_nerve", () -> new LostNerveItem());
    public static final DeferredHolder<Item, Item> COOKED_NERVE = REGISTRY.register("cooked_nerve", () -> new CookedNerveItem());
    public static final DeferredHolder<Item, Item> NERVAL_SALAD = REGISTRY.register("nerval_salad", () -> new NervalSaladItem());
    public static final DeferredHolder<Item, Item> POPPED_NERVAL_MIXTURE = REGISTRY.register("popped_nerval_mixture", () -> new PoppedNervalMixtureItem());
    public static final DeferredHolder<Item, Item> NERVOID_SPAWN_EGG = REGISTRY.register(
        "nervoid_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.NERVOID, -4685313, -1129729, new Properties())
    );
    public static final DeferredHolder<Item, Item> NERVOID_BRAIN = block(MoreCrittersModBlocks.NERVOID_BRAIN);
    public static final DeferredHolder<Item, Item> DECOMPOSING_NERVOID_BRAIN = block(MoreCrittersModBlocks.DECOMPOSING_NERVOID_BRAIN);
    public static final DeferredHolder<Item, Item> ROTTEN_NERVOID_BRAIN = block(MoreCrittersModBlocks.ROTTEN_NERVOID_BRAIN);
    public static final DeferredHolder<Item, Item> ICED_NERVOID_BRAIN = block(MoreCrittersModBlocks.ICED_NERVOID_BRAIN);
    public static final DeferredHolder<Item, Item> ICED_DECOMPOSING_NERVOID_BRAIN = block(MoreCrittersModBlocks.ICED_DECOMPOSING_NERVOID_BRAIN);
    public static final DeferredHolder<Item, Item> ICED_ROTTEN_NERVOID_BRAIN = block(MoreCrittersModBlocks.ICED_ROTTEN_NERVOID_BRAIN);
    public static final DeferredHolder<Item, Item> GHOSTLY_PLANKS = block(MoreCrittersModBlocks.GHOSTLY_PLANKS);
    public static final DeferredHolder<Item, Item> GHOSTLY_STAIRS = block(MoreCrittersModBlocks.GHOSTLY_STAIRS);
    public static final DeferredHolder<Item, Item> GHOSTLY_SLAB = block(MoreCrittersModBlocks.GHOSTLY_SLAB);
    public static final DeferredHolder<Item, Item> GHOSTLY_FENCE = block(MoreCrittersModBlocks.GHOSTLY_FENCE);
    public static final DeferredHolder<Item, Item> GHOSTLY_FENCE_GATE = block(MoreCrittersModBlocks.GHOSTLY_FENCE_GATE);
    public static final DeferredHolder<Item, Item> GHOSTLY_DOOR = doubleBlock(MoreCrittersModBlocks.GHOSTLY_DOOR);
    public static final DeferredHolder<Item, Item> GHOSTLY_TRAPDOOR = block(MoreCrittersModBlocks.GHOSTLY_TRAPDOOR);
    public static final DeferredHolder<Item, Item> GHOSTLY_PRESSURE_PLATE = block(MoreCrittersModBlocks.GHOSTLY_PRESSURE_PLATE);
    public static final DeferredHolder<Item, Item> GHOSTLY_BUTTON = block(MoreCrittersModBlocks.GHOSTLY_BUTTON);
    public static final DeferredHolder<Item, Item> GHOSTLY_LOG = block(MoreCrittersModBlocks.GHOSTLY_LOG);
    public static final DeferredHolder<Item, Item> GHOSTLY_WOOD = block(MoreCrittersModBlocks.GHOSTLY_WOOD);
    public static final DeferredHolder<Item, Item> STRIPPED_GHOSTLY_LOG = block(MoreCrittersModBlocks.STRIPPED_GHOSTLY_LOG);
    public static final DeferredHolder<Item, Item> STRIPPED_GHOSTLY_WOOD = block(MoreCrittersModBlocks.STRIPPED_GHOSTLY_WOOD);
    public static final DeferredHolder<Item, Item> FISH_BONE_BLOCK = block(MoreCrittersModBlocks.FISH_BONE_BLOCK);
    public static final DeferredHolder<Item, Item> FISH_BONE_POLE = block(MoreCrittersModBlocks.FISH_BONE_POLE);
    public static final DeferredHolder<Item, Item> TATTERED_JOLLY_ROGER = REGISTRY.register(
        MoreCrittersModBlocks.TATTERED_JOLLY_ROGER.getId().getPath(),
        () -> new TatteredJollyRogerDisplayItem(MoreCrittersModBlocks.TATTERED_JOLLY_ROGER.get(), new Properties())
    );
    public static final DeferredHolder<Item, Item> SHIP_WHEEL = REGISTRY.register(
        MoreCrittersModBlocks.SHIP_WHEEL.getId().getPath(), () -> new ShipWheelDisplayItem(MoreCrittersModBlocks.SHIP_WHEEL.get(), new Properties())
    );
    public static final DeferredHolder<Item, Item> FISH_BONE = REGISTRY.register("fish_bone", () -> new FishBoneItem());
    public static final DeferredHolder<Item, Item> SHARK_TOOTH = REGISTRY.register("shark_tooth", () -> new SharkToothItem());
    public static final DeferredHolder<Item, Item> TATTERED_CLOTH = REGISTRY.register("tattered_cloth", () -> new TatteredClothItem());
    public static final DeferredHolder<Item, Item> CANNON_BALL = REGISTRY.register("cannon_ball", () -> new CannonBallItem());
    public static final DeferredHolder<Item, Item> PEARL = REGISTRY.register("pearl", () -> new PearlItem());
    public static final DeferredHolder<Item, Item> CANNON = block(MoreCrittersModBlocks.CANNON);
    public static final DeferredHolder<Item, Item> INFUSED_CANNON_BALL_COLD = REGISTRY.register("infused_cannon_ball_cold", () -> new InfusedCannonBallColdItem());
    public static final DeferredHolder<Item, Item> INFUSED_CANNON_BALL_FIRE = REGISTRY.register("infused_cannon_ball_fire", () -> new InfusedCannonBallFireItem());
    public static final DeferredHolder<Item, Item> INFUSED_CANNON_BALL_SLIME = REGISTRY.register("infused_cannon_ball_slime", () -> new InfusedCannonBallSlimeItem());
    public static final DeferredHolder<Item, Item> TREASURE_CHEST = block(MoreCrittersModBlocks.TREASURE_CHEST);
    public static final DeferredHolder<Item, Item> TREASURE_KEY = REGISTRY.register("treasure_key", () -> new TreasureKeyItem());
    public static final DeferredHolder<Item, Item> TREASURE_CHEST_OPENING = block(MoreCrittersModBlocks.TREASURE_CHEST_OPENING);
    public static final DeferredHolder<Item, Item> TREASURE_CHEST_OPEN = block(MoreCrittersModBlocks.TREASURE_CHEST_OPEN);
    public static final DeferredHolder<Item, Item> PIRATE_HELMET = REGISTRY.register("pirate_helmet", () -> new PirateItem.Helmet());
    public static final DeferredHolder<Item, Item> PIRATE_CHESTPLATE = REGISTRY.register("pirate_chestplate", () -> new PirateItem.Chestplate());
    public static final DeferredHolder<Item, Item> PIRATE_LEGGINGS = REGISTRY.register("pirate_leggings", () -> new PirateItem.Leggings());
    public static final DeferredHolder<Item, Item> PIRATE_BOOTS = REGISTRY.register("pirate_boots", () -> new PirateItem.Boots());
    public static final DeferredHolder<Item, Item> HEALING_RUM = REGISTRY.register("healing_rum", () -> new HealingRumItem());
    public static final DeferredHolder<Item, Item> CUTLASS = REGISTRY.register("cutlass", () -> new CutlassItem());
    public static final DeferredHolder<Item, Item> TOOTH_SYRINGE = REGISTRY.register("tooth_syringe", () -> new ToothSyringeItem());
    public static final DeferredHolder<Item, Item> HARDTACK = REGISTRY.register("hardtack", () -> new HardtackItem());
    public static final DeferredHolder<Item, Item> INFESTED_HARDTACK = REGISTRY.register("infested_hardtack", () -> new InfestedHardtackItem());
    public static final DeferredHolder<Item, Item> HARDTACK_PIECE = REGISTRY.register("hardtack_piece", () -> new HardtackPieceItem());
    public static final DeferredHolder<Item, Item> SOUL_RUM = REGISTRY.register("soul_rum", () -> new SoulRumItem());
    public static final DeferredHolder<Item, Item> CAPTAINS_HEART = REGISTRY.register("captains_heart", () -> new CaptainsHeartItem());
    public static final DeferredHolder<Item, Item> CORPSE_PARROT_ITEM = REGISTRY.register("corpse_parrot_item", () -> new CorpseParrotItemItem());
    public static final DeferredHolder<Item, Item> CORPSE_CREW_SPAWN_EGG = REGISTRY.register(
        "corpse_crew_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.CORPSE_CREW, -13496306, -14340289, new Properties())
    );
    public static final DeferredHolder<Item, Item> CORPSE_MATE_SPAWN_DOLL = REGISTRY.register("corpse_mate_spawn_doll", () -> new CorpseMateSpawnDollItem());
    public static final DeferredHolder<Item, Item> CORPSE_QUARTERMASTER_SPAWN_DOLL = REGISTRY.register(
        "corpse_quartermaster_spawn_doll", () -> new CorpseQuartermasterSpawnDollItem()
    );
    public static final DeferredHolder<Item, Item> CORPSE_TANK_SPAWN_DOLL = REGISTRY.register("corpse_tank_spawn_doll", () -> new CorpseTankSpawnDollItem());
    public static final DeferredHolder<Item, Item> CORPSE_CAPTAIN_SPAWN_DOLL = REGISTRY.register("corpse_captain_spawn_doll", () -> new CorpseCaptainSpawnDollItem());
    public static final DeferredHolder<Item, Item> CORPSE_PARROT_SPAWN_DOLL = REGISTRY.register("corpse_parrot_spawn_doll", () -> new CorpseParrotSpawnDollItem());
    public static final DeferredHolder<Item, Item> ZOMBIE_NAUTICRAWL_SPAWN_DOLL = REGISTRY.register(
        "zombie_nauticrawl_spawn_doll", () -> new ZombieNauticrawlSpawnDollItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_MOTHKID = REGISTRY.register("critterling_sack_mothkid", () -> new CritterlingSackMothkidItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_GILLMUNCH = REGISTRY.register(
        "critterling_sack_gillmunch", () -> new CritterlingSackGillmunchItem()
    );
    public static final DeferredHolder<Item, Item> ICON_12 = REGISTRY.register("icon_12", () -> new Icon12Item());
    public static final DeferredHolder<Item, Item> ICON_13 = REGISTRY.register("icon_13", () -> new Icon13Item());
    public static final DeferredHolder<Item, Item> MUSIC_DISC_GROOVEYARD = REGISTRY.register("music_disc_grooveyard", () -> new MusicDiscGrooveyardItem());
    public static final DeferredHolder<Item, Item> ZOMBIE_NAUTICRAWL_SHELL = block(MoreCrittersModBlocks.ZOMBIE_NAUTICRAWL_SHELL);
    public static final DeferredHolder<Item, Item> SPRINKLES = REGISTRY.register("sprinkles", () -> new SprinklesItem());
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST = REGISTRY.register("bunbug_crust", () -> new BunbugCrustItem());
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_SUGAR = REGISTRY.register("bunbug_crust_iced_sugar", () -> new BunbugCrustIcedSugarItem());
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_CHOCOLATE = REGISTRY.register(
        "bunbug_crust_iced_chocolate", () -> new BunbugCrustIcedChocolateItem()
    );
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_SUGAR_SPRINKLED = REGISTRY.register(
        "bunbug_crust_iced_sugar_sprinkled", () -> new BunbugCrustIcedSugarSprinkledItem()
    );
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_CHOCOLATE_SPRINKLED = REGISTRY.register(
        "bunbug_crust_iced_chocolate_sprinkled", () -> new BunbugCrustIcedChocolateSprinkledItem()
    );
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_SUGAR_SPRINKLED_SWEET_BERRIES = REGISTRY.register(
        "bunbug_crust_iced_sugar_sprinkled_sweet_berries", () -> new BunbugCrustIcedSugarSprinkledSweetBerriesItem()
    );
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_SUGAR_SPRINKLED_GLOW_BERRIES = REGISTRY.register(
        "bunbug_crust_iced_sugar_sprinkled_glow_berries", () -> new BunbugCrustIcedSugarSprinkledGlowBerriesItem()
    );
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_SUGAR_SPRINKLED_BOUNCEBERRIES = REGISTRY.register(
        "bunbug_crust_iced_sugar_sprinkled_bounceberries", () -> new BunbugCrustIcedSugarSprinkledBounceberriesItem()
    );
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_CHOCOLATE_SPRINKLED_SWEET_BERRIES = REGISTRY.register(
        "bunbug_crust_iced_chocolate_sprinkled_sweet_berries", () -> new BunbugCrustIcedChocolateSprinkledSweetBerriesItem()
    );
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_CHOCOLATE_SPRINKLED_GLOW_BERRIES = REGISTRY.register(
        "bunbug_crust_iced_chocolate_sprinkled_glow_berries", () -> new BunbugCrustIcedChocolateSprinkledGlowBerriesItem()
    );
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_ICED_CHOCOLATE_SPRINKLED_BOUNCEBERRIES = REGISTRY.register(
        "bunbug_crust_iced_chocolate_sprinkled_bounceberries", () -> new BunbugCrustIcedChocolateSprinkledBounceberriesItem()
    );
    public static final DeferredHolder<Item, Item> ROT_ZOMBIE_SPAWN_DOLL = REGISTRY.register("rot_zombie_spawn_doll", () -> new RotZombieSpawnDollItem());
    public static final DeferredHolder<Item, Item> BOUNCEBERRY_BUSH = block(MoreCrittersModBlocks.BOUNCEBERRY_BUSH);
    public static final DeferredHolder<Item, Item> BOUNCEBERRY_BUSH_EMPTY = block(MoreCrittersModBlocks.BOUNCEBERRY_BUSH_EMPTY);
    public static final DeferredHolder<Item, Item> TAZEGUN = REGISTRY.register("tazegun", () -> new TazegunItem());
    public static final DeferredHolder<Item, Item> ICON_14 = REGISTRY.register("icon_14", () -> new Icon14Item());
    public static final DeferredHolder<Item, Item> GRAVEDIGGER_SPAWN_EGG = REGISTRY.register(
        "gravedigger_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.GRAVEDIGGER, -13812945, -4171645, new Properties())
    );
    public static final DeferredHolder<Item, Item> GRAVEDIGGER_APPENDAGE = REGISTRY.register("gravedigger_appendage", () -> new GravediggerAppendageItem());
    public static final DeferredHolder<Item, Item> GRAVE_BRUSH = REGISTRY.register("grave_brush", () -> new GraveBrushItem());
    public static final DeferredHolder<Item, Item> AMALGAM_SPAWN_DOLL = REGISTRY.register("amalgam_spawn_doll", () -> new AmalgamSpawnDollItem());
    public static final DeferredHolder<Item, Item> ARMOSSILLO_SPAWN_EGG = REGISTRY.register(
        "armossillo_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.ARMOSSILLO, -9399763, -3967941, new Properties())
    );
    public static final DeferredHolder<Item, Item> MOSS_CLUMP = block(MoreCrittersModBlocks.MOSS_CLUMP);
    public static final DeferredHolder<Item, Item> GLOWING_OOZE = REGISTRY.register("glowing_ooze", () -> new GlowingOozeItem());
    public static final DeferredHolder<Item, Item> GLOWING_OOZE_BLOCK = block(MoreCrittersModBlocks.GLOWING_OOZE_BLOCK);
    public static final DeferredHolder<Item, Item> CUT_GLOWING_OOZE_BLOCK = block(MoreCrittersModBlocks.CUT_GLOWING_OOZE_BLOCK);
    public static final DeferredHolder<Item, Item> GLOW = block(MoreCrittersModBlocks.GLOW);
    public static final DeferredHolder<Item, Item> OOZE_ROD = REGISTRY.register("ooze_rod", () -> new OozeRodItem());
    public static final DeferredHolder<Item, Item> RAMCHU_SPAWN_EGG = REGISTRY.register(
        "ramchu_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.RAMCHU, -2305867, -12500671, new Properties())
    );
    public static final DeferredHolder<Item, Item> RAMCHU_OIL_BOTTLE = REGISTRY.register("ramchu_oil_bottle", () -> new RamchuOilBottleItem());
    public static final DeferredHolder<Item, Item> RAMCHU_FRY_BUCKET_BUCKET = REGISTRY.register("ramchu_fry_bucket_bucket", () -> new RamchuFryBucketItem());
    public static final DeferredHolder<Item, Item> RAMCHU_BUCKET_BUCKET = REGISTRY.register("ramchu_bucket_bucket", () -> new RamchuBucketItem());
    public static final DeferredHolder<Item, Item> RAMCHU_BUCKET_NO_SHELL_BUCKET = REGISTRY.register(
        "ramchu_bucket_no_shell_bucket", () -> new RamchuBucketNoShellItem()
    );
    public static final DeferredHolder<Item, Item> RAMCHU_BUCKET_NO_OIL_BUCKET = REGISTRY.register("ramchu_bucket_no_oil_bucket", () -> new RamchuBucketNoOilItem());
    public static final DeferredHolder<Item, Item> DRIPPER_SPAWN_EGG = REGISTRY.register(
        "dripper_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.DRIPPER, -7177883, -15396848, new Properties())
    );
    public static final DeferredHolder<Item, Item> DRIPPER_REMAINS = REGISTRY.register("dripper_remains", () -> new DripperRemainsItem());
    public static final DeferredHolder<Item, Item> SLASHKLUB = REGISTRY.register("slashklub", () -> new SlashklubItem());
    public static final DeferredHolder<Item, Item> DRIPSTONE_WALL_MASK = block(MoreCrittersModBlocks.DRIPSTONE_WALL_MASK);
    public static final DeferredHolder<Item, Item> CUSTODIAN_SPAWN_EGG = REGISTRY.register(
        "custodian_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.CUSTODIAN, -12500671, -14032917, new Properties())
    );
    public static final DeferredHolder<Item, Item> CUSTODIAN_CORE = block(MoreCrittersModBlocks.CUSTODIAN_CORE);
    public static final DeferredHolder<Item, Item> SCULK_ESSENCE = REGISTRY.register("sculk_essence", () -> new SculkEssenceItem());
    public static final DeferredHolder<Item, Item> ANCIENT_CUSTODIAN_SPAWN_DOLL = REGISTRY.register(
        "ancient_custodian_spawn_doll", () -> new AncientCustodianSpawnDollItem()
    );
    public static final DeferredHolder<Item, Item> CRITTER_KEBAB = REGISTRY.register("critter_kebab", () -> new CritterKebabItem());
    public static final DeferredHolder<Item, Item> CRITTER_KEBAB_2 = REGISTRY.register("critter_kebab_2", () -> new CritterKebab2Item());
    public static final DeferredHolder<Item, Item> CRITTER_KEBAB_3 = REGISTRY.register("critter_kebab_3", () -> new CritterKebab3Item());
    public static final DeferredHolder<Item, Item> KELPIRE_ROLLS = block(MoreCrittersModBlocks.KELPIRE_ROLLS);
    public static final DeferredHolder<Item, Item> KELPIRE_ROLL_PIECE = REGISTRY.register("kelpire_roll_piece", () -> new KelpireRollPieceItem());
    public static final DeferredHolder<Item, Item> NAUTICRAWL_TENTACLE = REGISTRY.register("nauticrawl_tentacle", () -> new NauticrawlTentacleItem());
    public static final DeferredHolder<Item, Item> NAUTICRAWL_RAMEN = block(MoreCrittersModBlocks.NAUTICRAWL_RAMEN);
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_STALK = REGISTRY.register("critterling_sack_stalk", () -> new CritterlingSackStalkItem());
    public static final DeferredHolder<Item, Item> ICON_15 = REGISTRY.register("icon_15", () -> new Icon15Item());
    public static final DeferredHolder<Item, Item> ICON_16 = REGISTRY.register("icon_16", () -> new Icon16Item());
    public static final DeferredHolder<Item, Item> MUSIC_DISC_WADDLE = REGISTRY.register("music_disc_waddle", () -> new MusicDiscWaddleItem());
    public static final DeferredHolder<Item, Item> GIANT_CHAIN = block(MoreCrittersModBlocks.GIANT_CHAIN);
    public static final DeferredHolder<Item, Item> BARNACLE_CLUSTER = block(MoreCrittersModBlocks.BARNACLE_CLUSTER);
    public static final DeferredHolder<Item, Item> CORPSE_BARNACLE = block(MoreCrittersModBlocks.CORPSE_BARNACLE);
    public static final DeferredHolder<Item, Item> WET_GHOSTLY_PLANKS = block(MoreCrittersModBlocks.WET_GHOSTLY_PLANKS);
    public static final DeferredHolder<Item, Item> DRIED_KELP_CARPET = block(MoreCrittersModBlocks.DRIED_KELP_CARPET);
    public static final DeferredHolder<Item, Item> GHOSTLY_MOSAIC_PLANKS = block(MoreCrittersModBlocks.GHOSTLY_MOSAIC_PLANKS);
    public static final DeferredHolder<Item, Item> TATTERED_FLAG = block(MoreCrittersModBlocks.TATTERED_FLAG);
    public static final DeferredHolder<Item, Item> ECTOMETAL = REGISTRY.register("ectometal", () -> new EctometalItem());
    public static final DeferredHolder<Item, Item> ECTOMETAL_BLOCK = block(MoreCrittersModBlocks.ECTOMETAL_BLOCK);
    public static final DeferredHolder<Item, Item> ECTOMETAL_NAIL = block(MoreCrittersModBlocks.ECTOMETAL_NAIL);
    public static final DeferredHolder<Item, Item> ECTOMETAL_SCREW = block(MoreCrittersModBlocks.ECTOMETAL_SCREW);
    public static final DeferredHolder<Item, Item> ECTOMETAL_RAILING = block(MoreCrittersModBlocks.ECTOMETAL_RAILING);
    public static final DeferredHolder<Item, Item> PETRIFIED_GHOSTLY_PLANKS = block(MoreCrittersModBlocks.PETRIFIED_GHOSTLY_PLANKS);
    public static final DeferredHolder<Item, Item> PETRIFIED_GHOSTLY_STAIRS = block(MoreCrittersModBlocks.PETRIFIED_GHOSTLY_STAIRS);
    public static final DeferredHolder<Item, Item> PETRIFIED_GHOSTLY_SLAB = block(MoreCrittersModBlocks.PETRIFIED_GHOSTLY_SLAB);
    public static final DeferredHolder<Item, Item> PETRIFIED_GHOSTLY_MOSAIC_PLANKS = block(MoreCrittersModBlocks.PETRIFIED_GHOSTLY_MOSAIC_PLANKS);
    public static final DeferredHolder<Item, Item> WET_GHOSTLY_MOSAIC_PLANKS = block(MoreCrittersModBlocks.WET_GHOSTLY_MOSAIC_PLANKS);
    public static final DeferredHolder<Item, Item> KELPY_GHOSTLY_PLANKS = block(MoreCrittersModBlocks.KELPY_GHOSTLY_PLANKS);
    public static final DeferredHolder<Item, Item> WET_KELPY_GHOSTLY_PLANKS = block(MoreCrittersModBlocks.WET_KELPY_GHOSTLY_PLANKS);
    public static final DeferredHolder<Item, Item> KELPY_PETRIFIED_GHOSTLY_PLANKS = block(MoreCrittersModBlocks.KELPY_PETRIFIED_GHOSTLY_PLANKS);
    public static final DeferredHolder<Item, Item> INFUSED_CANNON_BALL_ELECTRIC = REGISTRY.register(
        "infused_cannon_ball_electric", () -> new InfusedCannonBallElectricItem()
    );
    public static final DeferredHolder<Item, Item> INFUSED_CANNON_BALL_COMBUSTING = REGISTRY.register(
        "infused_cannon_ball_combusting", () -> new InfusedCannonBallCombustingItem()
    );
    public static final DeferredHolder<Item, Item> PEBBLE_ICON = REGISTRY.register("pebble_icon", () -> new PebbleIconItem());
    public static final DeferredHolder<Item, Item> CHATTERING_TEETH_ITEM = REGISTRY.register("chattering_teeth_item", () -> new ChatteringTeethItemItem());
    public static final DeferredHolder<Item, Item> BLUBBER = block(MoreCrittersModBlocks.BLUBBER);
    public static final DeferredHolder<Item, Item> CORPSE_LOOKOUT_SPAWN_DOLL = REGISTRY.register("corpse_lookout_spawn_doll", () -> new CorpseLookoutSpawnDollItem());
    public static final DeferredHolder<Item, Item> ICON_17 = REGISTRY.register("icon_17", () -> new Icon17Item());
    public static final DeferredHolder<Item, Item> EVOLITE = REGISTRY.register("evolite", () -> new EvoliteItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_CUBEFROG_RARE = REGISTRY.register(
        "critterling_sack_cubefrog_rare", () -> new CritterlingSackCubefrogRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_CUBEFROG_EPIC = REGISTRY.register(
        "critterling_sack_cubefrog_epic", () -> new CritterlingSackCubefrogEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_PLAINSWYRM_RARE = REGISTRY.register(
        "critterling_sack_plainswyrm_rare", () -> new CritterlingSackPlainswyrmRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_PLAINSWYRM_EPIC = REGISTRY.register(
        "critterling_sack_plainswyrm_epic", () -> new CritterlingSackPlainswyrmEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_DUNGER_RARE = REGISTRY.register(
        "critterling_sack_dunger_rare", () -> new CritterlingSackDungerRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_DUNGER_EPIC = REGISTRY.register(
        "critterling_sack_dunger_epic", () -> new CritterlingSackDungerEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_SNEK_RARE = REGISTRY.register(
        "critterling_sack_snek_rare", () -> new CritterlingSackSnekRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_SNEK_EPIC = REGISTRY.register(
        "critterling_sack_snek_epic", () -> new CritterlingSackSnekEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_EXPY_RARE = REGISTRY.register(
        "critterling_sack_expy_rare", () -> new CritterlingSackExpyRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_EXPY_EPIC = REGISTRY.register(
        "critterling_sack_expy_epic", () -> new CritterlingSackExpyEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_SCOWL_RARE = REGISTRY.register(
        "critterling_sack_scowl_rare", () -> new CritterlingSackScowlRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_SCOWL_EPIC = REGISTRY.register(
        "critterling_sack_scowl_epic", () -> new CritterlingSackScowlEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_ROLLBALL_RARE = REGISTRY.register(
        "critterling_sack_rollball_rare", () -> new CritterlingSackRollballRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_ROLLBALL_EPIC = REGISTRY.register(
        "critterling_sack_rollball_epic", () -> new CritterlingSackRollballEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_OPALCRAB_RARE = REGISTRY.register(
        "critterling_sack_opalcrab_rare", () -> new CritterlingSackOpalcrabRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_OPALCRAB_EPIC = REGISTRY.register(
        "critterling_sack_opalcrab_epic", () -> new CritterlingSackOpalcrabEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_MOTHKID_RARE = REGISTRY.register(
        "critterling_sack_mothkid_rare", () -> new CritterlingSackMothkidRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_MOTHKID_EPIC = REGISTRY.register(
        "critterling_sack_mothkid_epic", () -> new CritterlingSackMothkidEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_GILLMUNCH_RARE = REGISTRY.register(
        "critterling_sack_gillmunch_rare", () -> new CritterlingSackGillmunchRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_GILLMUNCH_EPIC = REGISTRY.register(
        "critterling_sack_gillmunch_epic", () -> new CritterlingSackGillmunchEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_STALK_RARE = REGISTRY.register(
        "critterling_sack_stalk_rare", () -> new CritterlingSackStalkRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_STALK_EPIC = REGISTRY.register(
        "critterling_sack_stalk_epic", () -> new CritterlingSackStalkEpicItem()
    );
    public static final DeferredHolder<Item, Item> EVOLUTION_TABLE = block(MoreCrittersModBlocks.EVOLUTION_TABLE);
    public static final DeferredHolder<Item, Item> CLOSED_CRITTERLING_SACK = REGISTRY.register("closed_critterling_sack", () -> new ClosedCritterlingSackItem());
    public static final DeferredHolder<Item, Item> EVOLITE_CHANDELIER = block(MoreCrittersModBlocks.EVOLITE_CHANDELIER);
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_DOMINIC = REGISTRY.register("critterling_sack_dominic", () -> new CritterlingSackDominicItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_DOMINIC_RARE = REGISTRY.register(
        "critterling_sack_dominic_rare", () -> new CritterlingSackDominicRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_DOMINIC_EPIC = REGISTRY.register(
        "critterling_sack_dominic_epic", () -> new CritterlingSackDominicEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_OLMER = REGISTRY.register("critterling_sack_olmer", () -> new CritterlingSackOlmerItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_OLMER_RARE = REGISTRY.register(
        "critterling_sack_olmer_rare", () -> new CritterlingSackOlmerRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_OLMER_EPIC = REGISTRY.register(
        "critterling_sack_olmer_epic", () -> new CritterlingSackOlmerEpicItem()
    );
    public static final DeferredHolder<Item, Item> EVOLUTIONER_SPAWN_EGG = REGISTRY.register(
        "evolutioner_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.EVOLUTIONER, -15067107, -11719842, new Properties())
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_FLARG = REGISTRY.register("critterling_sack_flarg", () -> new CritterlingSackFlargItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_FLARG_RARE = REGISTRY.register(
        "critterling_sack_flarg_rare", () -> new CritterlingSackFlargRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_FLARG_EPIC = REGISTRY.register(
        "critterling_sack_flarg_epic", () -> new CritterlingSackFlargEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_PIRANHEED = REGISTRY.register(
        "critterling_sack_piranheed", () -> new CritterlingSackPiranheedItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_PIRANHEED_RARE = REGISTRY.register(
        "critterling_sack_piranheed_rare", () -> new CritterlingSackPiranheedRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_PIRANHEED_EPIC = REGISTRY.register(
        "critterling_sack_piranheed_epic", () -> new CritterlingSackPiranheedEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_MANGOTRICE = REGISTRY.register(
        "critterling_sack_mangotrice", () -> new CritterlingSackMangotriceItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_MANGOTRICE_RARE = REGISTRY.register(
        "critterling_sack_mangotrice_rare", () -> new CritterlingSackMangotriceRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_MANGOTRICE_EPIC = REGISTRY.register(
        "critterling_sack_mangotrice_epic", () -> new CritterlingSackMangotriceEpicItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_FRESNOID = REGISTRY.register("critterling_sack_fresnoid", () -> new CritterlingSackFresnoidItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_FRESNOID_RARE = REGISTRY.register(
        "critterling_sack_fresnoid_rare", () -> new CritterlingSackFresnoidRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_FRESNOID_EPIC = REGISTRY.register(
        "critterling_sack_fresnoid_epic", () -> new CritterlingSackFresnoidEpicItem()
    );
    public static final DeferredHolder<Item, Item> ICON_18 = REGISTRY.register("icon_18", () -> new Icon18Item());
    public static final DeferredHolder<Item, Item> ICON_19 = REGISTRY.register("icon_19", () -> new Icon19Item());
    public static final DeferredHolder<Item, Item> ICON_20 = REGISTRY.register("icon_20", () -> new Icon20Item());
    public static final DeferredHolder<Item, Item> RUM_BOTTLE = block(MoreCrittersModBlocks.RUM_BOTTLE);
    public static final DeferredHolder<Item, Item> IROBALL_ITEM = REGISTRY.register("iroball_item", () -> new IroballItemItem());
    public static final DeferredHolder<Item, Item> GOOBULB = block(MoreCrittersModBlocks.GOOBULB);
    public static final DeferredHolder<Item, Item> MUSIC_DISC_PARTY = REGISTRY.register("music_disc_party", () -> new MusicDiscPartyItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_CRITTER_EATER = REGISTRY.register(
        "critterling_sack_critter_eater", () -> new CritterlingSackCritterEaterItem()
    );
    public static final DeferredHolder<Item, Item> END_DUST_BUNNY = REGISTRY.register("end_dust_bunny", () -> new EndDustBunnyItem());
    public static final DeferredHolder<Item, Item> PARTY_HAT_HELMET = REGISTRY.register("party_hat_helmet", () -> new PartyHatItem.Helmet());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_COBBLE = REGISTRY.register("critterling_sack_cobble", () -> new CritterlingSackCobbleItem());
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_COBBLE_RARE = REGISTRY.register(
        "critterling_sack_cobble_rare", () -> new CritterlingSackCobbleRareItem()
    );
    public static final DeferredHolder<Item, Item> CRITTERLING_SACK_COBBLE_EPIC = REGISTRY.register(
        "critterling_sack_cobble_epic", () -> new CritterlingSackCobbleEpicItem()
    );
    public static final DeferredHolder<Item, Item> EVOLITE_BLOCK = block(MoreCrittersModBlocks.EVOLITE_BLOCK);
    public static final DeferredHolder<Item, Item> CONFETTI_TRAIL = block(MoreCrittersModBlocks.CONFETTI_TRAIL);
    public static final DeferredHolder<Item, Item> CONFETTI_POPPER = REGISTRY.register(
        MoreCrittersModBlocks.CONFETTI_POPPER.getId().getPath(),
        () -> new ConfettiPopperDisplayItem(MoreCrittersModBlocks.CONFETTI_POPPER.get(), new Properties())
    );
    public static final DeferredHolder<Item, Item> SPIKED_IROBALL = REGISTRY.register("spiked_iroball", () -> new SpikedIroballItem());
    public static final DeferredHolder<Item, Item> TROPHY = block(MoreCrittersModBlocks.TROPHY);
    public static final DeferredHolder<Item, Item> BUNBUG_CRUST_STRAWBERRY_SPRINKLED_CANDLE = REGISTRY.register(
        "bunbug_crust_strawberry_sprinkled_candle", () -> new BunbugCrustStrawberrySprinkledCandleItem()
    );
    public static final DeferredHolder<Item, Item> BIRCH_SNOW_CONE = REGISTRY.register("birch_snow_cone", () -> new BirchSnowConeItem());
    public static final DeferredHolder<Item, Item> BIRCH_SNOW_CONE_1 = REGISTRY.register("birch_snow_cone_1", () -> new BirchSnowCone1Item());
    public static final DeferredHolder<Item, Item> BIRCH_SNOW_CONE_2 = REGISTRY.register("birch_snow_cone_2", () -> new BirchSnowCone2Item());
    public static final DeferredHolder<Item, Item> BIRCH_SNOW_CONE_3 = REGISTRY.register("birch_snow_cone_3", () -> new BirchSnowCone3Item());
    public static final DeferredHolder<Item, Item> ANNIVETERAN_SPAWN_EGG = REGISTRY.register(
        "anniveteran_spawn_egg", () -> new DeferredSpawnEggItem(MoreCrittersModEntities.ANNIVETERAN, -1, -1, new Properties())
    );
    public static final DeferredHolder<Item, Item> GRAVEDIGGER_JAR = REGISTRY.register(
        MoreCrittersModBlocks.GRAVEDIGGER_JAR.getId().getPath(),
        () -> new GravediggerJarDisplayItem(MoreCrittersModBlocks.GRAVEDIGGER_JAR.get(), new Properties())
    );
    public static final DeferredHolder<Item, Item> THICK_ECTOMETAL_SCREW = block(MoreCrittersModBlocks.THICK_ECTOMETAL_SCREW);
    public static final DeferredHolder<Item, Item> MIGHTSHROOM_RIBS = REGISTRY.register("mightshroom_ribs", () -> new MightshroomRibsItem());

    private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Properties()));
    }

    private static DeferredHolder<Item, Item> doubleBlock(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Properties()));
    }

    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        event.enqueueWork(
            () -> ItemProperties.register(
                BITING_SHIELD.get(), ResourceLocation.parse("blocking"), ItemProperties.getProperty(new ItemStack(Items.SHIELD), ResourceLocation.parse("blocking"))
            )
        );
    }
}
