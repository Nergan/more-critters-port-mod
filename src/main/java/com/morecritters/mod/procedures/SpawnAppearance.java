package com.morecritters.mod.procedures;

import com.morecritters.mod.block.BouncelizardEggBlock;
import com.morecritters.mod.config.ServerConfig;
import com.morecritters.mod.entity.AnniveteranEntity;
import com.morecritters.mod.entity.ArmossilloEntity;
import com.morecritters.mod.entity.AvoiderEntity;
import com.morecritters.mod.entity.BalloonRatEntity;
import com.morecritters.mod.entity.BlubberfishEntity;
import com.morecritters.mod.entity.BouncelizardEntity;
import com.morecritters.mod.entity.BunbugEntity;
import com.morecritters.mod.entity.CobbleEntity;
import com.morecritters.mod.entity.CorpseMateEntity;
import com.morecritters.mod.entity.CreeblossomEntity;
import com.morecritters.mod.entity.CubefrogEntity;
import com.morecritters.mod.entity.DominicEntity;
import com.morecritters.mod.entity.DungerEntity;
import com.morecritters.mod.entity.ExpyEntity;
import com.morecritters.mod.entity.FlargEntity;
import com.morecritters.mod.entity.FresnoidEntity;
import com.morecritters.mod.entity.GillmunchEntity;
import com.morecritters.mod.entity.MangotriceEntity;
import com.morecritters.mod.entity.MothkidEntity;
import com.morecritters.mod.entity.OlmerEntity;
import com.morecritters.mod.entity.OpalcrabEntity;
import com.morecritters.mod.entity.PiranheedEntity;
import com.morecritters.mod.entity.PlainswyrmEntity;
import com.morecritters.mod.entity.RamchuEntity;
import com.morecritters.mod.entity.RollballEntity;
import com.morecritters.mod.entity.ScowlEntity;
import com.morecritters.mod.entity.SnekEntity;
import com.morecritters.mod.entity.StalkEntity;
import com.morecritters.mod.init.MoreCrittersModBlocks;
import com.morecritters.mod.init.MoreCrittersModEntities;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber
public final class SpawnAppearance {
    private SpawnAppearance() {
    }

    @SubscribeEvent
    public static void onJoin(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide() || event.getEntity().isRemoved()) {
            return;
        }

        Entity entity = event.getEntity();
        if (entity.getPersistentData().getBoolean("form_swapped")) {
            event.setCanceled(true);
            return;
        }

        if (swapBabyForm(entity)) {
            event.setCanceled(true);
            return;
        }

