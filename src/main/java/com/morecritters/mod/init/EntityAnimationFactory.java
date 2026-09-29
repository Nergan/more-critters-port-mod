package com.morecritters.mod.init;

import net.minecraft.world.entity.LivingEntity;
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
import com.morecritters.mod.entity.CarrybugEntity;
import com.morecritters.mod.entity.CarrybugNoSaddleEntity;
import com.morecritters.mod.entity.ChatteringTeethEntity;
import com.morecritters.mod.entity.CobbleEntity;
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
import com.morecritters.mod.entity.EvoliteMawEntity;
import com.morecritters.mod.entity.EvolutionerEntity;
import com.morecritters.mod.entity.ExpyEntity;
import com.morecritters.mod.entity.FlargEntity;
import com.morecritters.mod.entity.FlyingOozeRodEntity;
import com.morecritters.mod.entity.FresnoidEntity;
import com.morecritters.mod.entity.FrightshroomEntity;
import com.morecritters.mod.entity.FungalZombieEntity;
import com.morecritters.mod.entity.GillmunchEntity;
import com.morecritters.mod.entity.GravediggerEntity;
import com.morecritters.mod.entity.HealEchoEntity;
import com.morecritters.mod.entity.IroballEntity;
import com.morecritters.mod.entity.IropodEntity;
import com.morecritters.mod.entity.JellyTorpedoEntity;
import com.morecritters.mod.entity.KelpireEntity;
import com.morecritters.mod.entity.LargeEchoEntity;
import com.morecritters.mod.entity.LightflyEntity;
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
import com.morecritters.mod.entity.PinkMonsterEntity;
import com.morecritters.mod.entity.PiranheedEntity;
import com.morecritters.mod.entity.PlainswyrmEntity;
import com.morecritters.mod.entity.RamchuEntity;
import com.morecritters.mod.entity.RamchuFryEntity;
import com.morecritters.mod.entity.ResinPuddleEntity;
import com.morecritters.mod.entity.RollballEntity;
import com.morecritters.mod.entity.RotSplashEntity;
import com.morecritters.mod.entity.RotZombieEntity;
import com.morecritters.mod.entity.ScowlEntity;
import com.morecritters.mod.entity.ShadeletEntity;
import com.morecritters.mod.entity.ShimmerwingEntity;
import com.morecritters.mod.entity.ShimmerwormEntity;
import com.morecritters.mod.entity.ShockCubeEntity;
import com.morecritters.mod.entity.ShockCubeSmallEntity;
import com.morecritters.mod.entity.ShriekbatEntity;
import com.morecritters.mod.entity.SlashEffectEntity;
import com.morecritters.mod.entity.SmallHealEchoEntity;
import com.morecritters.mod.entity.SnekEntity;
import com.morecritters.mod.entity.SnowflakeSpiderEntity;
import com.morecritters.mod.entity.StalkEntity;
import com.morecritters.mod.entity.StincarpEntity;
import com.morecritters.mod.entity.TamedCorpseParrotEntity;
import com.morecritters.mod.entity.TesterShriekEntity;
import com.morecritters.mod.entity.TreepletEntity;
import com.morecritters.mod.entity.TreeplingBottomEntity;
import com.morecritters.mod.entity.TreeplingMiddleEntity;
import com.morecritters.mod.entity.TreeplingTopEntity;
import com.morecritters.mod.entity.WanderingCollectorEntity;
import com.morecritters.mod.entity.WarptrapEntity;
import com.morecritters.mod.entity.WebEntityEntity;
import com.morecritters.mod.entity.ZombieNauticrawlEntity;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class EntityAnimationFactory {
    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Pre event) {
        if (event != null && event.getEntity() instanceof LivingEntity) {
            if (event.getEntity() instanceof WanderingCollectorEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CarrybugEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BunbugEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BabyBunbugEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof SnowflakeSpiderEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof WebEntityEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ShriekbatEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof EchoEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof LargeEchoEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CreeblossomEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BouncelizardEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof StincarpEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ShockCubeEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ShockCubeSmallEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BalloonRatEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof PinkMonsterEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof WarptrapEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ShimmerwormEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ShimmerwingEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof MightshroomEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof FungalZombieEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof MightshroomEchoEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof AncientSkeletonEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof FrightshroomEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof HealEchoEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof SmallHealEchoEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof MoriRootsEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof NightshroomEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CubefrogEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof PlainswyrmEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof DungerEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof SnekEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ExpyEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ScowlEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof RollballEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CritterAtlasModelEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof Model7Entity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof Model9Entity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof Model10Entity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CritterEaterEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CarrybugNoSaddleEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BombJellySmallEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BombJellyMediumEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BombJellyLargeEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BombJellyEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof AvoiderEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof JellyTorpedoEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof IropodEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BlackIropodEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BlubberfishEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof KelpireEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BubbleEntityEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof NauticrawlEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BlubberfishFryEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof AvoiderFryEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof OpalcrabEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof Model13Entity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof Model15Entity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof Model16Entity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof AncientSkeletonExhibitEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ShadeletEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof TreepletEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof TreeplingTopEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof TreeplingMiddleEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof TreeplingBottomEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof NervoidEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CorpseMateEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CorpseTankEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CorpseCaptainEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CorpseParrotEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof TamedCorpseParrotEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CorpseQuartermasterEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CorpseCrewEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ZombieNauticrawlEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ResinPuddleEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof MothkidEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof GillmunchEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof Model17Entity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof Model19Entity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof RotZombieEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof GravediggerEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof AmalgamEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ArmossilloEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof BabyArmossilloEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof FlyingOozeRodEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof RamchuEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof RamchuFryEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof DripperEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof SlashEffectEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CustodianEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof AncientCustodianEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof TesterShriekEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof StalkEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof ChatteringTeethEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CorpseLookoutEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof DominicEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof OlmerEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof EvolutionerEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof FlargEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof PiranheedEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof MangotriceEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof FresnoidEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof EvoliteMawEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof Model1Entity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof RotSplashEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof LightflyEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof IroballEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof CobbleEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }

            if (event.getEntity() instanceof AnniveteranEntity syncable) {
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
        }
    }
}
