package com.sverinn.ssmc.handlers;

import com.sverinn.ssmc.audio.ModSoundEvents;
import com.sverinn.ssmc.enums.TileBlockVariant;
import com.sverinn.ssmc.object.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

import static com.sverinn.ssmc.audio.ModSoundEvents.*;
import static com.sverinn.ssmc.object.block.ModBlocks.*;
import static com.sverinn.ssmc.object.block.tiles.TileBlock.TILE_VARIANT;
import static com.sverinn.ssmc.object.item.ModItems.*;
import static com.sverinn.ssmc.util.Util.playSoundAndSetBlock;
import static net.minecraft.block.Blocks.AIR;

/**
 * Handles all right-click interactions with blocks, with or without items.
 * <p>
 * Return values:
 * - TypedActionResult.success: Run custom logic only
 * - TypedActionResult.pass: Run custom then vanilla logic
 * - TypedActionResult.fail: Cancel action
 */
public class BlockInteractionHandler {

    /**
     * Processes block interactions based on the held item and targeted block
     *
     * @param player The player performing the interaction
     * @param world The world where interaction occurs
     * @param hand The hand used for interaction
     * @param blockHit The hit result of the block interaction
     * @param state The current block state being interacted with
     * @param heldItem The item held by the player
     * @return TypedActionResult indicating how to proceed with the interaction
     */
    public static TypedActionResult<ItemStack> handleBlockInteractions(
            PlayerEntity player, World world, Hand hand,
            BlockHitResult blockHit, BlockState state, Item heldItem) {

        // Placement of PART_ROD_METAL to create LATTICE
        if (heldItem == PART_ROD_METAL && canPlaceRod(player, hand, blockHit, heldItem)) {
            return handleRodPlacement(player, world, hand, blockHit);
        }

        // Interaction with LATTICE block
        if (state.getBlock() == LATTICE) {
            return handleLatticeInteractions(player, world, hand, blockHit, heldItem);
        }

        // Interaction with TILE block using CROWBAR
        if (state.getBlock() == TILE && heldItem == ModItems.CROWBAR) {
            return handleTileCrowbarInteraction(player, world, hand, blockHit);
        }


        // Convert PLATING to different TILE variants
        if (state.getBlock() == PLATING) {
            return handlePlatingConversions(player, world, hand, blockHit, heldItem);
        }

        return TypedActionResult.fail(heldItem.getDefaultStack());
    }

    private static TypedActionResult<ItemStack> handleLatticeInteractions(
            PlayerEntity player, World world, Hand hand,
            BlockHitResult blockHit, Item heldItem) {

        String itemId = heldItem.toString();

        if ("cutters".equals(itemId)) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), ModSoundEvents.CUTTERS, AIR.getDefaultState());
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        }

        if ("sheet/steel".equals(itemId)) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), GENHIT, PLATING.getDefaultState(), false);
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        }

        return TypedActionResult.pass(heldItem.getDefaultStack());
    }

    private static TypedActionResult<ItemStack> handleTileCrowbarInteraction(
            PlayerEntity player, World world, Hand hand,
            BlockHitResult blockHit) {

        playSoundAndSetBlock(world, blockHit.getBlockPos(), ModSoundEvents.CROWBAR, PLATING.getDefaultState());
        player.swingHand(hand);
        return TypedActionResult.success(ModItems.CROWBAR.getDefaultStack());
    }

    private static boolean canPlaceRod(PlayerEntity player, Hand hand,
                                       BlockHitResult blockHit, Item heldItem) {
        return new ItemPlacementContext(player, hand, heldItem.getDefaultStack(), blockHit).canPlace();
    }

    private static TypedActionResult<ItemStack> handleRodPlacement(
            PlayerEntity player, World world, Hand hand,
            BlockHitResult blockHit) {

        playSoundAndSetBlock(world, blockHit.getBlockPos().offset(blockHit.getSide()),
                GENHIT, LATTICE.getDefaultState());
        player.swingHand(hand);
        return TypedActionResult.success(PART_ROD_METAL.getDefaultStack());
    }

    private static TypedActionResult<ItemStack> handlePlatingConversions(
            PlayerEntity player, World world, Hand hand,
            BlockHitResult blockHit, Item heldItem) {

        if (heldItem == SHEET_GLASS) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), GENHIT,
                    TILE.getDefaultState().with(TILE_VARIANT, TileBlockVariant.GLASS), false);
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        }

        if (heldItem == SHEET_RGLASS) {
            playSoundAndSetBlock(world, blockHit.getBlockPos(), GENHIT,
                    TILE.getDefaultState().with(TILE_VARIANT, TileBlockVariant.RGLASS), false);
            player.swingHand(hand);
            return TypedActionResult.success(heldItem.getDefaultStack());
        }

        return TypedActionResult.fail(heldItem.getDefaultStack());
    }
}