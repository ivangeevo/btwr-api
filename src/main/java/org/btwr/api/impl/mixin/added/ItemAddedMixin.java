package org.btwr.api.impl.mixin.added;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.btwr.api.api.item.CustomUseAction;
import org.btwr.api.impl.added.ItemAdded;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Item.class)
public abstract class ItemAddedMixin implements ItemAdded {

    @Override
    public CustomUseAction btwr$getCustomUseAction(ItemStack stack) {
        return CustomUseAction.NONE;
    }

    @Override
    public int btwr$getItemUseWarmupDuration() {
        return 7;
    }

}