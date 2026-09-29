package com.morecritters.mod.entity;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.List;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.procedures.BunbugConditionProcedure;
import com.morecritters.mod.procedures.BunbugEntityIsHurtProcedure;
import com.morecritters.mod.procedures.BunbugOnEntityTickUpdateProcedure;
import com.morecritters.mod.procedures.BunbugOnInitialEntitySpawnProcedure;
import com.morecritters.mod.procedures.BunbugRightClickedOnEntity1Procedure;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
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

public class BunbugEntity extends Animal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(BunbugEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(BunbugEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(BunbugEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Integer> DATA_icing = SynchedEntityData.defineId(BunbugEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_sprinkles = SynchedEntityData.defineId(BunbugEntity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> DATA_berries = SynchedEntityData.defineId(BunbugEntity.class, EntityDataSerializers.INT);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public BunbugEntity(EntityType<BunbugEntity> type, Level world) {
        super(type, world);
        this.xpReward = 2;
        this.setNoAi(false);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "bunbug_0_0_0");
        builder.define(DATA_icing, 0);
        builder.define(DATA_sprinkles, 0);
        builder.define(DATA_berries, 0);
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
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0) {
            @Override
            public boolean canUse() {
                double x = BunbugEntity.this.getX();
                double y = BunbugEntity.this.getY();
                double z = BunbugEntity.this.getZ();
                Entity entity = BunbugEntity.this;
                Level world = BunbugEntity.this.level();
                return super.canUse() && BunbugConditionProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BunbugEntity.this.getX();
                double y = BunbugEntity.this.getY();
                double z = BunbugEntity.this.getZ();
                Entity entity = BunbugEntity.this;
                Level world = BunbugEntity.this.level();
                return super.canContinueToUse() && BunbugConditionProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(3, new PanicGoal(this, 1.2) {
            @Override
            public boolean canUse() {
                double x = BunbugEntity.this.getX();
                double y = BunbugEntity.this.getY();
                double z = BunbugEntity.this.getZ();
                Entity entity = BunbugEntity.this;
                Level world = BunbugEntity.this.level();
                return super.canUse() && BunbugConditionProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BunbugEntity.this.getX();
                double y = BunbugEntity.this.getY();
                double z = BunbugEntity.this.getZ();
                Entity entity = BunbugEntity.this;
                Level world = BunbugEntity.this.level();
                return super.canContinueToUse() && BunbugConditionProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.0, Ingredient.of(Blocks.DEAD_BUSH.asItem()), false));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this) {
            @Override
            public boolean canUse() {
                double x = BunbugEntity.this.getX();
                double y = BunbugEntity.this.getY();
                double z = BunbugEntity.this.getZ();
                Entity entity = BunbugEntity.this;
                Level world = BunbugEntity.this.level();
                return super.canUse() && BunbugConditionProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = BunbugEntity.this.getX();
                double y = BunbugEntity.this.getY();
                double z = BunbugEntity.this.getZ();
                Entity entity = BunbugEntity.this;
                Level world = BunbugEntity.this.level();
                return super.canContinueToUse() && BunbugConditionProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(6, new FloatGoal(this));
    }


    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.step")), 0.15F, 1.0F);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.bunbug.death"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        BunbugEntityIsHurtProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        return super.hurt(source, amount);
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        BunbugOnInitialEntitySpawnProcedure.execute(this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
        compound.putInt("Dataicing", this.entityData.get(DATA_icing));
        compound.putInt("Datasprinkles", this.entityData.get(DATA_sprinkles));
        compound.putInt("Databerries", this.entityData.get(DATA_berries));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture")) {
            this.setTexture(compound.getString("Texture"));
        }

        if (compound.contains("Dataicing")) {
            this.entityData.set(DATA_icing, compound.getInt("Dataicing"));
        }

        if (compound.contains("Datasprinkles")) {
            this.entityData.set(DATA_sprinkles, compound.getInt("Datasprinkles"));
        }

        if (compound.contains("Databerries")) {
            this.entityData.set(DATA_berries, compound.getInt("Databerries"));
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
        BunbugRightClickedOnEntity1Procedure.execute(world, x, y, z, entity, sourceentity);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        BunbugOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        return super.getDefaultDimensions(p_33597_).scale(1.2F);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        BunbugEntity retval = MoreCrittersModEntities.BUNBUG.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return List.of(Blocks.DEAD_BUSH.asItem()).contains(stack.getItem());
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.updateSwingTime();
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(
            MoreCrittersModEntities.BUNBUG.get(),
            SpawnPlacementTypes.NO_RESTRICTIONS,
            Types.MOTION_BLOCKING_NO_LEAVES,
            Mob::checkMobSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }

    public static Builder createAttributes() {
        Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 7.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder.add(Attributes.FOLLOW_RANGE, 16.0);
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
        data.add(new AnimationController<>(this, "movement", 2, this::movementPredicate));
        data.add(new AnimationController<>(this, "procedure", 2, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
