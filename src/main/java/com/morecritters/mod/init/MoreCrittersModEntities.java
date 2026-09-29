package com.morecritters.mod.init;

import net.minecraft.core.registries.Registries;
import com.morecritters.mod.entity.AmalgamEntity;
import com.morecritters.mod.entity.AncientCustodianEntity;
import com.morecritters.mod.entity.AncientSkeletonEntity;
import com.morecritters.mod.entity.AncientSkeletonExhibitEntity;
import com.morecritters.mod.entity.AnniveteranEntity;
import com.morecritters.mod.entity.ArmossilloEntity;
import com.morecritters.mod.entity.AvoiderEntity;
import com.morecritters.mod.entity.AvoiderFryEntity;
import com.morecritters.mod.entity.BabyArmossilloEntity;
import com.morecritters.mod.entity.BabyBunbugEntity;
import com.morecritters.mod.entity.BalloonRatEntity;
import com.morecritters.mod.entity.BlackIropodEntity;
import com.morecritters.mod.entity.BlubberfishEntity;
import com.morecritters.mod.entity.BlubberfishFryEntity;
import com.morecritters.mod.entity.BombJellyEntity;
import com.morecritters.mod.entity.BombJellyLargeEntity;
import com.morecritters.mod.entity.BombJellyMediumEntity;
import com.morecritters.mod.entity.BombJellySmallEntity;
import com.morecritters.mod.entity.BouncelizardEntity;
import com.morecritters.mod.entity.BubbleEntityEntity;
import com.morecritters.mod.entity.BunbugEntity;
import com.morecritters.mod.entity.CannonBallProjectileEntity;
import com.morecritters.mod.entity.CarrybugEntity;
import com.morecritters.mod.entity.CarrybugNoSaddleEntity;
import com.morecritters.mod.entity.ChatteringTeethEntity;
import com.morecritters.mod.entity.CobbleEntity;
import com.morecritters.mod.entity.ColdCannonBallProjectileEntity;
import com.morecritters.mod.entity.CombustingCannonBallProjectileEntity;
import com.morecritters.mod.entity.CorpseCaptainEntity;
import com.morecritters.mod.entity.CorpseCrewEntity;
import com.morecritters.mod.entity.CorpseLookoutEntity;
import com.morecritters.mod.entity.CorpseMateEntity;
import com.morecritters.mod.entity.CorpseParrotEntity;
import com.morecritters.mod.entity.CorpseQuartermasterEntity;
import com.morecritters.mod.entity.CorpseTankEntity;
import com.morecritters.mod.entity.CreeblossomEntity;
import com.morecritters.mod.entity.CritterAtlasModelEntity;
import com.morecritters.mod.entity.CritterEaterEntity;
import com.morecritters.mod.entity.CubefrogEntity;
import com.morecritters.mod.entity.CustodianEntity;
import com.morecritters.mod.entity.DominicEntity;
import com.morecritters.mod.entity.DripperEntity;
import com.morecritters.mod.entity.DungerEntity;
import com.morecritters.mod.entity.EchoEntity;
import com.morecritters.mod.entity.ElectricCannonBallProjectileEntity;
import com.morecritters.mod.entity.EvoliteMawEntity;
import com.morecritters.mod.entity.EvolutionerEntity;
import com.morecritters.mod.entity.ExpyEntity;
import com.morecritters.mod.entity.FireCannonBallProjectileEntity;
import com.morecritters.mod.entity.FlargEntity;
import com.morecritters.mod.entity.FlyingOozeRodEntity;
import com.morecritters.mod.entity.FlyingPearlEntity;
import com.morecritters.mod.entity.FresnoidEntity;
import com.morecritters.mod.entity.FrightshroomEntity;
import com.morecritters.mod.entity.FungalZombieEntity;
import com.morecritters.mod.entity.GillmunchEntity;
import com.morecritters.mod.entity.GravediggerEntity;
import com.morecritters.mod.entity.HealEchoEntity;
import com.morecritters.mod.entity.HealingRumProjectileEntity;
import com.morecritters.mod.entity.IroballEntity;
import com.morecritters.mod.entity.IropodEntity;
import com.morecritters.mod.entity.JellyTorpedoEntity;
import com.morecritters.mod.entity.KelpireEntity;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.LightflyEntity;
import com.morecritters.mod.entity.LookoutSpitEntity;
import com.morecritters.mod.entity.MangotriceEntity;
import com.morecritters.mod.entity.MightshroomEchoEntity;
import com.morecritters.mod.entity.MightshroomEntity;
import com.morecritters.mod.entity.Model10Entity;
import com.morecritters.mod.entity.Model13Entity;
import com.morecritters.mod.entity.Model15Entity;
import com.morecritters.mod.entity.Model16Entity;
import com.morecritters.mod.entity.Model17Entity;
import com.morecritters.mod.entity.Model19Entity;
import com.morecritters.mod.entity.Model1Entity;
import com.morecritters.mod.entity.Model7Entity;
import com.morecritters.mod.entity.Model9Entity;
import com.morecritters.mod.entity.MoriRootsEntity;
import com.morecritters.mod.entity.MothkidEntity;
import com.morecritters.mod.entity.NauticrawlEntity;
import com.morecritters.mod.entity.NervoidEntity;
import com.morecritters.mod.entity.NightshroomEntity;
import com.morecritters.mod.entity.OlmerEntity;
import com.morecritters.mod.entity.OpalcrabEntity;
import com.morecritters.mod.entity.PebbleEntity;
import com.morecritters.mod.entity.PinkMonsterEntity;
import com.morecritters.mod.entity.PiranheedEntity;
import com.morecritters.mod.entity.PlainswyrmEntity;
import com.morecritters.mod.entity.RamchuEntity;
import com.morecritters.mod.entity.RamchuFryEntity;
import com.morecritters.mod.entity.ResinPieceEntity;
import com.morecritters.mod.entity.ResinPuddleEntity;
import com.morecritters.mod.entity.RollballEntity;
import com.morecritters.mod.entity.RotPieceEntity;
import com.morecritters.mod.entity.RotSplashEntity;
import com.morecritters.mod.entity.RotZombieEntity;
import com.morecritters.mod.entity.ScowlEntity;
import com.morecritters.mod.entity.ShadeletEntity;
import com.morecritters.mod.entity.ShimmerwingEntity;
import com.morecritters.mod.entity.ShimmerwormEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import com.morecritters.mod.entity.ShockCubeSmallEntity;
import com.morecritters.mod.entity.ShriekbatEntity;
import com.morecritters.mod.entity.ShriekbombProjectileEntity;
import com.morecritters.mod.entity.SlashEffectEntity;
import com.morecritters.mod.entity.SlimeCannonBallProjectileEntity;
import com.morecritters.mod.entity.SmallHealEchoEntity;
import com.morecritters.mod.entity.SnekEntity;
import com.morecritters.mod.entity.SnowflakeSpiderEntity;
import com.morecritters.mod.entity.SoulRumProjectileEntity;
import com.morecritters.mod.entity.SplinterEntity;
import com.morecritters.mod.entity.StalkEntity;
import com.morecritters.mod.entity.StincarpEntity;
import com.morecritters.mod.entity.TamedCorpseParrotEntity;
import com.morecritters.mod.entity.TesterShriekEntity;
import com.morecritters.mod.entity.ThrownHardtackEntity;
import com.morecritters.mod.entity.ThrownInfestedHardtackEntity;
import com.morecritters.mod.entity.ThunderballProjectileEntity;
import com.morecritters.mod.entity.TreepletEntity;
import com.morecritters.mod.entity.TreeplingBottomEntity;
import com.morecritters.mod.entity.TreeplingMiddleEntity;
import com.morecritters.mod.entity.TreeplingTopEntity;
import com.morecritters.mod.entity.WanderingCollectorEntity;
import com.morecritters.mod.entity.WarptrapEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import com.morecritters.mod.entity.WebSackProjectileEntity;
import com.morecritters.mod.entity.ZombieNauticrawlEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(bus = Bus.MOD)
public class MoreCrittersModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, "more_critters");
    public static final DeferredHolder<EntityType<?>, EntityType<WanderingCollectorEntity>> WANDERING_COLLECTOR = register(
        "wandering_collector",
        Builder.<WanderingCollectorEntity>of(WanderingCollectorEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.95F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CarrybugEntity>> CARRYBUG = register(
        "carrybug",
        Builder.<CarrybugEntity>of(CarrybugEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(2.0F, 3.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BunbugEntity>> BUNBUG = register(
        "bunbug",
        Builder.<BunbugEntity>of(BunbugEntity::new, MobCategory.AMBIENT)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 0.7F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BabyBunbugEntity>> BABY_BUNBUG = register(
        "baby_bunbug",
        Builder.<BabyBunbugEntity>of(BabyBunbugEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.4F, 0.2F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SnowflakeSpiderEntity>> SNOWFLAKE_SPIDER = register(
        "snowflake_spider",
        Builder.<SnowflakeSpiderEntity>of(SnowflakeSpiderEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<WebSackProjectileEntity>> WEB_SACK_PROJECTILE = register(
        "web_sack_projectile",
        Builder.<WebSackProjectileEntity>of(WebSackProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<WebEntityEntity>> WEB_ENTITY = register(
        "web_entity",
        Builder.<WebEntityEntity>of(WebEntityEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 2.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ShriekbatEntity>> SHRIEKBAT = register(
        "shriekbat",
        Builder.<ShriekbatEntity>of(ShriekbatEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 1.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<EchoEntity>> ECHO = register(
        "echo",
        Builder.<EchoEntity>of(EchoEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ShriekbombProjectileEntity>> SHRIEKBOMB_PROJECTILE = register(
        "shriekbomb_projectile",
        Builder.<ShriekbombProjectileEntity>of(ShriekbombProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<LargeEchoEntity>> LARGE_ECHO = register(
        "large_echo",
        Builder.<LargeEchoEntity>of(LargeEchoEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CreeblossomEntity>> CREEBLOSSOM = register(
        "creeblossom",
        Builder.<CreeblossomEntity>of(CreeblossomEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BouncelizardEntity>> BOUNCELIZARD = register(
        "bouncelizard",
        Builder.<BouncelizardEntity>of(BouncelizardEntity::new, MobCategory.CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 0.3F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<StincarpEntity>> STINCARP = register(
        "stincarp",
        Builder.<StincarpEntity>of(StincarpEntity::new, MobCategory.WATER_CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(2.0F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ShockCubeEntity>> SHOCK_CUBE = register(
        "shock_cube",
        Builder.<ShockCubeEntity>of(ShockCubeEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ShockCubeSmallEntity>> SHOCK_CUBE_SMALL = register(
        "shock_cube_small",
        Builder.<ShockCubeSmallEntity>of(ShockCubeSmallEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BalloonRatEntity>> BALLOON_RAT = register(
        "balloon_rat",
        Builder.<BalloonRatEntity>of(BalloonRatEntity::new, MobCategory.AMBIENT)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.8F, 0.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<PinkMonsterEntity>> PINK_MONSTER = register(
        "pink_monster",
        Builder.<PinkMonsterEntity>of(PinkMonsterEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<WarptrapEntity>> WARPTRAP = register(
        "warptrap",
        Builder.<WarptrapEntity>of(WarptrapEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.3F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ShimmerwormEntity>> SHIMMERWORM = register(
        "shimmerworm",
        Builder.<ShimmerwormEntity>of(ShimmerwormEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ShimmerwingEntity>> SHIMMERWING = register(
        "shimmerwing",
        Builder.<ShimmerwingEntity>of(ShimmerwingEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<MightshroomEntity>> MIGHTSHROOM = register(
        "mightshroom",
        Builder.<MightshroomEntity>of(MightshroomEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.6F, 5.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<FungalZombieEntity>> FUNGAL_ZOMBIE = register(
        "fungal_zombie",
        Builder.<FungalZombieEntity>of(FungalZombieEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<MightshroomEchoEntity>> MIGHTSHROOM_ECHO = register(
        "mightshroom_echo",
        Builder.<MightshroomEchoEntity>of(MightshroomEchoEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<AncientSkeletonEntity>> ANCIENT_SKELETON = register(
        "ancient_skeleton",
        Builder.<AncientSkeletonEntity>of(AncientSkeletonEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(2.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<FrightshroomEntity>> FRIGHTSHROOM = register(
        "frightshroom",
        Builder.<FrightshroomEntity>of(FrightshroomEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.6F, 5.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<RotPieceEntity>> ROT_PIECE = register(
        "rot_piece",
        Builder.<RotPieceEntity>of(RotPieceEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<HealEchoEntity>> HEAL_ECHO = register(
        "heal_echo",
        Builder.<HealEchoEntity>of(HealEchoEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SmallHealEchoEntity>> SMALL_HEAL_ECHO = register(
        "small_heal_echo",
        Builder.<SmallHealEchoEntity>of(SmallHealEchoEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<MoriRootsEntity>> MORI_ROOTS = register(
        "mori_roots",
        Builder.<MoriRootsEntity>of(MoriRootsEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.5F, 0.7F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<NightshroomEntity>> NIGHTSHROOM = register(
        "nightshroom",
        Builder.<NightshroomEntity>of(NightshroomEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.6F, 5.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CubefrogEntity>> CUBEFROG = register(
        "cubefrog",
        Builder.<CubefrogEntity>of(CubefrogEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.4F, 0.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<PlainswyrmEntity>> PLAINSWYRM = register(
        "plainswyrm",
        Builder.<PlainswyrmEntity>of(PlainswyrmEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.4F, 0.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<DungerEntity>> DUNGER = register(
        "dunger",
        Builder.<DungerEntity>of(DungerEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.4F, 0.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SnekEntity>> SNEK = register(
        "snek",
        Builder.<SnekEntity>of(SnekEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.4F, 0.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ExpyEntity>> EXPY = register(
        "expy",
        Builder.<ExpyEntity>of(ExpyEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.4F, 0.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ScowlEntity>> SCOWL = register(
        "scowl",
        Builder.<ScowlEntity>of(ScowlEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.4F, 0.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<RollballEntity>> ROLLBALL = register(
        "rollball",
        Builder.<RollballEntity>of(RollballEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.4F, 0.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CritterAtlasModelEntity>> CRITTER_ATLAS_MODEL = register(
        "critter_atlas_model",
        Builder.<CritterAtlasModelEntity>of(CritterAtlasModelEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Model7Entity>> MODEL_7 = register(
        "model_7",
        Builder.<Model7Entity>of(Model7Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Model9Entity>> MODEL_9 = register(
        "model_9",
        Builder.<Model9Entity>of(Model9Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Model10Entity>> MODEL_10 = register(
        "model_10",
        Builder.<Model10Entity>of(Model10Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CritterEaterEntity>> CRITTER_EATER = register(
        "critter_eater",
        Builder.<CritterEaterEntity>of(CritterEaterEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.2F, 1.2F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CarrybugNoSaddleEntity>> CARRYBUG_NO_SADDLE = register(
        "carrybug_no_saddle",
        Builder.<CarrybugNoSaddleEntity>of(CarrybugNoSaddleEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(2.0F, 3.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BombJellySmallEntity>> BOMB_JELLY_SMALL = register(
        "bomb_jelly_small",
        Builder.<BombJellySmallEntity>of(BombJellySmallEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BombJellyMediumEntity>> BOMB_JELLY_MEDIUM = register(
        "bomb_jelly_medium",
        Builder.<BombJellyMediumEntity>of(BombJellyMediumEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.7F, 0.7F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BombJellyLargeEntity>> BOMB_JELLY_LARGE = register(
        "bomb_jelly_large",
        Builder.<BombJellyLargeEntity>of(BombJellyLargeEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.1F, 1.1F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BombJellyEntity>> BOMB_JELLY = register(
        "bomb_jelly",
        Builder.<BombJellyEntity>of(BombJellyEntity::new, MobCategory.WATER_CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<AvoiderEntity>> AVOIDER = register(
        "avoider",
        Builder.<AvoiderEntity>of(AvoiderEntity::new, MobCategory.WATER_CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.8F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<JellyTorpedoEntity>> JELLY_TORPEDO = register(
        "jelly_torpedo",
        Builder.<JellyTorpedoEntity>of(JellyTorpedoEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<IropodEntity>> IROPOD = register(
        "iropod",
        Builder.<IropodEntity>of(IropodEntity::new, MobCategory.UNDERGROUND_WATER_CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 0.9F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BlackIropodEntity>> BLACK_IROPOD = register(
        "black_iropod",
        Builder.<BlackIropodEntity>of(BlackIropodEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 0.9F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BlubberfishEntity>> BLUBBERFISH = register(
        "blubberfish",
        Builder.<BlubberfishEntity>of(BlubberfishEntity::new, MobCategory.WATER_CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.7F, 0.7F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<KelpireEntity>> KELPIRE = register(
        "kelpire",
        Builder.<KelpireEntity>of(KelpireEntity::new, MobCategory.WATER_CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.5F, 1.3F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BubbleEntityEntity>> BUBBLE_ENTITY = register(
        "bubble_entity",
        Builder.<BubbleEntityEntity>of(BubbleEntityEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<NauticrawlEntity>> NAUTICRAWL = register(
        "nauticrawl",
        Builder.<NauticrawlEntity>of(NauticrawlEntity::new, MobCategory.WATER_CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BlubberfishFryEntity>> BLUBBERFISH_FRY = register(
        "blubberfish_fry",
        Builder.<BlubberfishFryEntity>of(BlubberfishFryEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.3F, 0.3F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<AvoiderFryEntity>> AVOIDER_FRY = register(
        "avoider_fry",
        Builder.<AvoiderFryEntity>of(AvoiderFryEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.3F, 0.3F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<OpalcrabEntity>> OPALCRAB = register(
        "opalcrab",
        Builder.<OpalcrabEntity>of(OpalcrabEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.4F, 0.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Model13Entity>> MODEL_13 = register(
        "model_13",
        Builder.<Model13Entity>of(Model13Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Model15Entity>> MODEL_15 = register(
        "model_15",
        Builder.<Model15Entity>of(Model15Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Model16Entity>> MODEL_16 = register(
        "model_16",
        Builder.<Model16Entity>of(Model16Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<AncientSkeletonExhibitEntity>> ANCIENT_SKELETON_EXHIBIT = register(
        "ancient_skeleton_exhibit",
        Builder.<AncientSkeletonExhibitEntity>of(AncientSkeletonExhibitEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(2.0F, 3.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ShadeletEntity>> SHADELET = register(
        "shadelet",
        Builder.<ShadeletEntity>of(ShadeletEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.6F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<TreepletEntity>> TREEPLET = register(
        "treeplet",
        Builder.<TreepletEntity>of(TreepletEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.7F, 2.5F)
            .eyeHeight(1.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SplinterEntity>> SPLINTER = register(
        "splinter",
        Builder.<SplinterEntity>of(SplinterEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<TreeplingTopEntity>> TREEPLING_TOP = register(
        "treepling_top",
        Builder.<TreeplingTopEntity>of(TreeplingTopEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.8F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<TreeplingMiddleEntity>> TREEPLING_MIDDLE = register(
        "treepling_middle",
        Builder.<TreeplingMiddleEntity>of(TreeplingMiddleEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.8F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<TreeplingBottomEntity>> TREEPLING_BOTTOM = register(
        "treepling_bottom",
        Builder.<TreeplingBottomEntity>of(TreeplingBottomEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.8F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ResinPieceEntity>> RESIN_PIECE = register(
        "resin_piece",
        Builder.<ResinPieceEntity>of(ResinPieceEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<NervoidEntity>> NERVOID = register(
        "nervoid",
        Builder.<NervoidEntity>of(NervoidEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CannonBallProjectileEntity>> CANNON_BALL_PROJECTILE = register(
        "cannon_ball_projectile",
        Builder.<CannonBallProjectileEntity>of(CannonBallProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ColdCannonBallProjectileEntity>> COLD_CANNON_BALL_PROJECTILE = register(
        "cold_cannon_ball_projectile",
        Builder.<ColdCannonBallProjectileEntity>of(ColdCannonBallProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<FireCannonBallProjectileEntity>> FIRE_CANNON_BALL_PROJECTILE = register(
        "fire_cannon_ball_projectile",
        Builder.<FireCannonBallProjectileEntity>of(FireCannonBallProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SlimeCannonBallProjectileEntity>> SLIME_CANNON_BALL_PROJECTILE = register(
        "slime_cannon_ball_projectile",
        Builder.<SlimeCannonBallProjectileEntity>of(SlimeCannonBallProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CorpseMateEntity>> CORPSE_MATE = register(
        "corpse_mate",
        Builder.<CorpseMateEntity>of(CorpseMateEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(32)
            .setUpdateInterval(3)
            .sized(0.6F, 2.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<HealingRumProjectileEntity>> HEALING_RUM_PROJECTILE = register(
        "healing_rum_projectile",
        Builder.<HealingRumProjectileEntity>of(HealingRumProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.3F, 0.3F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ThrownHardtackEntity>> THROWN_HARDTACK = register(
        "thrown_hardtack",
        Builder.<ThrownHardtackEntity>of(ThrownHardtackEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ThrownInfestedHardtackEntity>> THROWN_INFESTED_HARDTACK = register(
        "thrown_infested_hardtack",
        Builder.<ThrownInfestedHardtackEntity>of(ThrownInfestedHardtackEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CorpseTankEntity>> CORPSE_TANK = register(
        "corpse_tank",
        Builder.<CorpseTankEntity>of(CorpseTankEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(32)
            .setUpdateInterval(3)
            .sized(1.2F, 2.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<FlyingPearlEntity>> FLYING_PEARL = register(
        "flying_pearl",
        Builder.<FlyingPearlEntity>of(FlyingPearlEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CorpseCaptainEntity>> CORPSE_CAPTAIN = register(
        "corpse_captain",
        Builder.<CorpseCaptainEntity>of(CorpseCaptainEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(32)
            .setUpdateInterval(3)
            .sized(1.0F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SoulRumProjectileEntity>> SOUL_RUM_PROJECTILE = register(
        "soul_rum_projectile",
        Builder.<SoulRumProjectileEntity>of(SoulRumProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CorpseParrotEntity>> CORPSE_PARROT = register(
        "corpse_parrot",
        Builder.<CorpseParrotEntity>of(CorpseParrotEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.7F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<TamedCorpseParrotEntity>> TAMED_CORPSE_PARROT = register(
        "tamed_corpse_parrot",
        Builder.<TamedCorpseParrotEntity>of(TamedCorpseParrotEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.7F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CorpseQuartermasterEntity>> CORPSE_QUARTERMASTER = register(
        "corpse_quartermaster",
        Builder.<CorpseQuartermasterEntity>of(CorpseQuartermasterEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(32)
            .setUpdateInterval(3)
            .sized(0.9F, 2.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CorpseCrewEntity>> CORPSE_CREW = register(
        "corpse_crew",
        Builder.<CorpseCrewEntity>of(CorpseCrewEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ZombieNauticrawlEntity>> ZOMBIE_NAUTICRAWL = register(
        "zombie_nauticrawl",
        Builder.<ZombieNauticrawlEntity>of(ZombieNauticrawlEntity::new, MobCategory.WATER_CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ResinPuddleEntity>> RESIN_PUDDLE = register(
        "resin_puddle",
        Builder.<ResinPuddleEntity>of(ResinPuddleEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 0.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<MothkidEntity>> MOTHKID = register(
        "mothkid",
        Builder.<MothkidEntity>of(MothkidEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<GillmunchEntity>> GILLMUNCH = register(
        "gillmunch",
        Builder.<GillmunchEntity>of(GillmunchEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Model17Entity>> MODEL_17 = register(
        "model_17",
        Builder.<Model17Entity>of(Model17Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Model19Entity>> MODEL_19 = register(
        "model_19",
        Builder.<Model19Entity>of(Model19Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<RotZombieEntity>> ROT_ZOMBIE = register(
        "rot_zombie",
        Builder.<RotZombieEntity>of(RotZombieEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ThunderballProjectileEntity>> THUNDERBALL_PROJECTILE = register(
        "thunderball_projectile",
        Builder.<ThunderballProjectileEntity>of(ThunderballProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<GravediggerEntity>> GRAVEDIGGER = register(
        "gravedigger",
        Builder.<GravediggerEntity>of(GravediggerEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.8F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<AmalgamEntity>> AMALGAM = register(
        "amalgam",
        Builder.<AmalgamEntity>of(AmalgamEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 2.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ArmossilloEntity>> ARMOSSILLO = register(
        "armossillo",
        Builder.<ArmossilloEntity>of(ArmossilloEntity::new, MobCategory.AMBIENT)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.5F, 1.7F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<BabyArmossilloEntity>> BABY_ARMOSSILLO = register(
        "baby_armossillo",
        Builder.<BabyArmossilloEntity>of(BabyArmossilloEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<FlyingOozeRodEntity>> FLYING_OOZE_ROD = register(
        "flying_ooze_rod",
        Builder.<FlyingOozeRodEntity>of(FlyingOozeRodEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<RamchuEntity>> RAMCHU = register(
        "ramchu",
        Builder.<RamchuEntity>of(RamchuEntity::new, MobCategory.UNDERGROUND_WATER_CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(1.0F, 0.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<RamchuFryEntity>> RAMCHU_FRY = register(
        "ramchu_fry",
        Builder.<RamchuFryEntity>of(RamchuFryEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.3F, 0.3F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<DripperEntity>> DRIPPER = register(
        "dripper",
        Builder.<DripperEntity>of(DripperEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.8F, 1.3F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<SlashEffectEntity>> SLASH_EFFECT = register(
        "slash_effect",
        Builder.<SlashEffectEntity>of(SlashEffectEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.4F, 0.4F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CustodianEntity>> CUSTODIAN = register(
        "custodian",
        Builder.<CustodianEntity>of(CustodianEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.7F, 3.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<AncientCustodianEntity>> ANCIENT_CUSTODIAN = register(
        "ancient_custodian",
        Builder.<AncientCustodianEntity>of(AncientCustodianEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.7F, 2.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<TesterShriekEntity>> TESTER_SHRIEK = register(
        "tester_shriek",
        Builder.<TesterShriekEntity>of(TesterShriekEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(1.0F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<StalkEntity>> STALK = register(
        "stalk",
        Builder.<StalkEntity>of(StalkEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ElectricCannonBallProjectileEntity>> ELECTRIC_CANNON_BALL_PROJECTILE = register(
        "electric_cannon_ball_projectile",
        Builder.<ElectricCannonBallProjectileEntity>of(ElectricCannonBallProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CombustingCannonBallProjectileEntity>> COMBUSTING_CANNON_BALL_PROJECTILE = register(
        "combusting_cannon_ball_projectile",
        Builder.<CombustingCannonBallProjectileEntity>of(CombustingCannonBallProjectileEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<PebbleEntity>> PEBBLE = register(
        "pebble",
        Builder.<PebbleEntity>of(PebbleEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<ChatteringTeethEntity>> CHATTERING_TEETH = register(
        "chattering_teeth",
        Builder.<ChatteringTeethEntity>of(ChatteringTeethEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.7F, 0.7F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CorpseLookoutEntity>> CORPSE_LOOKOUT = register(
        "corpse_lookout",
        Builder.<CorpseLookoutEntity>of(CorpseLookoutEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(120)
            .setUpdateInterval(3)
            .sized(0.6F, 3.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<LookoutSpitEntity>> LOOKOUT_SPIT = register(
        "lookout_spit",
        Builder.<LookoutSpitEntity>of(LookoutSpitEntity::new, MobCategory.MISC)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(1)
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<DominicEntity>> DOMINIC = register(
        "dominic",
        Builder.<DominicEntity>of(DominicEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<OlmerEntity>> OLMER = register(
        "olmer",
        Builder.<OlmerEntity>of(OlmerEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<EvolutionerEntity>> EVOLUTIONER = register(
        "evolutioner",
        Builder.<EvolutionerEntity>of(EvolutionerEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.95F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<FlargEntity>> FLARG = register(
        "flarg",
        Builder.<FlargEntity>of(FlargEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<PiranheedEntity>> PIRANHEED = register(
        "piranheed",
        Builder.<PiranheedEntity>of(PiranheedEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<MangotriceEntity>> MANGOTRICE = register(
        "mangotrice",
        Builder.<MangotriceEntity>of(MangotriceEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<FresnoidEntity>> FRESNOID = register(
        "fresnoid",
        Builder.<FresnoidEntity>of(FresnoidEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<EvoliteMawEntity>> EVOLITE_MAW = register(
        "evolite_maw",
        Builder.<EvoliteMawEntity>of(EvoliteMawEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.6F, 1.0F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<Model1Entity>> MODEL_1 = register(
        "model_1",
        Builder.<Model1Entity>of(Model1Entity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 1.8F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<RotSplashEntity>> ROT_SPLASH = register(
        "rot_splash",
        Builder.<RotSplashEntity>of(RotSplashEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.3F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<LightflyEntity>> LIGHTFLY = register(
        "lightfly",
        Builder.<LightflyEntity>of(LightflyEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.5F, 0.5F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<IroballEntity>> IROBALL = register(
        "iroball",
        Builder.<IroballEntity>of(IroballEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .fireImmune()
            .sized(0.7F, 0.7F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<CobbleEntity>> COBBLE = register(
        "cobble",
        Builder.<CobbleEntity>of(CobbleEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.6F, 0.6F)
    );
    public static final DeferredHolder<EntityType<?>, EntityType<AnniveteranEntity>> ANNIVETERAN = register(
        "anniveteran",
        Builder.<AnniveteranEntity>of(AnniveteranEntity::new, MobCategory.CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(64)
            .setUpdateInterval(3)
            .sized(0.9F, 1.7F)
    );

    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> entityTypeBuilder.build(registryname));
    }

    @SubscribeEvent
    public static void init(RegisterSpawnPlacementsEvent event) {
            WanderingCollectorEntity.init(event);
            CarrybugEntity.init(event);
            BunbugEntity.init(event);
            BabyBunbugEntity.init(event);
            SnowflakeSpiderEntity.init(event);
            WebEntityEntity.init(event);
            ShriekbatEntity.init(event);
            EchoEntity.init(event);
            LargeEchoEntity.init(event);
            CreeblossomEntity.init(event);
            BouncelizardEntity.init(event);
            StincarpEntity.init(event);
            ShockCubeEntity.init(event);
            ShockCubeSmallEntity.init(event);
            BalloonRatEntity.init(event);
            PinkMonsterEntity.init(event);
            WarptrapEntity.init(event);
            ShimmerwormEntity.init(event);
            ShimmerwingEntity.init(event);
            MightshroomEntity.init(event);
            FungalZombieEntity.init(event);
            MightshroomEchoEntity.init(event);
            AncientSkeletonEntity.init(event);
            FrightshroomEntity.init(event);
            HealEchoEntity.init(event);
            SmallHealEchoEntity.init(event);
            MoriRootsEntity.init(event);
            NightshroomEntity.init(event);
            CubefrogEntity.init(event);
            PlainswyrmEntity.init(event);
            DungerEntity.init(event);
            SnekEntity.init(event);
            ExpyEntity.init(event);
            ScowlEntity.init(event);
            RollballEntity.init(event);
            CritterAtlasModelEntity.init(event);
            Model7Entity.init(event);
            Model9Entity.init(event);
            Model10Entity.init(event);
            CritterEaterEntity.init(event);
            CarrybugNoSaddleEntity.init(event);
            BombJellySmallEntity.init(event);
            BombJellyMediumEntity.init(event);
            BombJellyLargeEntity.init(event);
            BombJellyEntity.init(event);
            AvoiderEntity.init(event);
            JellyTorpedoEntity.init(event);
            IropodEntity.init(event);
            BlackIropodEntity.init(event);
            BlubberfishEntity.init(event);
            KelpireEntity.init(event);
            BubbleEntityEntity.init(event);
            NauticrawlEntity.init(event);
            BlubberfishFryEntity.init(event);
            AvoiderFryEntity.init(event);
            OpalcrabEntity.init(event);
            Model13Entity.init(event);
            Model15Entity.init(event);
            Model16Entity.init(event);
            AncientSkeletonExhibitEntity.init(event);
            ShadeletEntity.init(event);
            TreepletEntity.init(event);
            TreeplingTopEntity.init(event);
            TreeplingMiddleEntity.init(event);
            TreeplingBottomEntity.init(event);
            NervoidEntity.init(event);
            CorpseMateEntity.init(event);
            CorpseTankEntity.init(event);
            CorpseCaptainEntity.init(event);
            CorpseParrotEntity.init(event);
            TamedCorpseParrotEntity.init(event);
            CorpseQuartermasterEntity.init(event);
            CorpseCrewEntity.init(event);
            ZombieNauticrawlEntity.init(event);
            ResinPuddleEntity.init(event);
            MothkidEntity.init(event);
            GillmunchEntity.init(event);
            Model17Entity.init(event);
            Model19Entity.init(event);
            RotZombieEntity.init(event);
            GravediggerEntity.init(event);
            AmalgamEntity.init(event);
            ArmossilloEntity.init(event);
            BabyArmossilloEntity.init(event);
            FlyingOozeRodEntity.init(event);
            RamchuEntity.init(event);
            RamchuFryEntity.init(event);
            DripperEntity.init(event);
            SlashEffectEntity.init(event);
            CustodianEntity.init(event);
            AncientCustodianEntity.init(event);
            TesterShriekEntity.init(event);
            StalkEntity.init(event);
            ChatteringTeethEntity.init(event);
            CorpseLookoutEntity.init(event);
            DominicEntity.init(event);
            OlmerEntity.init(event);
            EvolutionerEntity.init(event);
            FlargEntity.init(event);
            PiranheedEntity.init(event);
            MangotriceEntity.init(event);
            FresnoidEntity.init(event);
            EvoliteMawEntity.init(event);
            Model1Entity.init(event);
            RotSplashEntity.init(event);
            LightflyEntity.init(event);
            IroballEntity.init(event);
            CobbleEntity.init(event);
            AnniveteranEntity.init(event);
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerEntity(Capabilities.ItemHandler.ENTITY, CARRYBUG.get(), (entity, context) -> entity.isAlive() ? entity.getCombinedInventory() : null);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(WANDERING_COLLECTOR.get(), WanderingCollectorEntity.createAttributes().build());
        event.put(CARRYBUG.get(), CarrybugEntity.createAttributes().build());
        event.put(BUNBUG.get(), BunbugEntity.createAttributes().build());
        event.put(BABY_BUNBUG.get(), BabyBunbugEntity.createAttributes().build());
        event.put(SNOWFLAKE_SPIDER.get(), SnowflakeSpiderEntity.createAttributes().build());
        event.put(WEB_ENTITY.get(), WebEntityEntity.createAttributes().build());
        event.put(SHRIEKBAT.get(), ShriekbatEntity.createAttributes().build());
        event.put(ECHO.get(), EchoEntity.createAttributes().build());
        event.put(LARGE_ECHO.get(), LargeEchoEntity.createAttributes().build());
        event.put(CREEBLOSSOM.get(), CreeblossomEntity.createAttributes().build());
        event.put(BOUNCELIZARD.get(), BouncelizardEntity.createAttributes().build());
        event.put(STINCARP.get(), StincarpEntity.createAttributes().build());
        event.put(SHOCK_CUBE.get(), ShockCubeEntity.createAttributes().build());
        event.put(SHOCK_CUBE_SMALL.get(), ShockCubeSmallEntity.createAttributes().build());
        event.put(BALLOON_RAT.get(), BalloonRatEntity.createAttributes().build());
        event.put(PINK_MONSTER.get(), PinkMonsterEntity.createAttributes().build());
        event.put(WARPTRAP.get(), WarptrapEntity.createAttributes().build());
        event.put(SHIMMERWORM.get(), ShimmerwormEntity.createAttributes().build());
        event.put(SHIMMERWING.get(), ShimmerwingEntity.createAttributes().build());
        event.put(MIGHTSHROOM.get(), MightshroomEntity.createAttributes().build());
        event.put(FUNGAL_ZOMBIE.get(), FungalZombieEntity.createAttributes().build());
        event.put(MIGHTSHROOM_ECHO.get(), MightshroomEchoEntity.createAttributes().build());
        event.put(ANCIENT_SKELETON.get(), AncientSkeletonEntity.createAttributes().build());
        event.put(FRIGHTSHROOM.get(), FrightshroomEntity.createAttributes().build());
        event.put(HEAL_ECHO.get(), HealEchoEntity.createAttributes().build());
        event.put(SMALL_HEAL_ECHO.get(), SmallHealEchoEntity.createAttributes().build());
        event.put(MORI_ROOTS.get(), MoriRootsEntity.createAttributes().build());
        event.put(NIGHTSHROOM.get(), NightshroomEntity.createAttributes().build());
        event.put(CUBEFROG.get(), CubefrogEntity.createAttributes().build());
        event.put(PLAINSWYRM.get(), PlainswyrmEntity.createAttributes().build());
        event.put(DUNGER.get(), DungerEntity.createAttributes().build());
        event.put(SNEK.get(), SnekEntity.createAttributes().build());
        event.put(EXPY.get(), ExpyEntity.createAttributes().build());
        event.put(SCOWL.get(), ScowlEntity.createAttributes().build());
        event.put(ROLLBALL.get(), RollballEntity.createAttributes().build());
        event.put(CRITTER_ATLAS_MODEL.get(), CritterAtlasModelEntity.createAttributes().build());
        event.put(MODEL_7.get(), Model7Entity.createAttributes().build());
        event.put(MODEL_9.get(), Model9Entity.createAttributes().build());
        event.put(MODEL_10.get(), Model10Entity.createAttributes().build());
        event.put(CRITTER_EATER.get(), CritterEaterEntity.createAttributes().build());
        event.put(CARRYBUG_NO_SADDLE.get(), CarrybugNoSaddleEntity.createAttributes().build());
        event.put(BOMB_JELLY_SMALL.get(), BombJellySmallEntity.createAttributes().build());
        event.put(BOMB_JELLY_MEDIUM.get(), BombJellyMediumEntity.createAttributes().build());
        event.put(BOMB_JELLY_LARGE.get(), BombJellyLargeEntity.createAttributes().build());
        event.put(BOMB_JELLY.get(), BombJellyEntity.createAttributes().build());
        event.put(AVOIDER.get(), AvoiderEntity.createAttributes().build());
        event.put(JELLY_TORPEDO.get(), JellyTorpedoEntity.createAttributes().build());
        event.put(IROPOD.get(), IropodEntity.createAttributes().build());
        event.put(BLACK_IROPOD.get(), BlackIropodEntity.createAttributes().build());
        event.put(BLUBBERFISH.get(), BlubberfishEntity.createAttributes().build());
        event.put(KELPIRE.get(), KelpireEntity.createAttributes().build());
        event.put(BUBBLE_ENTITY.get(), BubbleEntityEntity.createAttributes().build());
        event.put(NAUTICRAWL.get(), NauticrawlEntity.createAttributes().build());
        event.put(BLUBBERFISH_FRY.get(), BlubberfishFryEntity.createAttributes().build());
        event.put(AVOIDER_FRY.get(), AvoiderFryEntity.createAttributes().build());
        event.put(OPALCRAB.get(), OpalcrabEntity.createAttributes().build());
        event.put(MODEL_13.get(), Model13Entity.createAttributes().build());
        event.put(MODEL_15.get(), Model15Entity.createAttributes().build());
        event.put(MODEL_16.get(), Model16Entity.createAttributes().build());
        event.put(ANCIENT_SKELETON_EXHIBIT.get(), AncientSkeletonExhibitEntity.createAttributes().build());
        event.put(SHADELET.get(), ShadeletEntity.createAttributes().build());
        event.put(TREEPLET.get(), TreepletEntity.createAttributes().build());
        event.put(TREEPLING_TOP.get(), TreeplingTopEntity.createAttributes().build());
        event.put(TREEPLING_MIDDLE.get(), TreeplingMiddleEntity.createAttributes().build());
        event.put(TREEPLING_BOTTOM.get(), TreeplingBottomEntity.createAttributes().build());
        event.put(NERVOID.get(), NervoidEntity.createAttributes().build());
        event.put(CORPSE_MATE.get(), CorpseMateEntity.createAttributes().build());
        event.put(CORPSE_TANK.get(), CorpseTankEntity.createAttributes().build());
        event.put(CORPSE_CAPTAIN.get(), CorpseCaptainEntity.createAttributes().build());
        event.put(CORPSE_PARROT.get(), CorpseParrotEntity.createAttributes().build());
        event.put(TAMED_CORPSE_PARROT.get(), TamedCorpseParrotEntity.createAttributes().build());
        event.put(CORPSE_QUARTERMASTER.get(), CorpseQuartermasterEntity.createAttributes().build());
        event.put(CORPSE_CREW.get(), CorpseCrewEntity.createAttributes().build());
        event.put(ZOMBIE_NAUTICRAWL.get(), ZombieNauticrawlEntity.createAttributes().build());
        event.put(RESIN_PUDDLE.get(), ResinPuddleEntity.createAttributes().build());
        event.put(MOTHKID.get(), MothkidEntity.createAttributes().build());
        event.put(GILLMUNCH.get(), GillmunchEntity.createAttributes().build());
        event.put(MODEL_17.get(), Model17Entity.createAttributes().build());
        event.put(MODEL_19.get(), Model19Entity.createAttributes().build());
        event.put(ROT_ZOMBIE.get(), RotZombieEntity.createAttributes().build());
        event.put(GRAVEDIGGER.get(), GravediggerEntity.createAttributes().build());
        event.put(AMALGAM.get(), AmalgamEntity.createAttributes().build());
        event.put(ARMOSSILLO.get(), ArmossilloEntity.createAttributes().build());
        event.put(BABY_ARMOSSILLO.get(), BabyArmossilloEntity.createAttributes().build());
        event.put(FLYING_OOZE_ROD.get(), FlyingOozeRodEntity.createAttributes().build());
        event.put(RAMCHU.get(), RamchuEntity.createAttributes().build());
        event.put(RAMCHU_FRY.get(), RamchuFryEntity.createAttributes().build());
        event.put(DRIPPER.get(), DripperEntity.createAttributes().build());
        event.put(SLASH_EFFECT.get(), SlashEffectEntity.createAttributes().build());
        event.put(CUSTODIAN.get(), CustodianEntity.createAttributes().build());
        event.put(ANCIENT_CUSTODIAN.get(), AncientCustodianEntity.createAttributes().build());
        event.put(TESTER_SHRIEK.get(), TesterShriekEntity.createAttributes().build());
        event.put(STALK.get(), StalkEntity.createAttributes().build());
        event.put(CHATTERING_TEETH.get(), ChatteringTeethEntity.createAttributes().build());
        event.put(CORPSE_LOOKOUT.get(), CorpseLookoutEntity.createAttributes().build());
        event.put(DOMINIC.get(), DominicEntity.createAttributes().build());
        event.put(OLMER.get(), OlmerEntity.createAttributes().build());
        event.put(EVOLUTIONER.get(), EvolutionerEntity.createAttributes().build());
        event.put(FLARG.get(), FlargEntity.createAttributes().build());
        event.put(PIRANHEED.get(), PiranheedEntity.createAttributes().build());
        event.put(MANGOTRICE.get(), MangotriceEntity.createAttributes().build());
        event.put(FRESNOID.get(), FresnoidEntity.createAttributes().build());
        event.put(EVOLITE_MAW.get(), EvoliteMawEntity.createAttributes().build());
        event.put(MODEL_1.get(), Model1Entity.createAttributes().build());
        event.put(ROT_SPLASH.get(), RotSplashEntity.createAttributes().build());
        event.put(LIGHTFLY.get(), LightflyEntity.createAttributes().build());
        event.put(IROBALL.get(), IroballEntity.createAttributes().build());
        event.put(COBBLE.get(), CobbleEntity.createAttributes().build());
        event.put(ANNIVETERAN.get(), AnniveteranEntity.createAttributes().build());
    }
}
