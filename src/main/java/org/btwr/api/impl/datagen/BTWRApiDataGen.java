package org.btwr.api.impl.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import org.btwr.api.impl.datagen.provider.BTWRApiBlockTagProvider;
import org.btwr.api.impl.datagen.provider.BTWRApiItemTagProvider;
import org.btwr.api.impl.datagen.provider.BTWRApiLangGenerator;

public class BTWRApiDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(BTWRApiBlockTagProvider::new);
        pack.addProvider(BTWRApiItemTagProvider::new);
        pack.addProvider(BTWRApiLangGenerator::new);
    }
}