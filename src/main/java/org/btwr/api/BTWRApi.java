package org.btwr.api;

import net.fabricmc.api.ModInitializer;
import org.btwr.api.api.event.BTWRApiEvents;
import org.btwr.api.api.block.OnFireConversionRegistry;
import org.btwr.api.api.recipe.BTWRApiRecipes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BTWRApi implements ModInitializer {
    public static final String MOD_ID = "btwr_api";
    public static final String MOD_NAME = "BTWR: API";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing {}", MOD_NAME);

        BTWRApiRecipes.initialize();
        BTWRApiEvents.initialize();

        // Initialize all mod registry classes

        // Initialize the instance of the on fire conversion block registry
        OnFireConversionRegistry.initialize();
    }

}