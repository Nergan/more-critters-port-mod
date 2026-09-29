package com.morecritters.mod.item;

import net.minecraft.server.level.ServerLevel;
import java.util.List;
import com.morecritters.mod.entity.ThrownInfestedHardtackEntity;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.Level;

public class InfestedHardtackItem extends Item {
    public InfestedHardtackItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
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
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable("item.more_critters.infested_hardtack.description_0"));
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
                ThrownInfestedHardtackEntity projectile = ThrownInfestedHardtackEntity.shoot(world, entity, world.getRandom());
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
            }

            entity.releaseUsingItem();
        }
    }

    private ItemStack findAmmo(Player player) {
        ItemStack stack = ProjectileWeaponItem.getHeldProjectile(player, e -> e.getItem() == ThrownInfestedHardtackEntity.PROJECTILE_ITEM.getItem());
        if (stack == ItemStack.EMPTY) {
            for (int i = 0; i < player.getInventory().items.size(); i++) {
                ItemStack teststack = player.getInventory().items.get(i);
                if (teststack != null && teststack.getItem() == ThrownInfestedHardtackEntity.PROJECTILE_ITEM.getItem()) {
                    stack = teststack;
                    break;
                }
            }
        }

        return stack;
    }
}
