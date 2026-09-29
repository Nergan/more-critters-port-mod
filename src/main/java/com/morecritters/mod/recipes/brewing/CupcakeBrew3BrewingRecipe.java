package com.morecritters.mod.recipes.brewing;

import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import com.morecritters.mod.init.MoreCrittersModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber
public class CupcakeBrew3BrewingRecipe implements IBrewingRecipe {
    @SubscribeEvent
    public static void init(RegisterBrewingRecipesEvent event) {
        event.getBuilder().addRecipe(new CupcakeBrew3BrewingRecipe());
    }

    @Override
    public boolean isInput(ItemStack input) {
        return Ingredient.of(new ItemStack(MoreCrittersModItems.CUPCAKE.get())).test(input);
    }

    @Override
    public boolean isIngredient(ItemStack ingredient) {
        return Ingredient.of(new ItemStack(MoreCrittersModItems.TOXIN_BLADDER_BRITTLENESS.get())).test(ingredient);
    }

    @Override
    public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
        return this.isInput(input) && this.isIngredient(ingredient) ? new ItemStack(MoreCrittersModItems.CUPCAKE_BRITTLENESS.get()) : ItemStack.EMPTY;
    }
}
