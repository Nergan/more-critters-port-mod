package com.morecritters.mod.init;

import net.minecraft.core.registries.Registries;
import com.morecritters.mod.block.AvoiderBucketBlock;
import com.morecritters.mod.block.AvoiderFryBucketBlock;
import com.morecritters.mod.block.BarnacleClusterBlock;
import com.morecritters.mod.block.BlackIropodBucketBlock;
import com.morecritters.mod.block.BlackResinBlockBlock;
import com.morecritters.mod.block.BlackResinBrickSlabBlock;
import com.morecritters.mod.block.BlackResinBrickStairsBlock;
import com.morecritters.mod.block.BlackResinBrickWallBlock;
import com.morecritters.mod.block.BlackResinBricksBlock;
import com.morecritters.mod.block.BlossombushBlock;
import com.morecritters.mod.block.BlubberBlock;
import com.morecritters.mod.block.BlubberfishBucketBlock;
import com.morecritters.mod.block.BlubberfishFryBucketBlock;
import com.morecritters.mod.block.BounceberryBushBlock;
import com.morecritters.mod.block.BounceberryBushEmptyBlock;
import com.morecritters.mod.block.BouncelizardEggBlock;
import com.morecritters.mod.block.CannonBlock;
import com.morecritters.mod.block.ChiseledBlackResinBricksBlock;
import com.morecritters.mod.block.ChiseledColdstoneBlock;
import com.morecritters.mod.block.ChiseledMushroomStemBirdBlock;
import com.morecritters.mod.block.ChiseledMushroomStemEyeBlock;
import com.morecritters.mod.block.ChiseledMushroomStemFireBlock;
import com.morecritters.mod.block.ChiseledMushroomStemMushroomBlock;
import com.morecritters.mod.block.ChiseledMushroomStemSpiralBlock;
import com.morecritters.mod.block.ChiseledMushroomStemThingBlock;
import com.morecritters.mod.block.ClosedBlossombushBlock;
import com.morecritters.mod.block.ClosedElectricBlossombushBlock;
import com.morecritters.mod.block.ColdstoneBlock;
import com.morecritters.mod.block.ColdstoneBrickSlabBlock;
import com.morecritters.mod.block.ColdstoneBrickStairsBlock;
import com.morecritters.mod.block.ColdstoneBrickWallBlock;
import com.morecritters.mod.block.ColdstoneBricksBlock;
import com.morecritters.mod.block.ColdstoneSlabBlock;
import com.morecritters.mod.block.ColdstoneStairsBlock;
import com.morecritters.mod.block.ColdstoneWallBlock;
import com.morecritters.mod.block.ConfettiPopperBlock;
import com.morecritters.mod.block.ConfettiTrailBlock;
import com.morecritters.mod.block.CorpseBarnacleBlock;
import com.morecritters.mod.block.CustodianCoreBlock;
import com.morecritters.mod.block.CutGlowingOozeBlockBlock;
import com.morecritters.mod.block.DecomposingNervoidBrainBlock;
import com.morecritters.mod.block.DeepslateFossilBlockBlock;
import com.morecritters.mod.block.DriedKelpCarpetBlock;
import com.morecritters.mod.block.DripstoneWallMaskBlock;
import com.morecritters.mod.block.EctometalBlockBlock;
import com.morecritters.mod.block.EctometalNailBlock;
import com.morecritters.mod.block.EctometalRailingBlock;
import com.morecritters.mod.block.EctometalScrewBlock;
import com.morecritters.mod.block.EerieBirchLogBlock;
import com.morecritters.mod.block.EerieBirchWoodBlock;
import com.morecritters.mod.block.ElectricBlossombushBlock;
import com.morecritters.mod.block.EvoliteBlockBlock;
import com.morecritters.mod.block.EvoliteChandelierBlock;
import com.morecritters.mod.block.EvolutionTableBlock;
import com.morecritters.mod.block.FishBoneBlockBlock;
import com.morecritters.mod.block.FishBonePoleBlock;
import com.morecritters.mod.block.FossilBlockBlock;
import com.morecritters.mod.block.FossilDisplay10Block;
import com.morecritters.mod.block.FossilDisplay11Block;
import com.morecritters.mod.block.FossilDisplay12Block;
import com.morecritters.mod.block.FossilDisplay13Block;
import com.morecritters.mod.block.FossilDisplay14Block;
import com.morecritters.mod.block.FossilDisplay15Block;
import com.morecritters.mod.block.FossilDisplay16Block;
import com.morecritters.mod.block.FossilDisplay17Block;
import com.morecritters.mod.block.FossilDisplay1Block;
import com.morecritters.mod.block.FossilDisplay2Block;
import com.morecritters.mod.block.FossilDisplay3Block;
import com.morecritters.mod.block.FossilDisplay4Block;
import com.morecritters.mod.block.FossilDisplay5Block;
import com.morecritters.mod.block.FossilDisplay6Block;
import com.morecritters.mod.block.FossilDisplay7Block;
import com.morecritters.mod.block.FossilDisplay8Block;
import com.morecritters.mod.block.FossilDisplay9Block;
import com.morecritters.mod.block.FossilDisplayBlock;
import com.morecritters.mod.block.FreezingCobwebBlock;
import com.morecritters.mod.block.GhostlyButtonBlock;
import com.morecritters.mod.block.GhostlyDoorBlock;
import com.morecritters.mod.block.GhostlyFenceBlock;
import com.morecritters.mod.block.GhostlyFenceGateBlock;
import com.morecritters.mod.block.GhostlyLogBlock;
import com.morecritters.mod.block.GhostlyMosaicPlanksBlock;
import com.morecritters.mod.block.GhostlyPlanksBlock;
import com.morecritters.mod.block.GhostlyPressurePlateBlock;
import com.morecritters.mod.block.GhostlySlabBlock;
import com.morecritters.mod.block.GhostlyStairsBlock;
import com.morecritters.mod.block.GhostlyTrapdoorBlock;
import com.morecritters.mod.block.GhostlyWoodBlock;
import com.morecritters.mod.block.GiantChainBlock;
import com.morecritters.mod.block.GlowBlock;
import com.morecritters.mod.block.GlowingOozeBlockBlock;
import com.morecritters.mod.block.GoobulbBlock;
import com.morecritters.mod.block.GravediggerJarBlock;
import com.morecritters.mod.block.IcedDecomposingNervoidBrainBlock;
import com.morecritters.mod.block.IcedNervoidBrainBlock;
import com.morecritters.mod.block.IcedRottenNervoidBrainBlock;
import com.morecritters.mod.block.IropodBucketBlock;
import com.morecritters.mod.block.KelpireRollsBlock;
import com.morecritters.mod.block.KelpyGhostlyPlanksBlock;
import com.morecritters.mod.block.KelpyPetrifiedGhostlyPlanksBlock;
import com.morecritters.mod.block.LargeBombJellyBlock;
import com.morecritters.mod.block.MediumBombJellyBlock;
import com.morecritters.mod.block.MoriShroomBlock;
import com.morecritters.mod.block.MoriShroomBlockBlock;
import com.morecritters.mod.block.MossClumpBlock;
import com.morecritters.mod.block.NauticrawlRamenBlock;
import com.morecritters.mod.block.NauticrawlShellBlock;
import com.morecritters.mod.block.NervoidBrainBlock;
import com.morecritters.mod.block.PetrifiedGhostlyMosaicPlanksBlock;
import com.morecritters.mod.block.PetrifiedGhostlyPlanksBlock;
import com.morecritters.mod.block.PetrifiedGhostlySlabBlock;
import com.morecritters.mod.block.PetrifiedGhostlyStairsBlock;
import com.morecritters.mod.block.PolishedColdstoneBlock;
import com.morecritters.mod.block.PolishedColdstoneSlabBlock;
import com.morecritters.mod.block.PolishedColdstoneStairsBlock;
import com.morecritters.mod.block.PolishedColdstoneWallBlock;
import com.morecritters.mod.block.PotBlossombushBlock;
import com.morecritters.mod.block.PotElectricBlossombushBlock;
import com.morecritters.mod.block.PotMoriBlock;
import com.morecritters.mod.block.PotVitaBlock;
import com.morecritters.mod.block.RamchuBucketBlock;
import com.morecritters.mod.block.RamchuBucketNoOilBlock;
import com.morecritters.mod.block.RamchuBucketNoShellBlock;
import com.morecritters.mod.block.RamchuFryBucketBlock;
import com.morecritters.mod.block.RottenNervoidBrainBlock;
import com.morecritters.mod.block.RumBottleBlock;
import com.morecritters.mod.block.ShimmeringChrysalisBlock;
import com.morecritters.mod.block.ShipWheelBlock;
import com.morecritters.mod.block.SmallBombJellyBlock;
import com.morecritters.mod.block.StinarpBucketBlock;
import com.morecritters.mod.block.StrippedGhostlyLogBlock;
import com.morecritters.mod.block.StrippedGhostlyWoodBlock;
import com.morecritters.mod.block.SturdyShellBlockBlock;
import com.morecritters.mod.block.TatteredFlagBlock;
import com.morecritters.mod.block.TatteredJollyRogerBlock;
import com.morecritters.mod.block.ThickEctometalScrewBlock;
import com.morecritters.mod.block.TreasureChestBlock;
import com.morecritters.mod.block.TreasureChestOpenBlock;
import com.morecritters.mod.block.TreasureChestOpeningBlock;
import com.morecritters.mod.block.TrophyBlock;
import com.morecritters.mod.block.VitaShroomBlock;
import com.morecritters.mod.block.VitaShroomBlockBlock;
import com.morecritters.mod.block.WetGhostlyMosaicPlanksBlock;
import com.morecritters.mod.block.WetGhostlyPlanksBlock;
import com.morecritters.mod.block.WetKelpyGhostlyPlanksBlock;
import com.morecritters.mod.block.ZombieNauticrawlShellBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredHolder;

