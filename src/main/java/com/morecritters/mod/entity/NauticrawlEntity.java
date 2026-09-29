package com.morecritters.mod.entity;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.procedures.NauticrawlEntityIsHurtProcedure;
import com.morecritters.mod.procedures.NauticrawlOnEntityTickUpdateProcedure;
import com.morecritters.mod.procedures.NauticrawlOnInitialEntitySpawn1Procedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.common.NeoForgeMod;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.animation.AnimationController.State;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class NauticrawlEntity extends Monster implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(NauticrawlEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(NauticrawlEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(NauticrawlEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Boolean> DATA_sleeping = SynchedEntityData.defineId(NauticrawlEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public NauticrawlEntity(EntityType<NauticrawlEntity> type, Level world) {
        super(type, world);
        this.xpReward = 2;
        this.setNoAi(false);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.moveControl = new MoveControl(this) {
            @Override
            public void tick() {
                if (NauticrawlEntity.this.isInWater()) {
                    NauticrawlEntity.this.setDeltaMovement(NauticrawlEntity.this.getDeltaMovement().add(0.0, 0.005, 0.0));
                }

                if (this.operation == Operation.MOVE_TO && !NauticrawlEntity.this.getNavigation().isDone()) {
                    double dx = this.wantedX - NauticrawlEntity.this.getX();
                    double dy = this.wantedY - NauticrawlEntity.this.getY();
                    double dz = this.wantedZ - NauticrawlEntity.this.getZ();
                    float f = (float)(Mth.atan2(dz, dx) * 57.29577951308232) - 90.0F;
                    float f1 = (float)(this.speedModifier * NauticrawlEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                    NauticrawlEntity.this.setYRot(this.rotlerp(NauticrawlEntity.this.getYRot(), f, 10.0F));
                    NauticrawlEntity.this.yBodyRot = NauticrawlEntity.this.getYRot();
                    NauticrawlEntity.this.yHeadRot = NauticrawlEntity.this.getYRot();
                    if (NauticrawlEntity.this.isInWater()) {
                        NauticrawlEntity.this.setSpeed((float)NauticrawlEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                        float f2 = -((float)(Mth.atan2(dy, (float)Math.sqrt(dx * dx + dz * dz)) * 57.29577951308232));
                        f2 = Mth.clamp(Mth.wrapDegrees(f2), -85.0F, 85.0F);
                        NauticrawlEntity.this.setXRot(this.rotlerp(NauticrawlEntity.this.getXRot(), f2, 5.0F));
                        float f3 = Mth.cos(NauticrawlEntity.this.getXRot() * 0.017453292F);
                        NauticrawlEntity.this.setZza(f3 * f1);
                        NauticrawlEntity.this.setYya((float)(f1 * dy));
                    } else {
                        NauticrawlEntity.this.setSpeed(f1 * 0.05F);
                    }
                } else {
                    NauticrawlEntity.this.setSpeed(0.0F);
                    NauticrawlEntity.this.setYya(0.0F);
                    NauticrawlEntity.this.setZza(0.0F);
                }
            }
        };
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "nauticrawl");
        builder.define(DATA_sleeping, true);
    }

    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }


    @Override
    protected PathNavigation createNavigation(Level world) {
        return new WaterBoundPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected boolean canPerformAttack(LivingEntity entity) {
                return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (4.0) && this.mob.getSensing().hasLineOfSight(entity);
            }
        });
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1.0, 40));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }


    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.nauticrawl.idle"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.nauticrawl.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.nauticrawl.death"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        NauticrawlEntityIsHurtProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), source.getEntity());
        return source.is(DamageTypes.DROWN) ? false : super.hurt(source, amount);
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        NauticrawlOnInitialEntitySpawn1Procedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
        compound.putBoolean("Datasleeping", this.entityData.get(DATA_sleeping));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture")) {
            this.setTexture(compound.getString("Texture"));
        }

        if (compound.contains("Datasleeping")) {
            this.entityData.set(DATA_sleeping, compound.getBoolean("Datasleeping"));
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        NauticrawlOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        return super.getDefaultDimensions(p_33597_).scale(1.2F);
    }


    @Override
    public boolean checkSpawnObstruction(LevelReader world) {
        return world.isUnobstructed(this);
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(
            MoreCrittersModEntities.NAUTICRAWL.get(),
            SpawnPlacementTypes.IN_WATER,
            Types.MOTION_BLOCKING_NO_LEAVES,
            (entityType, world, reason, pos, random) -> world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER),
            RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }

    public static Builder createAttributes() {
        Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.6);
        builder = builder.add(Attributes.MAX_HEALTH, 50.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 5.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 100.0);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.2);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder.add(NeoForgeMod.SWIM_SPEED, 0.6);
    }

    private PlayState movementPredicate(AnimationState event) {
        return this.animationprocedure.equals("empty") ? event.setAndContinue(RawAnimation.begin().thenLoop("idle")) : PlayState.STOP;
    }

    private PlayState attackingPredicate(AnimationState event) {
        double d1 = this.getX() - this.xOld;
        double d0 = this.getZ() - this.zOld;
        float velocity = (float)Math.sqrt(d1 * d1 + d0 * d0);
        if (this.getAttackAnim(event.getPartialTick()) > 0.0F && !this.swinging) {
            this.swinging = true;
            this.lastSwing = this.level().getGameTime();
        }

        if (this.swinging && this.lastSwing + 7L <= this.level().getGameTime()) {
            this.swinging = false;
        }

        if (this.swinging && event.getController().getAnimationState() == State.STOPPED) {
            event.getController().forceAnimationReset();
            return event.setAndContinue(RawAnimation.begin().thenPlay("attack"));
        } else {
            return PlayState.CONTINUE;
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
        data.add(new AnimationController<>(this, "attacking", 2, this::attackingPredicate));
        data.add(new AnimationController<>(this, "procedure", 2, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
