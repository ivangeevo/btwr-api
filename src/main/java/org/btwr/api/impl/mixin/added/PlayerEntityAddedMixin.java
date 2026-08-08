package org.btwr.api.impl.mixin.added;

import net.minecraft.entity.player.PlayerEntity;
import org.btwr.api.impl.added.PlayerEntityAdded;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityAddedMixin implements PlayerEntityAdded {
    @Override
    public int btwr$timesCraftedThisTick() {
        return 0;
    }

    @Override
    public void btwr$setTimesCraftedThisTick(int value) {}
}