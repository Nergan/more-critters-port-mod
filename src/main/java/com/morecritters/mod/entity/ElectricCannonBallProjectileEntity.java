package com.morecritters.mod.entity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.BuiltInRegistries;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.procedures.CannonBallProjectileWhileProjectileFlyingTickProcedure;
import com.morecritters.mod.procedures.ElectricCannonBallHitsProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class ElectricCannonBallProjectileEntity extends AbstractArrow implements ItemSupplier {
    private int knockback = 0;

    public void setKnockback(int knockback) {
        this.knockback = knockback;
    }

    @Override
    protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
        super.doKnockback(livingEntity, damageSource);
        if (this.knockback > 0) {
            double resistance = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
            Vec3 push = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(this.knockback * 0.6 * resistance);
            if (push.lengthSqr() > 0.0) {
                livingEntity.push(push.x, 0.1, push.z);
            }
        }
    }

    public static final ItemStack PROJECTILE_ITEM = new ItemStack(MoreCrittersModItems.INFUSED_CANNON_BALL_ELECTRIC.get());


    public ElectricCannonBallProjectileEntity(EntityType<? extends ElectricCannonBallProjectileEntity> type, Level world) {
        super(type, world);
    }

    public ElectricCannonBallProjectileEntity(EntityType<? extends ElectricCannonBallProjectileEntity> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world, PROJECTILE_ITEM, null);
    }

    public ElectricCannonBallProjectileEntity(EntityType<? extends ElectricCannonBallProjectileEntity> type, LivingEntity entity, Level world) {
        super(type, entity, world, PROJECTILE_ITEM, null);
    }


    @OnlyIn(Dist.CLIENT)
    @Override
    public ItemStack getItem() {
        return PROJECTILE_ITEM;
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return PROJECTILE_ITEM;
    }

    @Override
    protected void doPostHurtEffects(LivingEntity entity) {
        super.doPostHurtEffects(entity);
        entity.setArrowCount(entity.getArrowCount() - 1);
    }

    @Override
    public void playerTouch(Player entity) {
        super.playerTouch(entity);
        ElectricCannonBallHitsProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
    }

    @Override
    public void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        ElectricCannonBallHitsProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
    }

    @Override
    public void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        ElectricCannonBallHitsProcedure.execute(
            this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ()
        );
    }

    @Override
    public void tick() {
        super.tick();
        CannonBallProjectileWhileProjectileFlyingTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
        if (this.inGround) {
            this.discard();
        }
    }

    public static ElectricCannonBallProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
        return shoot(world, entity, source, 1.0F, 5.0, 5);
    }

    public static ElectricCannonBallProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
        return shoot(world, entity, source, pullingPower * 1.0F, 5.0, 5);
    }

    public static ElectricCannonBallProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
        ElectricCannonBallProjectileEntity entityarrow = new ElectricCannonBallProjectileEntity(
            MoreCrittersModEntities.ELECTRIC_CANNON_BALL_PROJECTILE.get(), entity, world
        );
        entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(false);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        world.playSound(
            null,
            entity.getX(),
            entity.getY(),
            entity.getZ(),
            BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.arrow.shoot")),
            SoundSource.PLAYERS,
            1.0F,
            1.0F / (random.nextFloat() * 0.5F + 1.0F) + power / 2.0F
        );
        return entityarrow;
    }

    public static ElectricCannonBallProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
        ElectricCannonBallProjectileEntity entityarrow = new ElectricCannonBallProjectileEntity(
            MoreCrittersModEntities.ELECTRIC_CANNON_BALL_PROJECTILE.get(), entity, entity.level()
        );
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.20000000298023224, dz, 2.0F, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(5.0);
        entityarrow.setKnockback(5);
        entityarrow.setCritArrow(false);
        entity.level().addFreshEntity(entityarrow);
        entity.level()
            .playSound(
                null,
                entity.getX(),
                entity.getY(),
                entity.getZ(),
                BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.arrow.shoot")),
                SoundSource.PLAYERS,
                1.0F,
                1.0F / (RandomSource.create().nextFloat() * 0.5F + 1.0F)
            );
        return entityarrow;
    }
}
