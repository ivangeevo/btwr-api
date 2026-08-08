package org.btwr.api;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BTWRApiClient implements ClientModInitializer {
    public static final String MOD_ID = "btwr_api";
    public static final String MOD_NAME = "BTWR: API";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {}
}