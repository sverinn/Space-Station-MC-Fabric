package com.sverinn.ssmc.registries;

import com.sverinn.ssmc.enums.TileBlockVariant;
import com.sverinn.ssmc.object.block.ModBlocks;
import com.sverinn.ssmc.object.block.tiles.TileBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import static com.sverinn.ssmc.object.item.ModItems.*;

/**
 * Handles registration of items to their respective creative mode tabs/groups.
 * Organizes items into categories: General, Tools, Structures, and Fun.
 */
public class ModItemGroupRegistries {

    /**
     * Initializes and populates all item groups with their respective items.
     * Called during mod initialization.
     */
    public static void initialize() {
        registerFunItems();
        registerToolItems();
        registerGeneralItems();
        registerStructureItems();
    }

    /**
     * Registers decorative/fun items to the Fun creative tab.
     */
    private static void registerFunItems() {
        ItemGroupEvents.modifyEntriesEvent(SSMC_FUN_ITEM_GROUP_KEY).register(entries -> {
            entries.add(BANANIUM);
            // Add other fun items here...
        });
    }

    /**
     * Registers all tools to the Tools creative tab.
     */
    private static void registerToolItems() {
        ItemGroupEvents.modifyEntriesEvent(SSMC_TOOLS_ITEM_GROUP_KEY).register(entries -> {
            entries.add(CROWBAR);
            entries.add(CUTTERS);
            // Add other tools here...
        });
    }

    /**
     * Registers common items to the General creative tab.
     */
    private static void registerGeneralItems() {
        ItemGroupEvents.modifyEntriesEvent(SSMC_GENERAL_ITEM_GROUP_KEY).register(entries -> {
            // Building materials
            entries.add(SHEET_STEEL);
            entries.add(SHEET_GLASS);
            entries.add(SHEET_RGLASS);

            // Components
            entries.add(PART_ROD_METAL);

            // Tools (also available in tools tab)
            entries.add(CROWBAR);
            entries.add(CUTTERS);

            // Fun items (also available in fun tab)
            entries.add(BANANIUM);

            // Add other general items here...
        });
    }

    /**
     * Registers building blocks and structural items to the Structures creative tab.
     */
    private static void registerStructureItems() {
        ItemGroupEvents.modifyEntriesEvent(SSMC_STRUCTURES_ITEM_GROUP_KEY).register(entries -> {
            // Basic building blocks
            entries.add(ModBlocks.PLATING.asItem());

            // Tile variants
            for (TileBlockVariant variant : TileBlockVariant.values()) {
                entries.add(TileBlock.createStackWithVariant(variant));
            }

            // Add other structural items here...
        });
    }
}