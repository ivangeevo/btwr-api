package org.btwr.api.impl.added;

public interface LivingEntityAdded {

    default void btwr$setItemUseTime(int iCount) {
        throw new UnsupportedOperationException();
    }

}