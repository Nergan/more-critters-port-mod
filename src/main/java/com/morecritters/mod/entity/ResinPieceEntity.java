package com.morecritters.mod.entity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.damagesource.DamageSource;
import com.morecritters.mod.init.MoreCrittersModEntities;
import com.morecritters.mod.init.MoreCrittersModItems;
import com.morecritters.mod.procedures.ResinPieceProjectileHitsBlockProcedure;
import com.morecritters.mod.procedures.ResinPieceTickProcedure;
import com.morecritters.mod.procedures.SdsProcedure;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class ResinPieceEntity extends AbstractArrow implements ItemSupplier {
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

    public static final ItemStack PROJECTILE_ITEM = new ItemStack(MoreCrittersModItems.BLACK_RESIN_CLUMP.get());


    public ResinPieceEntity(EntityType<? extends ResinPieceEntity> type, Level world) {
        super(type, world);
    }

    public ResinPieceEntity(EntityType<? extends ResinPieceEntity> type, double x, double y, double z, Level world) {
        super(type, x, y, z, world, PROJECTILE_ITEM, null);
    }

    public ResinPieceEntity(EntityType<? extends ResinPieceEntity> type, LivingEntity entity, Level world) {
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
    public void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        SdsProcedure.execute(entityHitResult.getEntity());
    }

    @Override
    public void onHitBlock(BlockHitResult blockHitResult) {
        super.onHitBlock(blockHitResult);
        ResinPieceProjectileHitsBlockProcedure.execute(
            this.level(), blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ()
        );
    }

    @Override
    public void tick() {
        super.tick();
        ResinPieceTickProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
        if (this.inGround) {
            this.discard();
        }
    }

    public static ResinPieceEntity shoot(Level world, LivingEntity entity, RandomSource source) {
        return shoot(world, entity, source, 1.0F, 3.0, 1);
    }

    public static ResinPieceEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
        return shoot(world, entity, source, pullingPower * 1.0F, 3.0, 1);
    }

    public static ResinPieceEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
        ResinPieceEntity entityarrow = new ResinPieceEntity(MoreCrittersModEntities.RESIN_PIECE.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
        entityarrow.setSilent(true);
        entityarrow.setCritArrow(false);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        return entityarrow;
    }

    public static ResinPieceEntity shoot(LivingEntity entity, LivingEntity target) {
        ResinPieceEntity entityarrow = new ResinPieceEntity(MoreCrittersModEntities.RESIN_PIECE.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 1.1;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.20000000298023224, dz, 2.0F, 12.0F);
        entityarrow.setSilent(true);
        entityarrow.setBaseDamage(3.0);
        entityarrow.setKnockback(1);
        entityarrow.setCritArrow(false);
        entity.level().addFreshEntity(entityarrow);
        return entityarrow;
    }
}
