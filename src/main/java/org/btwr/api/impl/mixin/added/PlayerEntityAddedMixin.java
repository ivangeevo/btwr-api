package org.btwr.api.impl.mixin.added;

import net.minecraft.entity.player.PlayerEntity;
import org.btwr.api.impl.added.PlayerEntityAdded;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityAddedMixin implements PlayerEntityAdded {
    @Unique private int btwr$timesCraftedThisTick;

    @Override
    public int btwr$timesCraftedThisTick() {
        return btwr$timesCraftedThisTick;
    }

    @Override
    public void btwr$setTimesCraftedThisTick(int value) {
        btwr$timesCraftedThisTick = value;
    }
}