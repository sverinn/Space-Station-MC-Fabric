package com.sverinn.ssmc.util;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.concurrent.ThreadLocalRandom;

import static net.minecraft.sound.SoundCategory.MASTER;

/**
 * Utility class.
 */
public class Util {
    /**
     *
     * @param min
     * @param max
     * @return
     */
    public static float randomFloatBetween(float min, float max) {
        return min + ThreadLocalRandom.current().nextFloat() * (max - min);
    }

    /**
     * Break block at blockpos, play sound @blockPos, set block to newState @world @blockPost
     * @param world
     * @param blockPos
     * @param sound
     * @param newState
     */
    public static void playSoundAndSetBlock(World world,
                                            BlockPos blockPos, SoundEvent sound, BlockState newState) {
        if (world.isClient)
        {return;}
        world.breakBlock(blockPos, true);
        world.playSound(null, blockPos, sound, MASTER, 1f, randomFloatBetween(0.9f, 1.1f));
        world.setBlockState(blockPos, newState);
    }
}