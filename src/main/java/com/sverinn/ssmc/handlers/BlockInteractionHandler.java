package com.sverinn.ssmc.handlers;

import com.sverinn.ssmc.audio.SsmcSounds;
import com.sverinn.ssmc.enums.TileVariant;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

import static com.sverinn.ssmc.audio.SsmcSounds.GENHIT;
import static com.sverinn.ssmc.object.block.SsmcBlocks.*;
import static com.sverinn.ssmc.object.block.SsmcBlocks.TILE;
import static com.sverinn.ssmc.object.block.SsmcTileBlock.TILE_VARIANT;
import static com.sverinn.ssmc.object.item.SsmcItems.*;
import static com.sverinn.ssmc.util.Util.playSoundAndSetBlock;
import static com.sverinn.ssmc.util.Util.randomFloatBetween;
import static net.minecraft.block.Blocks.AIR;

public class BlockInteractionHandler {
    public static TypedActionResult<ItemStack> handleBlockInteractions(PlayerEntity player, World world, Hand hand,
                                                                       BlockHitResult blockHit, BlockState state, Item heldItem) {
        if (state.getBlock() == LATTICE && heldItem == CUTTERS) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), SsmcSounds.CUTTERS, AIR.getDefaultState());
            player.swingHand(hand);
            ItemStack itemStack = new ItemStack(RODS, 2);
            ItemScatterer.spawn(world, blockHit.getBlockPos().getX(), blockHit.getBlockPos().getY(), blockHit.getBlockPos().getZ(), itemStack);
            return TypedActionResult.success(heldItem.getDefaultStack());
        } else
        if (state.getBlock() == TILE && heldItem == CROWBAR) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), SsmcSounds.CROWBAR, PLATING.getDefaultState());
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        } else if (heldItem == RODS && new ItemPlacementContext(player, hand, heldItem.getDefaultStack(), blockHit).canPlace()) {
            playSoundAndSetBlock(world, blockHit.getBlockPos().offset(blockHit.getSide()), GENHIT, LATTICE.getDefaultState());
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        } else if (state.getBlock() == PLATING && heldItem == SHEET_GLASS) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), GENHIT, TILE.getDefaultState().with(TILE_VARIANT, TileVariant.GLASS));
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        } else if (state.getBlock() == PLATING && heldItem == SHEET_RGLASS) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), GENHIT, TILE.getDefaultState().with(TILE_VARIANT, TileVariant.RGLASS));
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        }
        return TypedActionResult.fail(heldItem.getDefaultStack());
    }
}