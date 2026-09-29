package com.morecritters.mod.item;

import net.minecraft.server.level.ServerLevel;
import com.morecritters.mod.entity.WebSackProjectileEntity;
import com.morecritters.mod.procedures.ShriekBombRangedItemShootsProjectileProcedure;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class WebSackItem extends Item {
    public WebSackItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemstack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack itemstack, LivingEntity livingEntity) {
        return 20;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = InteractionResultHolder.fail(entity.getItemInHand(hand));
        if (entity.getAbilities().instabuild || this.findAmmo(entity) != ItemStack.EMPTY) {
            ar = InteractionResultHolder.success(entity.getItemInHand(hand));
            entity.startUsingItem(hand);
        }

        return ar;
    }

    @Override
    public void onUseTick(Level world, LivingEntity entity, ItemStack itemstack, int count) {
        if (!world.isClientSide() && entity instanceof ServerPlayer player) {
            ItemStack stack = this.findAmmo(player);
            if (player.getAbilities().instabuild || stack != ItemStack.EMPTY) {
                WebSackProjectileEntity projectile = WebSackProjectileEntity.shoot(world, entity, world.getRandom());
                if (player.getAbilities().instabuild) {
                    projectile.pickup = Pickup.CREATIVE_ONLY;
                } else if (stack.isDamageableItem()) {
                    if (world instanceof ServerLevel _serverLevel) {
                        stack.hurtAndBreak(1, _serverLevel, player, _item -> {
                        if (stack.isEmpty()) {
                            player.getInventory().removeItem(stack);
                        }
                        });
                    }
                } else {
                    stack.shrink(1);
                    if (stack.isEmpty()) {
                        player.getInventory().removeItem(stack);
                    }
                }

                ShriekBombRangedItemShootsProjectileProcedure.execute(entity, itemstack);
            }

            entity.releaseUsingItem();
        }
    }

    private ItemStack findAmmo(Player player) {
        ItemStack stack = ProjectileWeaponItem.getHeldProjectile(player, e -> e.getItem() == WebSackProjectileEntity.PROJECTILE_ITEM.getItem());
        if (stack == ItemStack.EMPTY) {
            for (int i = 0; i < player.getInventory().items.size(); i++) {
                ItemStack teststack = player.getInventory().items.get(i);
                if (teststack != null && teststack.getItem() == WebSackProjectileEntity.PROJECTILE_ITEM.getItem()) {
                    stack = teststack;
                    break;
                }
            }
        }

        return stack;
    }
}
