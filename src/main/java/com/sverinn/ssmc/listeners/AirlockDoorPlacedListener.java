package com.sverinn.ssmc.listeners;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AirlockDoorPlacedListener {
    public void onPlaced(World world,
                         BlockPos pos,
                         BlockState state,
                         @Nullable LivingEntity placer,
                         ItemStack itemStack)
    {
        if (world.isClient) {return;}

        //world.setBlockState(pos, )
    }
}
