package com.sverinn.ssmc.listeners;

import com.sverinn.ssmc.audio.SsmcSounds;
import com.sverinn.ssmc.enums.TileVariant;
import com.sverinn.ssmc.object.block.SsmcTileBlock;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import static com.sverinn.ssmc.audio.SsmcSounds.GENHIT;
import static com.sverinn.ssmc.enums.TileVariant.DARK;
import static com.sverinn.ssmc.enums.TileVariant.WHITE;
import static com.sverinn.ssmc.handlers.BlockInteractionHandler.handleBlockInteractions;
import static com.sverinn.ssmc.object.block.SsmcBlocks.*;
import static com.sverinn.ssmc.object.item.SsmcItems.*;
import static com.sverinn.ssmc.util.Util.randomFloatBetween;

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
