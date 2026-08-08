package org.btwr.api.api.recipe.capability;

import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface AdditionalDropsRecipe {
    DefaultedList<ItemStack> getAdditionalDrops();
}
