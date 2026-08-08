package org.btwr.api.impl.mixin.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.btwr.api.api.sound.CraftingSoundHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Inject(method = "onCraftByPlayer", at = @At("HEAD"))
    private void onOnCraftByPlayer(ItemStack stack, World world, PlayerEntity player, CallbackInfo ci) {
        CraftingSoundHandler.getInstance().playCraftingSound(stack, world, player);
    }
}