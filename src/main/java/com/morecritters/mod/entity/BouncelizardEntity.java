package com.morecritters.mod.entity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.List;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.procedures.BouncelizardHitboxSizeProcedure;
import com.morecritters.mod.procedures.BouncelizardRightClickedOnEntity1Procedure;
import com.morecritters.mod.procedures.NotSneakingProcedure;
import com.morecritters.mod.procedures.SlablizardOnEntityTickUpdateProcedure;
import com.morecritters.mod.procedures.SlablizardOnInitialEntitySpawnProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
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

public class BouncelizardEntity extends Animal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(BouncelizardEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(BouncelizardEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(BouncelizardEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Boolean> DATA_sleeping = SynchedEntityData.defineId(BouncelizardEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> DATA_fromegg = SynchedEntityData.defineId(BouncelizardEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public BouncelizardEntity(EntityType<BouncelizardEntity> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "bouncelizard0");
        builder.define(DATA_sleeping, false);
        builder.define(DATA_fromegg, false);
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
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0) {
            @Override
            public boolean canUse() {
                double x = BouncelizardEntity.this.getX();
                double y = BouncelizardEntity.this.getY();
                double z = BouncelizardEntity.this.getZ();
                Entity entity = BouncelizardEntity.this;
                Level world = BouncelizardEntity.this.level();
                return super.canUse() && NotSneakingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BouncelizardEntity.this.getX();
                double y = BouncelizardEntity.this.getY();
                double z = BouncelizardEntity.this.getZ();
                Entity entity = BouncelizardEntity.this;
                Level world = BouncelizardEntity.this.level();
                return super.canContinueToUse() && NotSneakingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.0, Ingredient.of(Items.SPIDER_EYE), false) {
            @Override
            public boolean canUse() {
                double x = BouncelizardEntity.this.getX();
                double y = BouncelizardEntity.this.getY();
                double z = BouncelizardEntity.this.getZ();
                Entity entity = BouncelizardEntity.this;
                Level world = BouncelizardEntity.this.level();
                return super.canUse() && NotSneakingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BouncelizardEntity.this.getX();
                double y = BouncelizardEntity.this.getY();
                double z = BouncelizardEntity.this.getZ();
                Entity entity = BouncelizardEntity.this;
                Level world = BouncelizardEntity.this.level();
                return super.canContinueToUse() && NotSneakingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1.0) {
            @Override
            public boolean canUse() {
                double x = BouncelizardEntity.this.getX();
                double y = BouncelizardEntity.this.getY();
                double z = BouncelizardEntity.this.getZ();
                Entity entity = BouncelizardEntity.this;
                Level world = BouncelizardEntity.this.level();
                return super.canUse() && NotSneakingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BouncelizardEntity.this.getX();
                double y = BouncelizardEntity.this.getY();
                double z = BouncelizardEntity.this.getZ();
                Entity entity = BouncelizardEntity.this;
                Level world = BouncelizardEntity.this.level();
                return super.canContinueToUse() && NotSneakingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this) {
            @Override
            public boolean canUse() {
                double x = BouncelizardEntity.this.getX();
                double y = BouncelizardEntity.this.getY();
                double z = BouncelizardEntity.this.getZ();
                Entity entity = BouncelizardEntity.this;
                Level world = BouncelizardEntity.this.level();
                return super.canUse() && NotSneakingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BouncelizardEntity.this.getX();
                double y = BouncelizardEntity.this.getY();
                double z = BouncelizardEntity.this.getZ();
                Entity entity = BouncelizardEntity.this;
                Level world = BouncelizardEntity.this.level();
                return super.canContinueToUse() && NotSneakingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(5, new FloatGoal(this));
    }


    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions dimensions, float partialTick) {
        // 1.20.1 seated riders at 0.75 * height + offset; players then sat 0.35 lower, now 0.6
        return new Vec3(0.0, dimensions.height() * 0.75 + -0.1 + (entity instanceof Player ? 0.25 : 0.0), 0.0);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bouncelizard.death"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return source.is(DamageTypes.FALL) ? false : super.hurt(source, amount);
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        SlablizardOnInitialEntitySpawnProcedure.execute(this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
        compound.putBoolean("Datasleeping", this.entityData.get(DATA_sleeping));
        compound.putBoolean("Datafromegg", this.entityData.get(DATA_fromegg));
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

        if (compound.contains("Datafromegg")) {
            this.entityData.set(DATA_fromegg, compound.getBoolean("Datafromegg"));
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
        BouncelizardRightClickedOnEntity1Procedure.execute(world, x, y, z, entity, sourceentity);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        SlablizardOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        Entity entity = this;
        Level world = this.level();
        double x = this.getX();
        double y = entity.getY();
        double z = entity.getZ();
        return super.getDefaultDimensions(p_33597_).scale((float)BouncelizardHitboxSizeProcedure.execute(entity));
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        BouncelizardEntity retval = MoreCrittersModEntities.BOUNCELIZARD.get().create(serverWorld);
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
            MoreCrittersModEntities.BOUNCELIZARD.get(),
            SpawnPlacementTypes.ON_GROUND,
            Types.MOTION_BLOCKING_NO_LEAVES,
            (entityType, world, reason, pos, random) -> world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON)
                && world.getRawBrightness(pos, 0) > 8,
            RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }

    public static Builder createAttributes() {
        Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
        builder = builder.add(Attributes.MAX_HEALTH, 10.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 0.0);
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
        data.add(new AnimationController<>(this, "movement", 0, this::movementPredicate));
        data.add(new AnimationController<>(this, "procedure", 0, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
