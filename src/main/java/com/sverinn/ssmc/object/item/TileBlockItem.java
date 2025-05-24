package com.sverinn.ssmc.object.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.ActionResult;

import static com.sverinn.ssmc.handlers.BlockPlacementHandler.handleBlockPlacement;

/**
 * Overrides for TILE BlockItem (currently overrides right click with block).
 */
public class TileBlockItem extends BlockItem {

    public TileBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult place(ItemPlacementContext context) {
        if (!context.getWorld().isClient()) {
            handleBlockPlacement(context);
        }
        return ActionResult.FAIL;
    }
}