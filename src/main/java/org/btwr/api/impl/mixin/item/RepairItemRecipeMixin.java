package org.btwr.api.impl.mixin.item;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RepairItemRecipe;
import org.btwr.api.api.recipe.RepairRecipeBlockedRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RepairItemRecipe.class)
public abstract class RepairItemRecipeMixin {

    // Cancel the combination of stacks for combine repairing recipes
    @Inject(method = "canCombineStacks", at = @At("HEAD"), cancellable = true)
    private static void preventRepair(ItemStack first, ItemStack second, CallbackInfoReturnable<Boolean> cir) {
        if (isRecipeBlockedFor(first) || isRecipeBlockedFor(second)) {
            cir.setReturnValue(false);
        }
    }

    @Unique
    private static boolean isRecipeBlockedFor(ItemStack stack) {
        return RepairRecipeBlockedRegistry.isBlocked(
                stack, RepairRecipeBlockedRegistry.BlockType.CRAFTING
        );
    }
}