public class MoreCrittersModBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(Registries.BLOCK, "more_critters");
    public static final DeferredHolder<Block, Block> FREEZING_COBWEB = REGISTRY.register("freezing_cobweb", () -> new FreezingCobwebBlock());
    public static final DeferredHolder<Block, Block> COLDSTONE = REGISTRY.register("coldstone", () -> new ColdstoneBlock());
    public static final DeferredHolder<Block, Block> COLDSTONE_STAIRS = REGISTRY.register("coldstone_stairs", () -> new ColdstoneStairsBlock());
    public static final DeferredHolder<Block, Block> COLDSTONE_SLAB = REGISTRY.register("coldstone_slab", () -> new ColdstoneSlabBlock());
    public static final DeferredHolder<Block, Block> COLDSTONE_WALL = REGISTRY.register("coldstone_wall", () -> new ColdstoneWallBlock());
    public static final DeferredHolder<Block, Block> COLDSTONE_BRICKS = REGISTRY.register("coldstone_bricks", () -> new ColdstoneBricksBlock());
    public static final DeferredHolder<Block, Block> COLDSTONE_BRICK_STAIRS = REGISTRY.register("coldstone_brick_stairs", () -> new ColdstoneBrickStairsBlock());
    public static final DeferredHolder<Block, Block> COLDSTONE_BRICK_SLAB = REGISTRY.register("coldstone_brick_slab", () -> new ColdstoneBrickSlabBlock());
    public static final DeferredHolder<Block, Block> COLDSTONE_BRICK_WALL = REGISTRY.register("coldstone_brick_wall", () -> new ColdstoneBrickWallBlock());
    public static final DeferredHolder<Block, Block> CHISELED_COLDSTONE = REGISTRY.register("chiseled_coldstone", () -> new ChiseledColdstoneBlock());
    public static final DeferredHolder<Block, Block> POLISHED_COLDSTONE = REGISTRY.register("polished_coldstone", () -> new PolishedColdstoneBlock());
    public static final DeferredHolder<Block, Block> POLISHED_COLDSTONE_STAIRS = REGISTRY.register(
        "polished_coldstone_stairs", () -> new PolishedColdstoneStairsBlock()
    );
    public static final DeferredHolder<Block, Block> POLISHED_COLDSTONE_SLAB = REGISTRY.register("polished_coldstone_slab", () -> new PolishedColdstoneSlabBlock());
    public static final DeferredHolder<Block, Block> POLISHED_COLDSTONE_WALL = REGISTRY.register("polished_coldstone_wall", () -> new PolishedColdstoneWallBlock());
    public static final DeferredHolder<Block, Block> BLOSSOMBUSH = REGISTRY.register("blossombush", () -> new BlossombushBlock());
    public static final DeferredHolder<Block, Block> CLOSED_BLOSSOMBUSH = REGISTRY.register("closed_blossombush", () -> new ClosedBlossombushBlock());
    public static final DeferredHolder<Block, Block> BOUNCELIZARD_EGG = REGISTRY.register("bouncelizard_egg", () -> new BouncelizardEggBlock());
    public static final DeferredHolder<Block, Block> ELECTRIC_BLOSSOMBUSH = REGISTRY.register("electric_blossombush", () -> new ElectricBlossombushBlock());
    public static final DeferredHolder<Block, Block> CLOSED_ELECTRIC_BLOSSOMBUSH = REGISTRY.register(
        "closed_electric_blossombush", () -> new ClosedElectricBlossombushBlock()
    );
    public static final DeferredHolder<Block, Block> STURDY_SHELL_BLOCK = REGISTRY.register("sturdy_shell_block", () -> new SturdyShellBlockBlock());
    public static final DeferredHolder<Block, Block> SHIMMERING_CHRYSALIS = REGISTRY.register("shimmering_chrysalis", () -> new ShimmeringChrysalisBlock());
    public static final DeferredHolder<Block, Block> VITA_SHROOM = REGISTRY.register("vita_shroom", () -> new VitaShroomBlock());
    public static final DeferredHolder<Block, Block> MORI_SHROOM = REGISTRY.register("mori_shroom", () -> new MoriShroomBlock());
    public static final DeferredHolder<Block, Block> VITA_SHROOM_BLOCK = REGISTRY.register("vita_shroom_block", () -> new VitaShroomBlockBlock());
    public static final DeferredHolder<Block, Block> MORI_SHROOM_BLOCK = REGISTRY.register("mori_shroom_block", () -> new MoriShroomBlockBlock());
    public static final DeferredHolder<Block, Block> POT_BLOSSOMBUSH = REGISTRY.register("pot_blossombush", () -> new PotBlossombushBlock());
    public static final DeferredHolder<Block, Block> POT_ELECTRIC_BLOSSOMBUSH = REGISTRY.register("pot_electric_blossombush", () -> new PotElectricBlossombushBlock());
    public static final DeferredHolder<Block, Block> POT_VITA = REGISTRY.register("pot_vita", () -> new PotVitaBlock());
    public static final DeferredHolder<Block, Block> POT_MORI = REGISTRY.register("pot_mori", () -> new PotMoriBlock());
    public static final DeferredHolder<Block, Block> CHISELED_MUSHROOM_STEM_EYE = REGISTRY.register(
        "chiseled_mushroom_stem_eye", () -> new ChiseledMushroomStemEyeBlock()
    );
    public static final DeferredHolder<Block, Block> CHISELED_MUSHROOM_STEM_SPIRAL = REGISTRY.register(
        "chiseled_mushroom_stem_spiral", () -> new ChiseledMushroomStemSpiralBlock()
    );
    public static final DeferredHolder<Block, Block> CHISELED_MUSHROOM_STEM_BIRD = REGISTRY.register(
        "chiseled_mushroom_stem_bird", () -> new ChiseledMushroomStemBirdBlock()
    );
    public static final DeferredHolder<Block, Block> CHISELED_MUSHROOM_STEM_MUSHROOM = REGISTRY.register(
        "chiseled_mushroom_stem_mushroom", () -> new ChiseledMushroomStemMushroomBlock()
    );
    public static final DeferredHolder<Block, Block> CHISELED_MUSHROOM_STEM_FIRE = REGISTRY.register(
        "chiseled_mushroom_stem_fire", () -> new ChiseledMushroomStemFireBlock()
    );
    public static final DeferredHolder<Block, Block> CHISELED_MUSHROOM_STEM_THING = REGISTRY.register(
        "chiseled_mushroom_stem_thing", () -> new ChiseledMushroomStemThingBlock()
    );
    public static final DeferredHolder<Block, Block> FOSSIL_BLOCK = REGISTRY.register("fossil_block", () -> new FossilBlockBlock());
    public static final DeferredHolder<Block, Block> DEEPSLATE_FOSSIL_BLOCK = REGISTRY.register("deepslate_fossil_block", () -> new DeepslateFossilBlockBlock());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY = REGISTRY.register("fossil_display", () -> new FossilDisplayBlock());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_1 = REGISTRY.register("fossil_display_1", () -> new FossilDisplay1Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_2 = REGISTRY.register("fossil_display_2", () -> new FossilDisplay2Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_3 = REGISTRY.register("fossil_display_3", () -> new FossilDisplay3Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_4 = REGISTRY.register("fossil_display_4", () -> new FossilDisplay4Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_5 = REGISTRY.register("fossil_display_5", () -> new FossilDisplay5Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_6 = REGISTRY.register("fossil_display_6", () -> new FossilDisplay6Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_7 = REGISTRY.register("fossil_display_7", () -> new FossilDisplay7Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_8 = REGISTRY.register("fossil_display_8", () -> new FossilDisplay8Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_9 = REGISTRY.register("fossil_display_9", () -> new FossilDisplay9Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_10 = REGISTRY.register("fossil_display_10", () -> new FossilDisplay10Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_11 = REGISTRY.register("fossil_display_11", () -> new FossilDisplay11Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_12 = REGISTRY.register("fossil_display_12", () -> new FossilDisplay12Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_13 = REGISTRY.register("fossil_display_13", () -> new FossilDisplay13Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_14 = REGISTRY.register("fossil_display_14", () -> new FossilDisplay14Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_15 = REGISTRY.register("fossil_display_15", () -> new FossilDisplay15Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_16 = REGISTRY.register("fossil_display_16", () -> new FossilDisplay16Block());
    public static final DeferredHolder<Block, Block> FOSSIL_DISPLAY_17 = REGISTRY.register("fossil_display_17", () -> new FossilDisplay17Block());
    public static final DeferredHolder<Block, Block> SMALL_BOMB_JELLY = REGISTRY.register("small_bomb_jelly", () -> new SmallBombJellyBlock());
    public static final DeferredHolder<Block, Block> MEDIUM_BOMB_JELLY = REGISTRY.register("medium_bomb_jelly", () -> new MediumBombJellyBlock());
    public static final DeferredHolder<Block, Block> LARGE_BOMB_JELLY = REGISTRY.register("large_bomb_jelly", () -> new LargeBombJellyBlock());
    public static final DeferredHolder<Block, Block> AVOIDER_BUCKET = REGISTRY.register("avoider_bucket", () -> new AvoiderBucketBlock());
    public static final DeferredHolder<Block, Block> IROPOD_BUCKET = REGISTRY.register("iropod_bucket", () -> new IropodBucketBlock());
    public static final DeferredHolder<Block, Block> BLACK_IROPOD_BUCKET = REGISTRY.register("black_iropod_bucket", () -> new BlackIropodBucketBlock());
    public static final DeferredHolder<Block, Block> BLUBBERFISH_BUCKET = REGISTRY.register("blubberfish_bucket", () -> new BlubberfishBucketBlock());
    public static final DeferredHolder<Block, Block> NAUTICRAWL_SHELL = REGISTRY.register("nauticrawl_shell", () -> new NauticrawlShellBlock());
    public static final DeferredHolder<Block, Block> BLUBBERFISH_FRY_BUCKET = REGISTRY.register("blubberfish_fry_bucket", () -> new BlubberfishFryBucketBlock());
    public static final DeferredHolder<Block, Block> AVOIDER_FRY_BUCKET = REGISTRY.register("avoider_fry_bucket", () -> new AvoiderFryBucketBlock());
    public static final DeferredHolder<Block, Block> STINARP_BUCKET = REGISTRY.register("stinarp_bucket", () -> new StinarpBucketBlock());
    public static final DeferredHolder<Block, Block> EERIE_BIRCH_LOG = REGISTRY.register("eerie_birch_log", () -> new EerieBirchLogBlock());
    public static final DeferredHolder<Block, Block> EERIE_BIRCH_WOOD = REGISTRY.register("eerie_birch_wood", () -> new EerieBirchWoodBlock());
    public static final DeferredHolder<Block, Block> BLACK_RESIN_BLOCK = REGISTRY.register("black_resin_block", () -> new BlackResinBlockBlock());
    public static final DeferredHolder<Block, Block> BLACK_RESIN_BRICKS = REGISTRY.register("black_resin_bricks", () -> new BlackResinBricksBlock());
    public static final DeferredHolder<Block, Block> CHISELED_BLACK_RESIN_BRICKS = REGISTRY.register(
        "chiseled_black_resin_bricks", () -> new ChiseledBlackResinBricksBlock()
    );
    public static final DeferredHolder<Block, Block> BLACK_RESIN_BRICK_STAIRS = REGISTRY.register("black_resin_brick_stairs", () -> new BlackResinBrickStairsBlock());
    public static final DeferredHolder<Block, Block> BLACK_RESIN_BRICK_SLAB = REGISTRY.register("black_resin_brick_slab", () -> new BlackResinBrickSlabBlock());
    public static final DeferredHolder<Block, Block> BLACK_RESIN_BRICK_WALL = REGISTRY.register("black_resin_brick_wall", () -> new BlackResinBrickWallBlock());
    public static final DeferredHolder<Block, Block> NERVOID_BRAIN = REGISTRY.register("nervoid_brain", () -> new NervoidBrainBlock());
    public static final DeferredHolder<Block, Block> DECOMPOSING_NERVOID_BRAIN = REGISTRY.register(
        "decomposing_nervoid_brain", () -> new DecomposingNervoidBrainBlock()
    );
    public static final DeferredHolder<Block, Block> ROTTEN_NERVOID_BRAIN = REGISTRY.register("rotten_nervoid_brain", () -> new RottenNervoidBrainBlock());
    public static final DeferredHolder<Block, Block> ICED_NERVOID_BRAIN = REGISTRY.register("iced_nervoid_brain", () -> new IcedNervoidBrainBlock());
    public static final DeferredHolder<Block, Block> ICED_DECOMPOSING_NERVOID_BRAIN = REGISTRY.register(
        "iced_decomposing_nervoid_brain", () -> new IcedDecomposingNervoidBrainBlock()
    );
    public static final DeferredHolder<Block, Block> ICED_ROTTEN_NERVOID_BRAIN = REGISTRY.register(
        "iced_rotten_nervoid_brain", () -> new IcedRottenNervoidBrainBlock()
    );
    public static final DeferredHolder<Block, Block> GHOSTLY_PLANKS = REGISTRY.register("ghostly_planks", () -> new GhostlyPlanksBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_STAIRS = REGISTRY.register("ghostly_stairs", () -> new GhostlyStairsBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_SLAB = REGISTRY.register("ghostly_slab", () -> new GhostlySlabBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_FENCE = REGISTRY.register("ghostly_fence", () -> new GhostlyFenceBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_FENCE_GATE = REGISTRY.register("ghostly_fence_gate", () -> new GhostlyFenceGateBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_DOOR = REGISTRY.register("ghostly_door", () -> new GhostlyDoorBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_TRAPDOOR = REGISTRY.register("ghostly_trapdoor", () -> new GhostlyTrapdoorBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_PRESSURE_PLATE = REGISTRY.register("ghostly_pressure_plate", () -> new GhostlyPressurePlateBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_BUTTON = REGISTRY.register("ghostly_button", () -> new GhostlyButtonBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_LOG = REGISTRY.register("ghostly_log", () -> new GhostlyLogBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_WOOD = REGISTRY.register("ghostly_wood", () -> new GhostlyWoodBlock());
    public static final DeferredHolder<Block, Block> STRIPPED_GHOSTLY_LOG = REGISTRY.register("stripped_ghostly_log", () -> new StrippedGhostlyLogBlock());
    public static final DeferredHolder<Block, Block> STRIPPED_GHOSTLY_WOOD = REGISTRY.register("stripped_ghostly_wood", () -> new StrippedGhostlyWoodBlock());
    public static final DeferredHolder<Block, Block> FISH_BONE_BLOCK = REGISTRY.register("fish_bone_block", () -> new FishBoneBlockBlock());
    public static final DeferredHolder<Block, Block> FISH_BONE_POLE = REGISTRY.register("fish_bone_pole", () -> new FishBonePoleBlock());
    public static final DeferredHolder<Block, Block> TATTERED_JOLLY_ROGER = REGISTRY.register("tattered_jolly_roger", () -> new TatteredJollyRogerBlock());
    public static final DeferredHolder<Block, Block> SHIP_WHEEL = REGISTRY.register("ship_wheel", () -> new ShipWheelBlock());
    public static final DeferredHolder<Block, Block> CANNON = REGISTRY.register("cannon", () -> new CannonBlock());
    public static final DeferredHolder<Block, Block> TREASURE_CHEST = REGISTRY.register("treasure_chest", () -> new TreasureChestBlock());
    public static final DeferredHolder<Block, Block> TREASURE_CHEST_OPENING = REGISTRY.register("treasure_chest_opening", () -> new TreasureChestOpeningBlock());
    public static final DeferredHolder<Block, Block> TREASURE_CHEST_OPEN = REGISTRY.register("treasure_chest_open", () -> new TreasureChestOpenBlock());
    public static final DeferredHolder<Block, Block> ZOMBIE_NAUTICRAWL_SHELL = REGISTRY.register("zombie_nauticrawl_shell", () -> new ZombieNauticrawlShellBlock());
    public static final DeferredHolder<Block, Block> BOUNCEBERRY_BUSH = REGISTRY.register("bounceberry_bush", () -> new BounceberryBushBlock());
    public static final DeferredHolder<Block, Block> BOUNCEBERRY_BUSH_EMPTY = REGISTRY.register("bounceberry_bush_empty", () -> new BounceberryBushEmptyBlock());
    public static final DeferredHolder<Block, Block> MOSS_CLUMP = REGISTRY.register("moss_clump", () -> new MossClumpBlock());
    public static final DeferredHolder<Block, Block> GLOWING_OOZE_BLOCK = REGISTRY.register("glowing_ooze_block", () -> new GlowingOozeBlockBlock());
    public static final DeferredHolder<Block, Block> CUT_GLOWING_OOZE_BLOCK = REGISTRY.register("cut_glowing_ooze_block", () -> new CutGlowingOozeBlockBlock());
    public static final DeferredHolder<Block, Block> GLOW = REGISTRY.register("glow", () -> new GlowBlock());
    public static final DeferredHolder<Block, Block> RAMCHU_FRY_BUCKET = REGISTRY.register("ramchu_fry_bucket", () -> new RamchuFryBucketBlock());
    public static final DeferredHolder<Block, Block> RAMCHU_BUCKET = REGISTRY.register("ramchu_bucket", () -> new RamchuBucketBlock());
    public static final DeferredHolder<Block, Block> RAMCHU_BUCKET_NO_SHELL = REGISTRY.register("ramchu_bucket_no_shell", () -> new RamchuBucketNoShellBlock());
    public static final DeferredHolder<Block, Block> RAMCHU_BUCKET_NO_OIL = REGISTRY.register("ramchu_bucket_no_oil", () -> new RamchuBucketNoOilBlock());
    public static final DeferredHolder<Block, Block> DRIPSTONE_WALL_MASK = REGISTRY.register("dripstone_wall_mask", () -> new DripstoneWallMaskBlock());
    public static final DeferredHolder<Block, Block> CUSTODIAN_CORE = REGISTRY.register("custodian_core", () -> new CustodianCoreBlock());
    public static final DeferredHolder<Block, Block> KELPIRE_ROLLS = REGISTRY.register("kelpire_rolls", () -> new KelpireRollsBlock());
    public static final DeferredHolder<Block, Block> NAUTICRAWL_RAMEN = REGISTRY.register("nauticrawl_ramen", () -> new NauticrawlRamenBlock());
    public static final DeferredHolder<Block, Block> GIANT_CHAIN = REGISTRY.register("giant_chain", () -> new GiantChainBlock());
    public static final DeferredHolder<Block, Block> BARNACLE_CLUSTER = REGISTRY.register("barnacle_cluster", () -> new BarnacleClusterBlock());
    public static final DeferredHolder<Block, Block> CORPSE_BARNACLE = REGISTRY.register("corpse_barnacle", () -> new CorpseBarnacleBlock());
    public static final DeferredHolder<Block, Block> WET_GHOSTLY_PLANKS = REGISTRY.register("wet_ghostly_planks", () -> new WetGhostlyPlanksBlock());
    public static final DeferredHolder<Block, Block> DRIED_KELP_CARPET = REGISTRY.register("dried_kelp_carpet", () -> new DriedKelpCarpetBlock());
    public static final DeferredHolder<Block, Block> GHOSTLY_MOSAIC_PLANKS = REGISTRY.register("ghostly_mosaic_planks", () -> new GhostlyMosaicPlanksBlock());
    public static final DeferredHolder<Block, Block> TATTERED_FLAG = REGISTRY.register("tattered_flag", () -> new TatteredFlagBlock());
    public static final DeferredHolder<Block, Block> ECTOMETAL_BLOCK = REGISTRY.register("ectometal_block", () -> new EctometalBlockBlock());
    public static final DeferredHolder<Block, Block> ECTOMETAL_NAIL = REGISTRY.register("ectometal_nail", () -> new EctometalNailBlock());
    public static final DeferredHolder<Block, Block> ECTOMETAL_SCREW = REGISTRY.register("ectometal_screw", () -> new EctometalScrewBlock());
    public static final DeferredHolder<Block, Block> ECTOMETAL_RAILING = REGISTRY.register("ectometal_railing", () -> new EctometalRailingBlock());
    public static final DeferredHolder<Block, Block> PETRIFIED_GHOSTLY_PLANKS = REGISTRY.register("petrified_ghostly_planks", () -> new PetrifiedGhostlyPlanksBlock());
    public static final DeferredHolder<Block, Block> PETRIFIED_GHOSTLY_STAIRS = REGISTRY.register("petrified_ghostly_stairs", () -> new PetrifiedGhostlyStairsBlock());
    public static final DeferredHolder<Block, Block> PETRIFIED_GHOSTLY_SLAB = REGISTRY.register("petrified_ghostly_slab", () -> new PetrifiedGhostlySlabBlock());
    public static final DeferredHolder<Block, Block> PETRIFIED_GHOSTLY_MOSAIC_PLANKS = REGISTRY.register(
        "petrified_ghostly_mosaic_planks", () -> new PetrifiedGhostlyMosaicPlanksBlock()
    );
    public static final DeferredHolder<Block, Block> WET_GHOSTLY_MOSAIC_PLANKS = REGISTRY.register(
        "wet_ghostly_mosaic_planks", () -> new WetGhostlyMosaicPlanksBlock()
    );
    public static final DeferredHolder<Block, Block> KELPY_GHOSTLY_PLANKS = REGISTRY.register("kelpy_ghostly_planks", () -> new KelpyGhostlyPlanksBlock());
    public static final DeferredHolder<Block, Block> WET_KELPY_GHOSTLY_PLANKS = REGISTRY.register("wet_kelpy_ghostly_planks", () -> new WetKelpyGhostlyPlanksBlock());
    public static final DeferredHolder<Block, Block> KELPY_PETRIFIED_GHOSTLY_PLANKS = REGISTRY.register(
        "kelpy_petrified_ghostly_planks", () -> new KelpyPetrifiedGhostlyPlanksBlock()
    );
    public static final DeferredHolder<Block, Block> BLUBBER = REGISTRY.register("blubber", () -> new BlubberBlock());
    public static final DeferredHolder<Block, Block> EVOLUTION_TABLE = REGISTRY.register("evolution_table", () -> new EvolutionTableBlock());
    public static final DeferredHolder<Block, Block> EVOLITE_CHANDELIER = REGISTRY.register("evolite_chandelier", () -> new EvoliteChandelierBlock());
    public static final DeferredHolder<Block, Block> RUM_BOTTLE = REGISTRY.register("rum_bottle", () -> new RumBottleBlock());
    public static final DeferredHolder<Block, Block> GOOBULB = REGISTRY.register("goobulb", () -> new GoobulbBlock());
    public static final DeferredHolder<Block, Block> EVOLITE_BLOCK = REGISTRY.register("evolite_block", () -> new EvoliteBlockBlock());
    public static final DeferredHolder<Block, Block> CONFETTI_TRAIL = REGISTRY.register("confetti_trail", () -> new ConfettiTrailBlock());
    public static final DeferredHolder<Block, Block> CONFETTI_POPPER = REGISTRY.register("confetti_popper", () -> new ConfettiPopperBlock());
    public static final DeferredHolder<Block, Block> TROPHY = REGISTRY.register("trophy", () -> new TrophyBlock());
    public static final DeferredHolder<Block, Block> GRAVEDIGGER_JAR = REGISTRY.register("gravedigger_jar", () -> new GravediggerJarBlock());
    public static final DeferredHolder<Block, Block> THICK_ECTOMETAL_SCREW = REGISTRY.register("thick_ectometal_screw", () -> new ThickEctometalScrewBlock());
}
