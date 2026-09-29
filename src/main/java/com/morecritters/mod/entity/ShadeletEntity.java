package com.morecritters.mod.entity;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.procedures.AsdassadProcedure;
import com.morecritters.mod.procedures.ShadeletAttackedProcedure;
import com.morecritters.mod.procedures.ShadeletOnEntityTickUpdateProcedure;
import com.morecritters.mod.procedures.ShadeletOnInitialEntitySpawnProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.animation.AnimationController.State;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ShadeletEntity extends PathfinderMob implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(ShadeletEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(ShadeletEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(ShadeletEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Integer> DATA_sugarrush = SynchedEntityData.defineId(ShadeletEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> DATA_chasing = SynchedEntityData.defineId(ShadeletEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public ShadeletEntity(EntityType<ShadeletEntity> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "shadelet");
        builder.define(DATA_sugarrush, 0);
        builder.define(DATA_chasing, false);
    }

    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, LivingEntity.class, 6.0F));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<LivingEntity>(this, LivingEntity.class, 6.0F, 1.0, 1.2) {
            @Override
            public boolean canUse() {
                double x = ShadeletEntity.this.getX();
                double y = ShadeletEntity.this.getY();
                double z = ShadeletEntity.this.getZ();
                Entity entity = ShadeletEntity.this;
                Level world = ShadeletEntity.this.level();
                return super.canUse() && AsdassadProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = ShadeletEntity.this.getX();
                double y = ShadeletEntity.this.getY();
                double z = ShadeletEntity.this.getZ();
                Entity entity = ShadeletEntity.this;
                Level world = ShadeletEntity.this.level();
                return super.canContinueToUse() && AsdassadProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new FloatGoal(this));
    }


    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shadelet.idle"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shadelet.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shadelet.death"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        ShadeletAttackedProcedure.execute(this, source.getEntity());
        if (source.is(DamageTypes.IN_FIRE)) {
            return false;
        } else if (source.getDirectEntity() instanceof AbstractArrow) {
            return false;
        } else if (source.getDirectEntity() instanceof Player) {
            return false;
        } else if (source.is(DamageTypes.FALL)) {
            return false;
        } else if (source.is(DamageTypes.CACTUS)) {
            return false;
        } else if (source.is(DamageTypes.DROWN)) {
            return false;
        } else if (source.is(DamageTypes.LIGHTNING_BOLT)) {
            return false;
        } else if (source.is(DamageTypes.EXPLOSION)) {
            return false;
        } else if (source.is(DamageTypes.TRIDENT)) {
            return false;
        } else if (source.is(DamageTypes.FALLING_ANVIL)) {
            return false;
        } else if (source.is(DamageTypes.DRAGON_BREATH)) {
            return false;
        } else if (source.is(DamageTypes.WITHER)) {
            return false;
        } else {
            return source.is(DamageTypes.WITHER_SKULL) ? false : super.hurt(source, amount);
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        ShadeletOnInitialEntitySpawnProcedure.execute(this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
        compound.putInt("Datasugarrush", this.entityData.get(DATA_sugarrush));
        compound.putBoolean("Datachasing", this.entityData.get(DATA_chasing));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture")) {
            this.setTexture(compound.getString("Texture"));
        }

        if (compound.contains("Datasugarrush")) {
            this.entityData.set(DATA_sugarrush, compound.getInt("Datasugarrush"));
        }

        if (compound.contains("Datachasing")) {
            this.entityData.set(DATA_chasing, compound.getBoolean("Datachasing"));
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        ShadeletOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        return super.getDefaultDimensions(p_33597_).scale(1.1F);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(
            MoreCrittersModEntities.SHADELET.get(),
            SpawnPlacementTypes.ON_GROUND,
            Types.MOTION_BLOCKING_NO_LEAVES,
            (entityType, world, reason, pos, random) -> world.getDifficulty() != Difficulty.PEACEFUL
                && Monster.isDarkEnoughToSpawn(world, pos, random)
                && Mob.checkMobSpawnRules(entityType, world, reason, pos, random),
            RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }

    public static Builder createAttributes() {
        Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 10.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 0.0);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder.add(Attributes.FOLLOW_RANGE, 16.0);
    }

    private PlayState movementPredicate(AnimationState event) {
        if (!this.animationprocedure.equals("empty")) {
            return PlayState.STOP;
        } else if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F) || !(event.getLimbSwingAmount() < 0.15F)) && !this.isSprinting()) {
            return event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
        } else {
            return this.isSprinting()
                ? event.setAndContinue(RawAnimation.begin().thenLoop("run"))
                : event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        }
    }

    private PlayState procedurePredicate(AnimationState event) {
        if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == State.STOPPED
            || !this.animationprocedure.equals(this.prevAnim) && !this.animationprocedure.equals("empty")) {
            if (!this.animationprocedure.equals(this.prevAnim)) {
                event.getController().forceAnimationReset();
            }

            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            if (event.getController().getAnimationState() == State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
        } else if (this.animationprocedure.equals("empty")) {
            this.prevAnim = "empty";
            return PlayState.STOP;
        }

        this.prevAnim = this.animationprocedure;
        return PlayState.CONTINUE;
    }

    @Override
    protected void tickDeath() {
        this.deathTime++;
        if (this.deathTime == 20) {
            this.remove(RemovalReason.KILLED);
            this.dropExperience(null);
        }
    }

    public String getSyncedAnimation() {
        return this.entityData.get(ANIMATION);
    }

    public void setAnimation(String animation) {
        this.entityData.set(ANIMATION, animation);
    }

    @Override
    public void registerControllers(ControllerRegistrar data) {
        data.add(new AnimationController<>(this, "movement", 2, this::movementPredicate));
        data.add(new AnimationController<>(this, "procedure", 2, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
