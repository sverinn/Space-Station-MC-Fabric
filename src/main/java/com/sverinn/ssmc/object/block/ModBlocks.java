package com.sverinn.ssmc.object.block;

import com.sverinn.ssmc.Ssmc;
import com.sverinn.ssmc.object.item.TileBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Initialize registries and add custom blocks.
 * Don't forget to update assets/models/block, assets/models/item, assets/textures/block, assets/textures/item
 */
public class ModBlocks {

    /**
     * Register a generic block with BlockItem (like stone).
     * @param name
     * @param block
     * @return
     */
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Ssmc.MOD_ID, name), block);
    }

    /**
     * Register a generic BlockItem (like stone).
     * @param name
     * @param block
     * @return
     */
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Ssmc.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    /**
     * Usually used for blocks that are not obtainable (like Air, Portal).
     * @param name
     * @param block
     * @return
     */
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Ssmc.MOD_ID, name), block);
    }

    /**
     * Custom registration for TileBlock
     * @param name
     * @param block
     * @return
     */
    private static Block registerTileBlock(String name, Block block) {
        registerTileBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Ssmc.MOD_ID, name), block);
    }

    /**
     * Custom registration for TileBlock
     * @param name
     * @param block
     * @return
     */
    private static Item registerTileBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Ssmc.MOD_ID, name),
                new TileBlockItem(block, new FabricItemSettings()));
    }


    public static final  Block PLATING = registerBlock(
            "plating",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK))
    );

    public static final Block LATTICE = registerBlockWithoutBlockItem(
            "lattice",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque())
    );

    public static final Block TILE =
            registerTileBlock("tile",
            new TileBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque())
    );

    public static void initialize()
    {
        Ssmc.LOGGER.info("Registering " + Ssmc.MOD_ID + " Blocks");
    }
}
