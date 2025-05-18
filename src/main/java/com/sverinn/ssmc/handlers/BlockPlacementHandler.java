package com.sverinn.ssmc.handlers;

import com.sverinn.ssmc.enums.TileVariant;
import net.minecraft.block.Block;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.logging.Logger;

import static com.mojang.text2speech.Narrator.LOGGER;
import static com.sverinn.ssmc.audio.SsmcSounds.GENHIT;
import static com.sverinn.ssmc.object.block.SsmcBlocks.*;
import static com.sverinn.ssmc.object.block.SsmcTileBlock.TILE_VARIANT;
import static com.sverinn.ssmc.util.Util.playSoundAndSetBlock;

public class BlockPlacementHandler {
    public static ActionResult handleBlockPlacement(ItemPlacementContext context) {

        BlockPos targetBlockPos = context.getBlockPos().offset(context.getSide().getOpposite());
        Block targetBlock = context.getWorld().getBlockState(targetBlockPos).getBlock();
        ItemStack heldStack = context.getStack();
        if ( targetBlock == PLATING && heldStack.getItem() == TILE.asItem()) {

            playSoundAndSetBlock(context.getWorld(), targetBlockPos, GENHIT, TILE.getDefaultState().with(TILE_VARIANT, TileVariant.valueOf(heldStack.getNbt().getCompound("BlockStateTag").getString("variant").toUpperCase())));
            heldStack.decrement(1);
            return ActionResult.SUCCESS;
        }else if ( targetBlock == LATTICE && heldStack.getItem() == TILE.asItem()) {

            playSoundAndSetBlock(context.getWorld(), targetBlockPos, GENHIT, PLATING.getDefaultState());
            heldStack.decrement(1);
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
