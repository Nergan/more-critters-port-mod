package com.morecritters.mod.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.List;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.procedures.CritterEaterEntityIsHurtProcedure;
import com.morecritters.mod.procedures.CritterEaterOnEntityTickUpdateProcedure;
import com.morecritters.mod.procedures.CritterEaterOnInitialEntitySpawnProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
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
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.animation.AnimationController.State;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class CritterEaterEntity extends Animal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(CritterEaterEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(CritterEaterEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(CritterEaterEntity.class, EntityDataSerializers.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public CritterEaterEntity(EntityType<CritterEaterEntity> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "critter_eater");
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
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.0, false) {
            @Override
            protected boolean canPerformAttack(LivingEntity entity) {
                return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (4.0) && this.mob.getSensing().hasLineOfSight(entity);
            }
        });
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, CubefrogEntity.class, false, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlainswyrmEntity.class, false, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, DungerEntity.class, false, false));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, SnekEntity.class, false, false));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, ExpyEntity.class, false, false));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, ScowlEntity.class, false, false));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal<>(this, RollballEntity.class, false, false));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, OpalcrabEntity.class, false, false));
        this.targetSelector.addGoal(10, new NearestAttackableTargetGoal<>(this, MothkidEntity.class, false, false));
        this.targetSelector.addGoal(11, new NearestAttackableTargetGoal<>(this, GillmunchEntity.class, false, false));
        this.targetSelector.addGoal(12, new NearestAttackableTargetGoal<>(this, StalkEntity.class, false, false));
        this.targetSelector.addGoal(13, new NearestAttackableTargetGoal<>(this, DominicEntity.class, false, false));
        this.targetSelector.addGoal(14, new NearestAttackableTargetGoal<>(this, OlmerEntity.class, false, false));
        this.targetSelector.addGoal(15, new NearestAttackableTargetGoal<>(this, FlargEntity.class, false, false));
        this.targetSelector.addGoal(16, new NearestAttackableTargetGoal<>(this, PiranheedEntity.class, false, false));
        this.targetSelector.addGoal(17, new NearestAttackableTargetGoal<>(this, MangotriceEntity.class, false, false));
        this.targetSelector.addGoal(18, new NearestAttackableTargetGoal<>(this, FresnoidEntity.class, false, false));
        this.targetSelector.addGoal(19, new NearestAttackableTargetGoal<>(this, ShimmerwormEntity.class, false, false));
        this.targetSelector.addGoal(20, new NearestAttackableTargetGoal<>(this, BabyBunbugEntity.class, false, false));
        this.targetSelector.addGoal(21, new NearestAttackableTargetGoal<>(this, BunbugEntity.class, false, false));
        this.targetSelector.addGoal(22, new NearestAttackableTargetGoal<>(this, SnowflakeSpiderEntity.class, false, false));
        this.targetSelector.addGoal(23, new NearestAttackableTargetGoal<>(this, ShriekbatEntity.class, false, false));
        this.targetSelector.addGoal(24, new NearestAttackableTargetGoal<>(this, CreeblossomEntity.class, false, false));
        this.targetSelector.addGoal(25, new NearestAttackableTargetGoal<>(this, BouncelizardEntity.class, false, false));
        this.targetSelector.addGoal(26, new NearestAttackableTargetGoal<>(this, StincarpEntity.class, false, false));
        this.targetSelector.addGoal(27, new NearestAttackableTargetGoal<>(this, BalloonRatEntity.class, false, false));
        this.targetSelector.addGoal(28, new NearestAttackableTargetGoal<>(this, WarptrapEntity.class, false, false));
        this.targetSelector.addGoal(29, new NearestAttackableTargetGoal<>(this, ShimmerwingEntity.class, false, false));
        this.targetSelector.addGoal(30, new NearestAttackableTargetGoal<>(this, CarrybugEntity.class, false, false));
        this.targetSelector.addGoal(31, new NearestAttackableTargetGoal<>(this, FrightshroomEntity.class, false, false));
        this.targetSelector.addGoal(32, new NearestAttackableTargetGoal<>(this, MightshroomEntity.class, false, false));
        this.targetSelector.addGoal(33, new NearestAttackableTargetGoal<>(this, NightshroomEntity.class, false, false));
        this.targetSelector.addGoal(34, new NearestAttackableTargetGoal<>(this, BombJellyLargeEntity.class, false, false));
        this.targetSelector.addGoal(35, new NearestAttackableTargetGoal<>(this, BombJellyMediumEntity.class, false, false));
        this.targetSelector.addGoal(36, new NearestAttackableTargetGoal<>(this, BombJellySmallEntity.class, false, false));
        this.targetSelector.addGoal(37, new NearestAttackableTargetGoal<>(this, AvoiderEntity.class, false, false));
        this.targetSelector.addGoal(38, new NearestAttackableTargetGoal<>(this, AvoiderFryEntity.class, false, false));
        this.targetSelector.addGoal(39, new NearestAttackableTargetGoal<>(this, BlubberfishEntity.class, false, false));
        this.targetSelector.addGoal(40, new NearestAttackableTargetGoal<>(this, BlubberfishFryEntity.class, false, false));
        this.targetSelector.addGoal(41, new NearestAttackableTargetGoal<>(this, IropodEntity.class, false, false));
        this.targetSelector.addGoal(42, new NearestAttackableTargetGoal<>(this, BlackIropodEntity.class, false, false));
        this.targetSelector.addGoal(43, new NearestAttackableTargetGoal<>(this, KelpireEntity.class, false, false));
        this.targetSelector.addGoal(44, new NearestAttackableTargetGoal<>(this, NauticrawlEntity.class, false, false));
        this.targetSelector.addGoal(45, new NearestAttackableTargetGoal<>(this, ZombieNauticrawlEntity.class, false, false));
        this.targetSelector.addGoal(46, new NearestAttackableTargetGoal<>(this, ShadeletEntity.class, false, false));
        this.targetSelector.addGoal(47, new NearestAttackableTargetGoal<>(this, TreepletEntity.class, false, false));
        this.targetSelector.addGoal(48, new NearestAttackableTargetGoal<>(this, TreeplingBottomEntity.class, false, false));
        this.targetSelector.addGoal(49, new NearestAttackableTargetGoal<>(this, TreeplingMiddleEntity.class, false, false));
        this.targetSelector.addGoal(50, new NearestAttackableTargetGoal<>(this, TreeplingTopEntity.class, false, false));
        this.targetSelector.addGoal(51, new NearestAttackableTargetGoal<>(this, NervoidEntity.class, false, false));
        this.targetSelector.addGoal(52, new NearestAttackableTargetGoal<>(this, CorpseCaptainEntity.class, false, false));
        this.targetSelector.addGoal(53, new NearestAttackableTargetGoal<>(this, CorpseMateEntity.class, false, false));
        this.targetSelector.addGoal(54, new NearestAttackableTargetGoal<>(this, CorpseParrotEntity.class, false, false));
        this.targetSelector.addGoal(55, new NearestAttackableTargetGoal<>(this, CorpseQuartermasterEntity.class, false, false));
        this.targetSelector.addGoal(56, new NearestAttackableTargetGoal<>(this, CorpseTankEntity.class, false, false));
        this.targetSelector.addGoal(57, new NearestAttackableTargetGoal<>(this, TamedCorpseParrotEntity.class, false, false));
        this.targetSelector.addGoal(58, new NearestAttackableTargetGoal<>(this, GravediggerEntity.class, false, false));
        this.targetSelector.addGoal(59, new NearestAttackableTargetGoal<>(this, ArmossilloEntity.class, false, false));
        this.targetSelector.addGoal(60, new NearestAttackableTargetGoal<>(this, BabyArmossilloEntity.class, false, false));
        this.targetSelector.addGoal(61, new NearestAttackableTargetGoal<>(this, RamchuEntity.class, false, false));
        this.targetSelector.addGoal(62, new NearestAttackableTargetGoal<>(this, RamchuFryEntity.class, false, false));
        this.targetSelector.addGoal(63, new NearestAttackableTargetGoal<>(this, DripperEntity.class, false, false));
        this.targetSelector.addGoal(64, new NearestAttackableTargetGoal<>(this, CustodianEntity.class, false, false));
        this.goalSelector.addGoal(65, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(66, new FloatGoal(this));
    }


    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.critter_eater.idle"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.critter_eater.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.critter_eater.death"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        CritterEaterEntityIsHurtProcedure.execute(this);
        return super.hurt(source, amount);
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        CritterEaterOnInitialEntitySpawnProcedure.execute(this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture")) {
            this.setTexture(compound.getString("Texture"));
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        CritterEaterOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        return super.getDefaultDimensions(p_33597_).scale(1.0F);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        CritterEaterEntity retval = MoreCrittersModEntities.CRITTER_EATER.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return List.of().contains(stack.getItem());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
    }

    public static Builder createAttributes() {
        Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.0);
        builder = builder.add(Attributes.MAX_HEALTH, 35.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 10.0);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder.add(Attributes.FOLLOW_RANGE, 16.0);
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
        data.add(new AnimationController<>(this, "movement", 0, this::movementPredicate));
        data.add(new AnimationController<>(this, "attacking", 0, this::attackingPredicate));
        data.add(new AnimationController<>(this, "procedure", 0, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
