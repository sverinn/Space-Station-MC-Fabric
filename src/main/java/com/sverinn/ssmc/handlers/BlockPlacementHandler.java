package com.sverinn.ssmc.handlers;

import com.sverinn.ssmc.enums.TileBlockVariant;
import net.minecraft.block.Block;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import static com.sverinn.ssmc.Ssmc.LOGGER;
import static com.sverinn.ssmc.audio.ModSoundEvents.GENHIT;
import static com.sverinn.ssmc.object.block.ModBlocks.*;
import static com.sverinn.ssmc.object.block.tiles.TileBlock.TILE_VARIANT;
import static com.sverinn.ssmc.util.Util.playSoundAndSetBlock;

/**
 * All logic for Right Clicks with blocks is here.
 * SUCCESS = do not perform vanilla action processing.
 * PASS = run custom code then vanilla code after it.
 * FAIL = cancel action.
 */
public class BlockPlacementHandler {
    public static ActionResult handleBlockPlacement(ItemPlacementContext context) {

        BlockPos targetBlockPos = context.getBlockPos().offset(context.getSide().getOpposite());
        Block targetBlock = context.getWorld().getBlockState(targetBlockPos).getBlock();
        ItemStack heldStack = context.getStack();
        if ( targetBlock == PLATING && heldStack.getItem() == TILE.asItem()) {

            if (heldStack.getNbt() == null)
            {
                LOGGER.error("Null stack NBT: " + heldStack);
                return ActionResult.FAIL;
            }
            playSoundAndSetBlock(context.getWorld(), targetBlockPos, GENHIT, TILE.getDefaultState().with(TILE_VARIANT, TileBlockVariant.valueOf(heldStack.getNbt().getCompound("BlockStateTag").getString("variant").toUpperCase())), false);
            heldStack.decrement(1);
            return ActionResult.SUCCESS;
        }else if ( targetBlock == LATTICE && heldStack.getItem() == TILE.asItem()) {
            if (heldStack.getNbt() == null)
            {
                LOGGER.error("Null stack NBT: " + heldStack);
                return ActionResult.FAIL;
            }
            if (heldStack.getNbt().getCompound("BlockStateTag").getString("variant").toUpperCase() == "GLASS" || heldStack.getNbt().getCompound("BlockStateTag").getString("variant").toUpperCase() == "GLASS")
                return ActionResult.FAIL;
            playSoundAndSetBlock(context.getWorld(), targetBlockPos, GENHIT, PLATING.getDefaultState(), false);
            heldStack.decrement(1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
