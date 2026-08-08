package org.btwr.api.impl.added;

import net.minecraft.item.ItemStack;
import org.btwr.api.api.item.CustomUseAction;

public interface ItemAdded {
    default int btwr$getItemUseWarmupDuration() {
        throw new UnsupportedOperationException();
    }
    default CustomUseAction btwr$getCustomUseAction(ItemStack stack) {
        throw new UnsupportedOperationException();
    }
}