package com.morecritters.mod.entity;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.List;
import javax.annotation.Nullable;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.procedures.KelpireEntityVisualScaleProcedure;
import com.morecritters.mod.procedures.KelpireNotSittingProcedure;
import com.morecritters.mod.procedures.KelpireNotSittingTwoProcedure;
import com.morecritters.mod.procedures.KelpireOnEntityTickUpdateProcedure;
import com.morecritters.mod.procedures.KelpireOnInitialEntitySpawnProcedure;
import com.morecritters.mod.procedures.KelpireRightClickedOnEntityProcedure;
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
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.neoforge.common.NeoForgeMod;
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

public class KelpireEntity extends TamableAnimal implements GeoEntity {
    public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(KelpireEntity.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(KelpireEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(KelpireEntity.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Boolean> DATA_sit = SynchedEntityData.defineId(KelpireEntity.class, EntityDataSerializers.BOOLEAN);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    public String animationprocedure = "empty";
    String prevAnim = "empty";


    public KelpireEntity(EntityType<KelpireEntity> type, Level world) {
        super(type, world);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.moveControl = new MoveControl(this) {
            @Override
            public void tick() {
                if (KelpireEntity.this.isInWater()) {
                    KelpireEntity.this.setDeltaMovement(KelpireEntity.this.getDeltaMovement().add(0.0, 0.005, 0.0));
                }

                if (this.operation == Operation.MOVE_TO && !KelpireEntity.this.getNavigation().isDone()) {
                    double dx = this.wantedX - KelpireEntity.this.getX();
                    double dy = this.wantedY - KelpireEntity.this.getY();
                    double dz = this.wantedZ - KelpireEntity.this.getZ();
                    float f = (float)(Mth.atan2(dz, dx) * 57.29577951308232) - 90.0F;
                    float f1 = (float)(this.speedModifier * KelpireEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                    KelpireEntity.this.setYRot(this.rotlerp(KelpireEntity.this.getYRot(), f, 10.0F));
                    KelpireEntity.this.yBodyRot = KelpireEntity.this.getYRot();
                    KelpireEntity.this.yHeadRot = KelpireEntity.this.getYRot();
                    if (KelpireEntity.this.isInWater()) {
                        KelpireEntity.this.setSpeed((float)KelpireEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                        float f2 = -((float)(Mth.atan2(dy, (float)Math.sqrt(dx * dx + dz * dz)) * 57.29577951308232));
                        f2 = Mth.clamp(Mth.wrapDegrees(f2), -85.0F, 85.0F);
                        KelpireEntity.this.setXRot(this.rotlerp(KelpireEntity.this.getXRot(), f2, 5.0F));
                        float f3 = Mth.cos(KelpireEntity.this.getXRot() * 0.017453292F);
                        KelpireEntity.this.setZza(f3 * f1);
                        KelpireEntity.this.setYya((float)(f1 * dy));
                    } else {
                        KelpireEntity.this.setSpeed(f1 * 0.05F);
                    }
                } else {
                    KelpireEntity.this.setSpeed(0.0F);
                    KelpireEntity.this.setYya(0.0F);
                    KelpireEntity.this.setZza(0.0F);
                }
            }
        };
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(SHOOT, false);
        builder.define(ANIMATION, "undefined");
        builder.define(TEXTURE, "kelpire");
        builder.define(DATA_sit, false);
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

            @Override
            public boolean canUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canUse() && KelpireNotSittingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canContinueToUse() && KelpireNotSittingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1.0, 40) {
            @Override
            public boolean canUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canUse() && KelpireNotSittingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canContinueToUse() && KelpireNotSittingProcedure.execute(entity);
            }
        });
        this.targetSelector.addGoal(3, new OwnerHurtTargetGoal(this) {
            @Override
            public boolean canUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canUse() && KelpireNotSittingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canContinueToUse() && KelpireNotSittingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(4, new OwnerHurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canUse() && KelpireNotSittingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canContinueToUse() && KelpireNotSittingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(5, new BreedGoal(this, 1.0) {
            @Override
            public boolean canUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canUse() && KelpireNotSittingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canContinueToUse() && KelpireNotSittingProcedure.execute(entity);
            }
        });
        this.targetSelector.addGoal(6, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(7, new TemptGoal(this, 1.0, Ingredient.of(MoreCrittersModItems.RAW_BLUBBERFISH.get()), false) {
            @Override
            public boolean canUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canUse() && KelpireNotSittingTwoProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canContinueToUse() && KelpireNotSittingTwoProcedure.execute(entity);
            }
        });
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, BlubberfishEntity.class, false, false) {
            @Override
            public boolean canUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canUse() && KelpireNotSittingProcedure.execute(entity);
            }

            @Override
            public boolean canContinueToUse() {
                double x = KelpireEntity.this.getX();
                double y = KelpireEntity.this.getY();
                double z = KelpireEntity.this.getZ();
                Entity entity = KelpireEntity.this;
                Level world = KelpireEntity.this.level();
                return super.canContinueToUse() && KelpireNotSittingProcedure.execute(entity);
            }
        });
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
    }


    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.kelpire.idle"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.kelpire.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("more_critters:entity.kelpire.death"));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        return source.is(DamageTypes.DROWN) ? false : super.hurt(source, amount);
    }

    @Override
    public SpawnGroupData finalizeSpawn(
        ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata
    ) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
        KelpireOnInitialEntitySpawnProcedure.execute(this);
        return retval;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("Texture", this.getTexture());
        compound.putBoolean("Datasit", this.entityData.get(DATA_sit));
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
        KelpireRightClickedOnEntityProcedure.execute(entity, sourceentity);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        KelpireOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        this.refreshDimensions();
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose p_33597_) {
        Entity entity = this;
        Level world = this.level();
        double x = this.getX();
        double y = entity.getY();
        double z = entity.getZ();
        return super.getDefaultDimensions(p_33597_).scale((float)KelpireEntityVisualScaleProcedure.execute(entity));
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
        KelpireEntity retval = MoreCrittersModEntities.KELPIRE.get().create(serverWorld);
        retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null);
        return retval;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return List.of(MoreCrittersModItems.RAW_BLUBBERFISH.get()).contains(stack.getItem());
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
            MoreCrittersModEntities.KELPIRE.get(),
            SpawnPlacementTypes.IN_WATER,
            Types.MOTION_BLOCKING_NO_LEAVES,
            (entityType, world, reason, pos, random) -> world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER),
            RegisterSpawnPlacementsEvent.Operation.REPLACE
        );
    }

    public static Builder createAttributes() {
        Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 2.0);
        builder = builder.add(Attributes.MAX_HEALTH, 50.0);
        builder = builder.add(Attributes.ARMOR, 0.0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 7.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 32.0);
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
        data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
        data.add(new AnimationController<>(this, "attacking", 4, this::attackingPredicate));
        data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
