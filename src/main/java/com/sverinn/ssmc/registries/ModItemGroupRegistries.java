package com.sverinn.ssmc.registries;

import com.sverinn.ssmc.enums.TileBlockVariant;
import com.sverinn.ssmc.object.block.ModBlocks;
import com.sverinn.ssmc.object.block.TileBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import static com.sverinn.ssmc.object.item.ModItems.*;
import static com.sverinn.ssmc.object.item.ModItems.CROWBAR;

/**
 * Initialize item categories: General, Tools, Structures, Fun
 * And add items to categories
 */
public class ModItemGroupRegistries {
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

        ItemGroupEvents.modifyEntriesEvent(SSMC_TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(CUTTERS);
            // ...
        });

        ItemGroupEvents.modifyEntriesEvent(SSMC_GENERAL_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(SHEET_STEEL);
            itemGroup.add(SHEET_GLASS);
            itemGroup.add(SHEET_RGLASS);
            itemGroup.add(PART_ROD_METAL);
            itemGroup.add(BANANIUM);
            itemGroup.add(CROWBAR);
            itemGroup.add(CUTTERS);
            // ...
        });

        ItemGroupEvents.modifyEntriesEvent(SSMC_GENERAL_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(PART_ROD_METAL);
            // ...
        });

        ItemGroupEvents.modifyEntriesEvent(SSMC_STRUCTURES_ITEM_GROUP_KEY).register((itemGroup) -> itemGroup.add(ModBlocks.PLATING.asItem()));

        ItemGroupEvents.modifyEntriesEvent(SSMC_STRUCTURES_ITEM_GROUP_KEY).register(entries -> {
            for (TileBlockVariant variant : TileBlockVariant.values()) {
                entries.add(TileBlock.createStackWithVariant(variant));
            }
        });
    }
}
