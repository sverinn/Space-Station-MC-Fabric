package com.sverinn.ssmc.registries;

import com.sverinn.ssmc.enums.TileVariant;
import com.sverinn.ssmc.object.block.SsmcBlocks;
import com.sverinn.ssmc.object.block.SsmcTileBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

import static com.sverinn.ssmc.object.item.SsmcItems.*;
import static com.sverinn.ssmc.object.item.SsmcItems.CROWBAR;

public class SsmcItemGroupRegistries {
    public static void initialize()
    {
        ItemGroupEvents.modifyEntriesEvent(SSMC_FUN_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(BANANIUM);
            // ...
        });
        ItemGroupEvents.modifyEntriesEvent(SSMC_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(CROWBAR);
            // ...
        });

        ItemGroupEvents.modifyEntriesEvent(SSMC_GENERAL_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(SHEET_STEEL);
            // ...
        });

        ItemGroupEvents.modifyEntriesEvent(SSMC_GENERAL_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(RODS);
            // ...
        });

        ItemGroupEvents.modifyEntriesEvent(SSMC_STRUCTURES_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(SsmcBlocks.PLATING.asItem());
        });

        ItemGroupEvents.modifyEntriesEvent(SSMC_STRUCTURES_ITEM_GROUP_KEY).register(entries -> {
            for (TileVariant variant : TileVariant.values()) {
                entries.add(SsmcTileBlock.createStackWithVariant(variant));
            }
        });

        //ItemGroupEvents.modifyEntriesEvent(SSMC_STRUCTURES_ITEM_GROUP_KEY).register((itemGroup) -> {
        //    itemGroup.add(SsmcBlocks.TILE.asItem());
        //});
    }
}
