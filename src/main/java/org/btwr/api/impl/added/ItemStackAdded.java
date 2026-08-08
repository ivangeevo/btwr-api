package org.btwr.api.impl.added;


import org.btwr.api.api.item.CustomUseAction;

public interface ItemStackAdded {
    default CustomUseAction btwr$getCustomUseAction() {
        throw new UnsupportedOperationException();
    }
}