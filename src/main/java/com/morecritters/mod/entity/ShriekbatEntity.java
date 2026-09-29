package com.morecritters.mod.entity;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.procedures.ShriekbatEntityIsHurtProcedure;
import com.morecritters.mod.procedures.ShriekbatNaturalEntitySpawningConditionProcedure;
import com.morecritters.mod.procedures.ShriekbatOnEntityTickUpdatenewProcedure;
import com.morecritters.mod.procedures.ShriekbatOnInitialEntitySpawnProcedure;
import com.morecritters.mod.procedures.ShriekbatlookconditionProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
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
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.animation.AnimationController.State;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ShriekbatEntity extends Monster implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(ShriekbatEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(ShriekbatEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(ShriekbatEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Boolean> DATA_agro = SynchedEntityData.defineId(ShriekbatEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public ShriekbatEntity(EntityType<ShriekbatEntity> type, Level world) {
        super(type, world);
        this.xpReward = 2;
        this.setNoAi(false);
        this.moveControl = new FlyingMoveControl(this, 10, true);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "shriekbat");
        builder.define(DATA_agro, false);
    }

    public void setTexture(String texture) {
        this.entityData.set(TEXTURE, texture);
    }

    public String getTexture() {
        return this.entityData.get(TEXTURE);
    }


    @Override
    protected PathNavigation createNavigation(Level world) {
        return new FlyingPathNavigation(this, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.8, 20) {
            @Override
            protected Vec3 getPosition() {
                RandomSource random = ShriekbatEntity.this.getRandom();
                double dir_x = ShriekbatEntity.this.getX() + (random.nextFloat() * 2.0F - 1.0F) * 16.0F;
                double dir_y = ShriekbatEntity.this.getY() + (random.nextFloat() * 2.0F - 1.0F) * 16.0F;
                double dir_z = ShriekbatEntity.this.getZ() + (random.nextFloat() * 2.0F - 1.0F) * 16.0F;
                return new Vec3(dir_x, dir_y, dir_z);
            }

            @Override
            public boolean canUse() {
                double x = ShriekbatEntity.this.getX();
                double y = ShriekbatEntity.this.getY();
                double z = ShriekbatEntity.this.getZ();
                Entity entity = ShriekbatEntity.this;
                Level world = ShriekbatEntity.this.level();
                return super.canUse() && ShriekbatlookconditionProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = ShriekbatEntity.this.getX();
                double y = ShriekbatEntity.this.getY();
                double z = ShriekbatEntity.this.getZ();
                Entity entity = ShriekbatEntity.this;
                Level world = ShriekbatEntity.this.level();
                return super.canContinueToUse() && ShriekbatlookconditionProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this) {
            @Override
            public boolean canUse() {
                double x = ShriekbatEntity.this.getX();
                double y = ShriekbatEntity.this.getY();
                double z = ShriekbatEntity.this.getZ();
                Entity entity = ShriekbatEntity.this;
                Level world = ShriekbatEntity.this.level();
                return super.canUse() && ShriekbatlookconditionProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = ShriekbatEntity.this.getX();
                double y = ShriekbatEntity.this.getY();
                double z = ShriekbatEntity.this.getZ();
                Entity entity = ShriekbatEntity.this;
                Level world = ShriekbatEntity.this.level();
                return super.canContinueToUse() && ShriekbatlookconditionProcedure.execute(entity);
            }
        });
    }


    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.idle"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.shriekbat.death"));
    }

    @Override
    public boolean causeFallDamage(float l, float d, DamageSource source) {
        return false;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        ShriekbatEntityIsHurtProcedure.execute(source.getEntity());
        return source.is(DamageTypes.FALL) ? false : super.hurt(source, amount);
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        ShriekbatOnInitialEntitySpawnProcedure.execute(this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
        compound.putBoolean("Dataagro", this.entityData.get(DATA_agro));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Texture")) {
            this.setTexture(compound.getString("Texture"));
        }

        if (compound.contains("Dataagro")) {
            this.entityData.set(DATA_agro, compound.getBoolean("Dataagro"));
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        ShriekbatOnEntityTickUpdatenewProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        return super.getDefaultDimensions(p_33597_).scale(1.0F);
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    public void setNoGravity(boolean ignored) {
        super.setNoGravity(true);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(
            MoreCrittersModEntities.SHRIEKBAT.get(),
            SpawnPlacementTypes.ON_GROUND,
            Types.MOTION_BLOCKING_NO_LEAVES,
            (entityType, world, reason, pos, random) -> {
                int x = pos.getX();
                int y = pos.getY();
                int z = pos.getZ();
                return ShriekbatNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
            },
            RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }

    public static Builder createAttributes() {
        Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 6.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16.0);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder.add(Attributes.FLYING_SPEED, 0.3);
    }

    private PlayState movementPredicate(AnimationState event) {
        return this.animationprocedure.equals("empty") ? event.setAndContinue(RawAnimation.begin().thenLoop("fly")) : PlayState.STOP;
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
