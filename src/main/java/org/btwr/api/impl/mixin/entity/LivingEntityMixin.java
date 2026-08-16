package org.btwr.api.impl.mixin.entity;

import net.minecraft.entity.LivingEntity;
import org.btwr.api.api.event.BTWRApiEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Inject(method = "tick", at = @At("RETURN"))
    private void onEntityTick(CallbackInfo ci) {
        BTWRApiEvents.LIVING_TICK.createInvoker().accept((LivingEntity)(Object)this);
    }
}