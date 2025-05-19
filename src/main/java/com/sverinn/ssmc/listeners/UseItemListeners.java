package com.sverinn.ssmc.listeners;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;

import static com.sverinn.ssmc.handlers.BlockInteractionHandler.handleBlockInteractions;

/**
 * General logic for UseItemCallback. Does not require external call.
 */
public class UseItemListeners {
    public static void initialize() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            if (player.isSpectator()) {
                return TypedActionResult.pass(player.getMainHandStack());
            }

            HitResult hitResult = player.raycast(5f, 1, false);
            if (hitResult.getType() != HitResult.Type.BLOCK) {
                return TypedActionResult.pass(player.getMainHandStack());
            }

            BlockHitResult blockHit = (BlockHitResult) hitResult;
            BlockState state = world.getBlockState(blockHit.getBlockPos());
            Item heldItem = player.getMainHandStack().getItem();

            return handleBlockInteractions(player, world, hand, blockHit, state, heldItem);
        });
    }
}
