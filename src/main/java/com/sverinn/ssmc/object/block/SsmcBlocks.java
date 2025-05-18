package com.sverinn.ssmc.object.block;

import com.sverinn.ssmc.Ssmc;
import com.sverinn.ssmc.object.item.SsmcTileBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class SsmcBlocks {

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Ssmc.MOD_ID, name), block);
    }


    private static Block registerCustomBlock(String name, Block block) {
        registerCustomBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Ssmc.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Ssmc.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    private static Item registerCustomBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Ssmc.MOD_ID, name),
                new SsmcTileBlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Ssmc.MOD_ID, name), block);
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
            registerCustomBlock("tile",
            new SsmcTileBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque().drops(new Identifier("ssmc","tile")))
    );

    public static void initialize()
    {
        Ssmc.LOGGER.info("Registering " + Ssmc.MOD_ID + " Blocks");

    }
}
