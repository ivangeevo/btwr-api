package org.btwr.api.impl.mixin.added;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.btwr.api.api.item.CustomUseAction;
import org.btwr.api.impl.added.ItemStackAdded;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemStack.class)
public abstract class ItemStackAddedMixin implements ItemStackAdded {

    @Shadow public abstract Item getItem();

    @Override
    public CustomUseAction btwr$getCustomUseAction() {
        return this.getItem().btwr$getCustomUseAction((ItemStack)(Object)this);
    }

}