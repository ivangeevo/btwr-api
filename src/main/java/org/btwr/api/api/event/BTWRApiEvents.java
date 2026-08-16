package org.btwr.api.api.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.entity.LivingEntity;
import org.btwr.api.api.config.TomlConfigManager;
import org.btwr.api.api.config.impl.ConfigGroup;
import org.btwr.api.api.event.impl.SimpleEvent;

import java.util.function.Consumer;

public class BTWRApiEvents {

    public static final SimpleEvent<Consumer<LivingEntity>> LIVING_TICK = new SimpleEvent<>(
            handlers -> living -> handlers.forEach(c -> c.accept(living))
    );

    public static void initialize() {
        // Reload all configs when a server instance starts (SP or dedicated)
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            for (ConfigGroup group : TomlConfigManager.getAllGroups()) {
                group.load();
            }
        });
    }

}