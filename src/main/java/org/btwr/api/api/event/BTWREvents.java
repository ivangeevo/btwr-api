package org.btwr.api.api.event;

import net.minecraft.entity.LivingEntity;
import org.btwr.api.api.event.impl.SimpleEvent;

import java.util.function.Consumer;

public class BTWREvents {

    public static final SimpleEvent<Consumer<LivingEntity>> LIVING_TICK = new SimpleEvent<>(
            handlers -> living -> handlers.forEach(c -> c.accept(living))
    );

}