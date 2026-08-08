package org.btwr.api;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import org.btwr.api.api.block.OnFireConversionRegistry;
import org.btwr.api.api.config.TomlConfigManager;
import org.btwr.api.api.config.impl.ConfigGroup;
import org.btwr.api.api.recipe.BTWRApiRecipes;
import org.btwr.api.api.registry.HeadDropRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BTWRApi implements ModInitializer {
    public static final String MOD_ID = "btwr_api";
    public static final String MOD_NAME = "BTWR: API";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        BTWRApiRecipes.register();

        // Reload all configs when a server instance starts (SP or dedicated)
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            for (ConfigGroup group : TomlConfigManager.getAllGroups()) {
                group.load();
            }
        });

        // Initialize the instance of the on fire conversion block registry
        OnFireConversionRegistry.initialize();

        // Register default pairs for head drops per entity type
        HeadDropRegistry.registerDefaults();
    }
}