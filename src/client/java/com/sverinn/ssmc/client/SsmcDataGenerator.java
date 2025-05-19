package com.sverinn.ssmc.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import com.sverinn.ssmc.object.block.BlockLootTableProvider;

public class SsmcDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        // TODO: Implement loot table generation
        //pack.addProvider(BlockLootTableProvider::new);
    }
}