        applyVariantTexture(entity);
    }

    public static void applyVariantTexture(Entity entity) {
        if (entity instanceof CobbleEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(CobbleEntity.DATA_variant), "cobble", "cobble_rare", "cobble_epic", mob::setTexture);
        } else if (entity instanceof StalkEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(StalkEntity.DATA_variant), "stalk", "rare_stalk", "epic_stalk", mob::setTexture);
        } else if (entity instanceof SnekEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(SnekEntity.DATA_variant), "snek", "rare_snek", "epic_snek", mob::setTexture);
        } else if (entity instanceof ScowlEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(ScowlEntity.DATA_variant), "scowl", "rare_scowl", "epic_scowl", mob::setTexture);
        } else if (entity instanceof PlainswyrmEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(PlainswyrmEntity.DATA_variant), "plainswyrm", "rare_plainswyrm", "epic_plainswyrm", mob::setTexture);
        } else if (entity instanceof OpalcrabEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(OpalcrabEntity.DATA_variant), "opalcrab", "rare_opalcrab", "epic_opalcrab", mob::setTexture);
        } else if (entity instanceof MothkidEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(MothkidEntity.DATA_variant), "mothkid", "rare_mothkid", "epic_mothkid", mob::setTexture);
        } else if (entity instanceof GillmunchEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(GillmunchEntity.DATA_variant), "gillmunch", "rare_gillmunch", "epic_gillmunch", mob::setTexture);
        } else if (entity instanceof ExpyEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(ExpyEntity.DATA_variant), "expy", "rare_expy", "epic_expy", mob::setTexture);
        } else if (entity instanceof DungerEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(DungerEntity.DATA_variant), "dunger", "rare_dunger", "epic_dunger", mob::setTexture);
        } else if (entity instanceof CubefrogEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(CubefrogEntity.DATA_variant), "cubefrog", "rare_cubefrog", "epic_cubefrog", mob::setTexture);
        } else if (entity instanceof RollballEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(RollballEntity.DATA_variant), "rollball", "rare_rollball", "epic_rollball", mob::setTexture);
        } else if (entity instanceof PiranheedEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(PiranheedEntity.DATA_variant), "piranheed", "piranheed_rare", "piranheed_epic", mob::setTexture);
        } else if (entity instanceof OlmerEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(OlmerEntity.DATA_variant), "olmer", "olmer_rare", "olmer_epic", mob::setTexture);
        } else if (entity instanceof MangotriceEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(MangotriceEntity.DATA_variant), "mangotrice", "mangotrice_rare", "mangotrice_epic", mob::setTexture);
        } else if (entity instanceof FlargEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(FlargEntity.DATA_variant), "flarg", "flarg_rare", "flarg_epic", mob::setTexture);
        } else if (entity instanceof DominicEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(DominicEntity.DATA_variant), "dominic", "dominic_rare", "dominic_epic", mob::setTexture);
        } else if (entity instanceof FresnoidEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(FresnoidEntity.DATA_variant), "fresnoid", "fresnoid_rare", "fresnoid_epic", mob::setTexture);
        } else if (entity instanceof BalloonRatEntity mob) {
            wear(mob.getTexture(), mob.getEntityData().get(BalloonRatEntity.DATA_variant), "balloon_rat", "balloon_rat_medic", "balloon_rat_soldier", mob::setTexture);
        } else if (entity instanceof CorpseMateEntity mob) {
            int variant = mob.getEntityData().get(CorpseMateEntity.DATA_variant);
            wear(mob.getTexture(), variant, "corpse_mate0", "corpse_mate" + variant, "corpse_mate" + variant, mob::setTexture);
        } else if (entity instanceof AnniveteranEntity mob) {
            int variant = mob.getEntityData().get(AnniveteranEntity.DATA_variant);
            String skin = variant == 0 ? "anniveteran" : "anniveteran" + variant;
            wear(mob.getTexture(), variant, "anniveteran", skin, skin, mob::setTexture);
        }
    }

    public static void placeBouncelizardEgg(LevelAccessor world, BlockPos pos) {
        int roll = Mth.nextInt(RandomSource.create(), 0, 3);
        int value = switch (roll) {
            case 0 -> 0;
            case 1 -> 2;
            case 2 -> 3;
            default -> 4;
        };
        world.setBlock(pos, MoreCrittersModBlocks.BOUNCELIZARD_EGG.get().defaultBlockState().setValue(BouncelizardEggBlock.BLOCKSTATE, value), 3);
    }

    private static void wear(String current, int variant, String base, String rare, String epic, TextureTarget target) {
        if (variant == 0 || current == null || !current.equals(base)) {
            return;
        }

        target.set(variant == 1 ? rare : epic);
    }

    private static boolean swapBabyForm(Entity entity) {
        if (entity.getPersistentData().getBoolean("form_swapped")) {
            return true;
        }
        if (!(entity instanceof LivingEntity living) || !living.isBaby() || !(entity.level() instanceof ServerLevel level)) {
            return false;
        }

        if (entity instanceof BouncelizardEntity lizard && lizard.getEntityData().get(BouncelizardEntity.DATA_fromegg)) {
            return false;
        }

        if (!(entity instanceof BunbugEntity
            || entity instanceof RamchuEntity
            || entity instanceof BlubberfishEntity
            || entity instanceof AvoiderEntity
            || entity instanceof BouncelizardEntity
            || entity instanceof ArmossilloEntity
            || entity instanceof CreeblossomEntity)) {
            return false;
        }

        entity.getPersistentData().putBoolean("form_swapped", true);
        BlockPos pos = entity.blockPosition();
        if (entity instanceof BunbugEntity) {
            int count = (int)ServerConfig.CONFIG.bunbugBirth.get().doubleValue();
            for (int index = 0; index < count; index++) {
                spawnCopy(level, MoreCrittersModEntities.BABY_BUNBUG.get(), pos, entity);
            }
        } else if (entity instanceof RamchuEntity) {
            Entity child = MoreCrittersModEntities.RAMCHU_FRY.get().spawn(level, pos, MobSpawnType.MOB_SUMMONED);
            if (child != null) {
                child.setYRot((float)Math.random());
                child.setYBodyRot((float)Math.random());
                child.setYHeadRot((float)Math.random());
                child.setDeltaMovement(0.0, 0.0, 0.0);
            }
        } else if (entity instanceof BlubberfishEntity) {
            spawnCopy(level, MoreCrittersModEntities.BLUBBERFISH_FRY.get(), pos, entity);
        } else if (entity instanceof AvoiderEntity) {
            spawnCopy(level, MoreCrittersModEntities.AVOIDER_FRY.get(), pos, entity);
            grantNearby(level, entity, "more_critters:breed_avoider");
        } else if (entity instanceof BouncelizardEntity) {
            placeBouncelizardEgg(level, pos);
        } else if (entity instanceof ArmossilloEntity) {
            level.setBlock(pos, MoreCrittersModBlocks.MOSS_CLUMP.get().defaultBlockState(), 3);
        } else if (entity instanceof CreeblossomEntity) {
            spawnCopy(level, MoreCrittersModEntities.CREEBLOSSOM.get(), pos, entity);
        }

        entity.discard();
        return true;
    }

    private static void spawnCopy(ServerLevel level, net.minecraft.world.entity.EntityType<?> type, BlockPos pos, Entity parent) {
        Entity child = type.spawn(level, pos, MobSpawnType.MOB_SUMMONED);
        if (child != null) {
            child.setYRot(parent.getYRot());
            child.setYBodyRot(parent.getYRot());
            child.setYHeadRot(parent.getYRot());
            child.setXRot(parent.getXRot());
            child.setDeltaMovement(0.0, 0.0, 0.0);
        }
    }

    private static void grantNearby(ServerLevel level, Entity entity, String advancement) {
        Vec3 center = entity.position();
        for (Player player : level.getEntitiesOfClass(Player.class, new AABB(center, center).inflate(10.0), candidate -> true)) {
            if (!(player instanceof ServerPlayer serverPlayer)) {
                continue;
            }

            AdvancementHolder holder = serverPlayer.server.getAdvancements().get(ResourceLocation.parse(advancement));
            if (holder == null) {
                continue;
            }

            AdvancementProgress progress = serverPlayer.getAdvancements().getOrStartProgress(holder);
            if (!progress.isDone()) {
                for (String criterion : progress.getRemainingCriteria()) {
                    serverPlayer.getAdvancements().award(holder, criterion);
                }
            }
        }
    }

    @FunctionalInterface
    private interface TextureTarget {
        void set(String texture);
    }
}
