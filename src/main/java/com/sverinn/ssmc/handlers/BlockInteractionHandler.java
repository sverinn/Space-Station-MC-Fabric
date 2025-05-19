package com.sverinn.ssmc.handlers;

import com.sverinn.ssmc.audio.ModSoundEvents;
import com.sverinn.ssmc.enums.TileBlockVariant;
import com.sverinn.ssmc.object.block.TileBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.sverinn.ssmc.audio.ModSoundEvents.GENHIT;
import static com.sverinn.ssmc.object.block.ModBlocks.*;
import static com.sverinn.ssmc.object.block.ModBlocks.TILE;
import static com.sverinn.ssmc.object.block.TileBlock.TILE_VARIANT;
import static com.sverinn.ssmc.object.item.ModItems.*;
import static com.sverinn.ssmc.util.Util.playSoundAndSetBlock;
import static net.minecraft.block.Blocks.AIR;

/**
 * Handle all rightclicks on blocks, with or without items.
 * TypedActionResult.success = run custom logic only.
 * TypedActionResult.pass = run custom then vanilla logic.
 * TypedActionResult.fail = cancel action.
 */
public class BlockInteractionHandler {
    public static TypedActionResult<ItemStack> handleBlockInteractions(PlayerEntity player, World world, Hand hand,
                                                                       BlockHitResult blockHit, BlockState state, Item heldItem) {
        if (state.getBlock() == LATTICE) {
            switch (heldItem.toString()) {
                case "cutters": {
                    playSoundAndSetBlock(world, blockHit.getBlockPos(), ModSoundEvents.CUTTERS, AIR.getDefaultState());
                    player.swingHand(hand);
                    return TypedActionResult.success(heldItem.getDefaultStack());
                }
                case "sheet/steel": {
                    playSoundAndSetBlock(world, blockHit.getBlockPos(), ModSoundEvents.GENHIT, PLATING.getDefaultState(), false);
                    player.swingHand(hand);
                    return TypedActionResult.success(heldItem.getDefaultStack());
                }
            }
        } else
        if (state.getBlock() == TILE && heldItem == CROWBAR) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), ModSoundEvents.CROWBAR, PLATING.getDefaultState());

            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        } else if (heldItem == PART_ROD_METAL && new ItemPlacementContext(player, hand, heldItem.getDefaultStack(), blockHit).canPlace()) {
            playSoundAndSetBlock(world, blockHit.getBlockPos().offset(blockHit.getSide()), GENHIT, LATTICE.getDefaultState());
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        } else if (state.getBlock() == PLATING && heldItem == SHEET_GLASS) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), GENHIT, TILE.getDefaultState().with(TILE_VARIANT, TileBlockVariant.GLASS), false);
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        } else if (state.getBlock() == PLATING && heldItem == SHEET_RGLASS) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), GENHIT, TILE.getDefaultState().with(TILE_VARIANT, TileBlockVariant.RGLASS), false);
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        }
        return TypedActionResult.fail(heldItem.getDefaultStack());
    }
}