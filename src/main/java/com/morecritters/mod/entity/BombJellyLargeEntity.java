package com.morecritters.mod.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.procedures.BombJellyLargePickProcedure;
import com.morecritters.mod.procedures.BombJellyLargeTickProcedure;
import com.morecritters.mod.procedures.BombJellySmallOnInitialEntitySpawnProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
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

public class BombJellyLargeEntity extends PathfinderMob implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(BombJellyLargeEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(BombJellyLargeEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(BombJellyLargeEntity.class, EntityDataSerializers.STRING);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public BombJellyLargeEntity(EntityType<BombJellyLargeEntity> type, Level world) {
        super(type, world);
        this.xpReward = 3;
        this.setNoAi(false);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.moveControl = new MoveControl(this) {
            @Override
            public void tick() {
                if (BombJellyLargeEntity.this.isInWater()) {
                    BombJellyLargeEntity.this.setDeltaMovement(BombJellyLargeEntity.this.getDeltaMovement().add(0.0, 0.005, 0.0));
                }

                if (this.operation == Operation.MOVE_TO && !BombJellyLargeEntity.this.getNavigation().isDone()) {
                    double dx = this.wantedX - BombJellyLargeEntity.this.getX();
                    double dy = this.wantedY - BombJellyLargeEntity.this.getY();
                    double dz = this.wantedZ - BombJellyLargeEntity.this.getZ();
                    float f = (float)(Mth.atan2(dz, dx) * 57.29577951308232) - 90.0F;
                    float f1 = (float)(this.speedModifier * BombJellyLargeEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                    BombJellyLargeEntity.this.setYRot(this.rotlerp(BombJellyLargeEntity.this.getYRot(), f, 10.0F));
                    BombJellyLargeEntity.this.yBodyRot = BombJellyLargeEntity.this.getYRot();
                    BombJellyLargeEntity.this.yHeadRot = BombJellyLargeEntity.this.getYRot();
                    if (BombJellyLargeEntity.this.isInWater()) {
                        BombJellyLargeEntity.this.setSpeed((float)BombJellyLargeEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                        float f2 = -((float)(Mth.atan2(dy, (float)Math.sqrt(dx * dx + dz * dz)) * 57.29577951308232));
                        f2 = Mth.clamp(Mth.wrapDegrees(f2), -85.0F, 85.0F);
                        BombJellyLargeEntity.this.setXRot(this.rotlerp(BombJellyLargeEntity.this.getXRot(), f2, 5.0F));
                        float f3 = Mth.cos(BombJellyLargeEntity.this.getXRot() * 0.017453292F);
                        BombJellyLargeEntity.this.setZza(f3 * f1);
                        BombJellyLargeEntity.this.setYya((float)(f1 * dy));
                    } else {
                        BombJellyLargeEntity.this.setSpeed(f1 * 0.05F);
                    }
                } else {
                    BombJellyLargeEntity.this.setSpeed(0.0F);
                    BombJellyLargeEntity.this.setYya(0.0F);
                    BombJellyLargeEntity.this.setZza(0.0F);
                }
            }
        };
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "bomb_jelly_large1");
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
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1.0, 40));
    }


    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bomb_jelly.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bomb_jelly.hurt"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.FALL)) {
            return false;
        } else {
            return source.is(DamageTypes.DROWN) ? false : super.hurt(source, amount);
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        BombJellySmallOnInitialEntitySpawnProcedure.execute(this);
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
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        super.mobInteract(sourceentity, hand);
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Entity entity = this;
        Level world = this.level();
        BombJellyLargePickProcedure.execute(world, x, y, z, entity, sourceentity);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        BombJellyLargeTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        return super.getDefaultDimensions(p_33597_).scale(1.0F);
    }


    @Override
    public boolean checkSpawnObstruction(LevelReader world) {
        return world.isUnobstructed(this);
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
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
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 10.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder.add(NeoForgeMod.SWIM_SPEED, 0.3);
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            return this.isInWaterOrBubble()
                ? event.setAndContinue(RawAnimation.begin().thenLoop("idle"))
                : event.setAndContinue(RawAnimation.begin().thenLoop("land"));
        } else {
            return PlayState.STOP;
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
        data.add(new AnimationController<>(this, "procedure", 0, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
