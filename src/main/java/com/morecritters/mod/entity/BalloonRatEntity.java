package com.morecritters.mod.entity;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.List;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.procedures.BalloonRatEntityDiesProcedure;
import com.morecritters.mod.procedures.BalloonRatEntityIsHurtProcedure;
import com.morecritters.mod.procedures.BalloonRatMedicSGSGProcedure;
import com.morecritters.mod.procedures.BalloonRatNotSittingProcedure;
import com.morecritters.mod.procedures.BalloonRatOnEntityTickUpdateProcedure;
import com.morecritters.mod.procedures.BalloonRatOnInitialEntitySpawnProcedure;
import com.morecritters.mod.procedures.BalloonRatRightClickedOnEntityProcedure;
import com.morecritters.mod.procedures.BalloonRatSizeProcedure;
import com.morecritters.mod.procedures.DasfdsfdafadProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.neoforged.neoforge.event.EventHooks;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.animation.AnimationController.State;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class BalloonRatEntity extends TamableAnimal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Boolean> DATA_sit = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> DATA_variant = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> DATA_has_stagnation = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> DATA_has_muscle_ache = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> DATA_has_brittleness = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> DATA_has_hallucinazium = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> DATA_has_asphyxiation = SynchedEntityData.defineId(BalloonRatEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public BalloonRatEntity(EntityType<BalloonRatEntity> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "balloon_rat");
        builder.define(DATA_sit, false);
        builder.define(DATA_variant, 0);
        builder.define(DATA_has_stagnation, false);
        builder.define(DATA_has_muscle_ache, false);
        builder.define(DATA_has_brittleness, false);
        builder.define(DATA_has_hallucinazium, false);
        builder.define(DATA_has_asphyxiation, false);
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
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
            @Override
            protected boolean canPerformAttack(LivingEntity entity) {
                return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (4.0) && this.mob.getSensing().hasLineOfSight(entity);
            }

            @Override
            public boolean canUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canUse() && BalloonRatMedicSGSGProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canContinueToUse() && BalloonRatMedicSGSGProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0) {
            @Override
            public boolean canUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canUse() && BalloonRatNotSittingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canContinueToUse() && BalloonRatNotSittingProcedure.execute(entity);
            }
        });
        this.targetSelector.addGoal(3, new OwnerHurtTargetGoal(this) {
            @Override
            public boolean canUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canUse() && BalloonRatMedicSGSGProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canContinueToUse() && BalloonRatMedicSGSGProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(4, new OwnerHurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canUse() && BalloonRatMedicSGSGProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canContinueToUse() && BalloonRatMedicSGSGProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.0, 5.0F, 2.0F) {
            @Override
            public boolean canUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canUse() && DasfdsfdafadProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canContinueToUse() && DasfdsfdafadProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(6, new PanicGoal(this, 1.6) {
            @Override
            public boolean canUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canUse() && BalloonRatNotSittingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canContinueToUse() && BalloonRatNotSittingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0) {
            @Override
            public boolean canUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canUse() && BalloonRatNotSittingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BalloonRatEntity.this.getX();
                double y = BalloonRatEntity.this.getY();
                double z = BalloonRatEntity.this.getZ();
                Entity entity = BalloonRatEntity.this;
                Level world = BalloonRatEntity.this.level();
                return super.canContinueToUse() && BalloonRatNotSittingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(9, new FloatGoal(this));
    }


    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.idle"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.balloon_rat.death"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        BalloonRatEntityIsHurtProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this, source.getEntity());
        return super.hurt(source, amount);
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        BalloonRatEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        BalloonRatOnInitialEntitySpawnProcedure.execute(this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
        compound.putBoolean("Datasit", this.entityData.get(DATA_sit));
        compound.putInt("Datavariant", this.entityData.get(DATA_variant));
        compound.putBoolean("Datahas_stagnation", this.entityData.get(DATA_has_stagnation));
        compound.putBoolean("Datahas_muscle_ache", this.entityData.get(DATA_has_muscle_ache));
        compound.putBoolean("Datahas_brittleness", this.entityData.get(DATA_has_brittleness));
        compound.putBoolean("Datahas_hallucinazium", this.entityData.get(DATA_has_hallucinazium));
        compound.putBoolean("Datahas_asphyxiation", this.entityData.get(DATA_has_asphyxiation));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture")) {
            this.setTexture(compound.getString("Texture"));
        }

        if (compound.contains("Datasit")) {
            this.entityData.set(DATA_sit, compound.getBoolean("Datasit"));
        }

        if (compound.contains("Datavariant")) {
            this.entityData.set(DATA_variant, compound.getInt("Datavariant"));
        }

        if (compound.contains("Datahas_stagnation")) {
            this.entityData.set(DATA_has_stagnation, compound.getBoolean("Datahas_stagnation"));
        }

        if (compound.contains("Datahas_muscle_ache")) {
            this.entityData.set(DATA_has_muscle_ache, compound.getBoolean("Datahas_muscle_ache"));
        }

        if (compound.contains("Datahas_brittleness")) {
            this.entityData.set(DATA_has_brittleness, compound.getBoolean("Datahas_brittleness"));
        }

        if (compound.contains("Datahas_hallucinazium")) {
            this.entityData.set(DATA_has_hallucinazium, compound.getBoolean("Datahas_hallucinazium"));
        }

        if (compound.contains("Datahas_asphyxiation")) {
            this.entityData.set(DATA_has_asphyxiation, compound.getBoolean("Datahas_asphyxiation"));
        }
    }

    @Override
    public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
        ItemStack itemstack = sourceentity.getItemInHand(hand);
        InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        Item item = itemstack.getItem();
        if (itemstack.getItem() instanceof SpawnEggItem) {
            retval = super.mobInteract(sourceentity, hand);
        } else if (this.level().isClientSide()) {
            retval = (!this.isTame() || !this.isOwnedBy(sourceentity)) && !this.isFood(itemstack)
                ? InteractionResult.PASS
                : InteractionResult.sidedSuccess(this.level().isClientSide());
        } else if (this.isTame()) {
            if (this.isOwnedBy(sourceentity)) {
                if (itemstack.getFoodProperties(this) != null && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    this.usePlayerItem(sourceentity, hand, itemstack);
                    this.heal(itemstack.getFoodProperties(this).nutrition());
                    retval = InteractionResult.sidedSuccess(this.level().isClientSide());
                } else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    this.usePlayerItem(sourceentity, hand, itemstack);
                    this.heal(4.0F);
                    retval = InteractionResult.sidedSuccess(this.level().isClientSide());
                } else {
                    retval = super.mobInteract(sourceentity, hand);
                }
            }
        } else if (this.isFood(itemstack)) {
            this.usePlayerItem(sourceentity, hand, itemstack);
            if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
                this.tame(sourceentity);
                this.level().broadcastEntityEvent(this, (byte)7);
            } else {
                this.level().broadcastEntityEvent(this, (byte)6);
            }

            this.setPersistenceRequired();
            retval = InteractionResult.sidedSuccess(this.level().isClientSide());
        } else {
            retval = super.mobInteract(sourceentity, hand);
            if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME) {
                this.setPersistenceRequired();
            }
        }

        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Entity entity = this;
        Level world = this.level();
        BalloonRatRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        BalloonRatOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        Entity entity = this;
        Level world = this.level();
        double x = this.getX();
        double y = entity.getY();
        double z = entity.getZ();
        return super.getDefaultDimensions(p_33597_).scale((float)BalloonRatSizeProcedure.execute(entity));
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        BalloonRatEntity retval = MoreCrittersModEntities.BALLOON_RAT.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return List.of(Items.SPIDER_EYE).contains(stack.getItem());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(
            MoreCrittersModEntities.BALLOON_RAT.get(),
            SpawnPlacementTypes.NO_RESTRICTIONS,
            Types.MOTION_BLOCKING_NO_LEAVES,
            Mob::checkMobSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }

    public static Builder createAttributes() {
        Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
        builder = builder.add(Attributes.MAX_HEALTH, 25.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder.add(Attributes.FOLLOW_RANGE, 64.0);
    }

    private PlayState movementPredicate(AnimationState event) {
        if (this.animationprocedure.equals("empty")) {
            return !event.isMoving() && event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F
                ? event.setAndContinue(RawAnimation.begin().thenLoop("idle"))
                : event.setAndContinue(RawAnimation.begin().thenLoop("walk"));
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
        data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
        data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
