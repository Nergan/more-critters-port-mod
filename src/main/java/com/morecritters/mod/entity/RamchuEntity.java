package com.morecritters.mod.entity;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.List;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.procedures.RamchuAttackConditionProcedure;
import com.morecritters.mod.procedures.RamchuEntityIsHurtProcedure;
import com.morecritters.mod.procedures.RamchuNaturalSpawnConditionProcedure;
import com.morecritters.mod.procedures.RamchuOnEntityTickUpdateProcedure;
import com.morecritters.mod.procedures.RamchuOnInitialEntitySpawnProcedure;
import com.morecritters.mod.procedures.RamchuRightClickedOnEntityProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
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

public class RamchuEntity extends Animal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(RamchuEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(RamchuEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(RamchuEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Integer> DATA_state = SynchedEntityData.defineId(RamchuEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> DATA_ramming = SynchedEntityData.defineId(RamchuEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public RamchuEntity(EntityType<RamchuEntity> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.moveControl = new MoveControl(this) {
            @Override
            public void tick() {
                if (RamchuEntity.this.isInWater()) {
                    RamchuEntity.this.setDeltaMovement(RamchuEntity.this.getDeltaMovement().add(0.0, 0.005, 0.0));
                }

                if (this.operation == Operation.MOVE_TO && !RamchuEntity.this.getNavigation().isDone()) {
                    double dx = this.wantedX - RamchuEntity.this.getX();
                    double dy = this.wantedY - RamchuEntity.this.getY();
                    double dz = this.wantedZ - RamchuEntity.this.getZ();
                    float f = (float)(Mth.atan2(dz, dx) * 57.29577951308232) - 90.0F;
                    float f1 = (float)(this.speedModifier * RamchuEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                    RamchuEntity.this.setYRot(this.rotlerp(RamchuEntity.this.getYRot(), f, 10.0F));
                    RamchuEntity.this.yBodyRot = RamchuEntity.this.getYRot();
                    RamchuEntity.this.yHeadRot = RamchuEntity.this.getYRot();
                    if (RamchuEntity.this.isInWater()) {
                        RamchuEntity.this.setSpeed((float)RamchuEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                        float f2 = -((float)(Mth.atan2(dy, (float)Math.sqrt(dx * dx + dz * dz)) * 57.29577951308232));
                        f2 = Mth.clamp(Mth.wrapDegrees(f2), -85.0F, 85.0F);
                        RamchuEntity.this.setXRot(this.rotlerp(RamchuEntity.this.getXRot(), f2, 5.0F));
                        float f3 = Mth.cos(RamchuEntity.this.getXRot() * 0.017453292F);
                        RamchuEntity.this.setZza(f3 * f1);
                        RamchuEntity.this.setYya((float)(f1 * dy));
                    } else {
                        RamchuEntity.this.setSpeed(f1 * 0.05F);
                    }
                } else {
                    RamchuEntity.this.setSpeed(0.0F);
                    RamchuEntity.this.setYya(0.0F);
                    RamchuEntity.this.setZza(0.0F);
                }
            }
        };
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "ramchu");
        builder.define(DATA_state, 0);
        builder.define(DATA_ramming, false);
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
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.0, Ingredient.of(Blocks.GLOW_LICHEN.asItem()), false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false) {
            @Override
            public boolean canUse() {
                double x = RamchuEntity.this.getX();
                double y = RamchuEntity.this.getY();
                double z = RamchuEntity.this.getZ();
                Entity entity = RamchuEntity.this;
                Level world = RamchuEntity.this.level();
                return super.canUse() && RamchuAttackConditionProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = RamchuEntity.this.getX();
                double y = RamchuEntity.this.getY();
                double z = RamchuEntity.this.getZ();
                Entity entity = RamchuEntity.this;
                Level world = RamchuEntity.this.level();
                return super.canContinueToUse() && RamchuAttackConditionProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 100.0, false) {
            @Override
            protected boolean canPerformAttack(LivingEntity entity) {
                return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
            }

            @Override
            public boolean canUse() {
                double x = RamchuEntity.this.getX();
                double y = RamchuEntity.this.getY();
                double z = RamchuEntity.this.getZ();
                Entity entity = RamchuEntity.this;
                Level world = RamchuEntity.this.level();
                return super.canUse() && RamchuAttackConditionProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = RamchuEntity.this.getX();
                double y = RamchuEntity.this.getY();
                double z = RamchuEntity.this.getZ();
                Entity entity = RamchuEntity.this;
                Level world = RamchuEntity.this.level();
                return super.canContinueToUse() && RamchuAttackConditionProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(5, new RandomSwimmingGoal(this, 8.0, 40));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }


    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ramchu.idle"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ramchu.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.ramchu.hurt"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        RamchuEntityIsHurtProcedure.execute(this);
        return source.is(DamageTypes.DROWN) ? false : super.hurt(source, amount);
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        RamchuOnInitialEntitySpawnProcedure.execute(this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
        compound.putInt("Datastate", this.entityData.get(DATA_state));
        compound.putBoolean("Dataramming", this.entityData.get(DATA_ramming));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture")) {
            this.setTexture(compound.getString("Texture"));
        }

        if (compound.contains("Datastate")) {
            this.entityData.set(DATA_state, compound.getInt("Datastate"));
        }

        if (compound.contains("Dataramming")) {
            this.entityData.set(DATA_ramming, compound.getBoolean("Dataramming"));
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
        RamchuRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        RamchuOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        return super.getDefaultDimensions(p_33597_).scale(1.0F);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        RamchuEntity retval = MoreCrittersModEntities.RAMCHU.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return List.of(Blocks.GLOW_LICHEN.asItem()).contains(stack.getItem());
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
        event.register(
            MoreCrittersModEntities.RAMCHU.get(),
            SpawnPlacementTypes.IN_WATER,
            Types.MOTION_BLOCKING_NO_LEAVES,
            (entityType, world, reason, pos, random) -> {
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();
                return RamchuNaturalSpawnConditionProcedure.execute(world, x, y, z);
            },
            RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }

    public static Builder createAttributes() {
        Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 2.0);
        builder = builder.add(Attributes.MAX_HEALTH, 20.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 32.0);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.4);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder.add(NeoForgeMod.SWIM_SPEED, 2.0);
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            return !event.isMoving() && event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F
                ? event.setAndContinue(RawAnimation.begin().thenLoop("idle"))
                : event.setAndContinue(RawAnimation.begin().thenLoop("swim"));
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
        data.add(new AnimationController<>(this, "movement", 2, this::movementPredicate));
        data.add(new AnimationController<>(this, "procedure", 2, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
