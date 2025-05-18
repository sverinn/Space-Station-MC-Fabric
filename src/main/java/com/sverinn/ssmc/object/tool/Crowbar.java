package com.sverinn.ssmc.object.tool;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.slf4j.Logger;

import static com.sverinn.ssmc.audio.SsmcSounds.CROWBAR;
import static com.sverinn.ssmc.util.Util.randomFloatBetween;
import static com.sverinn.ssmc.Ssmc.LOGGER;

public class Crowbar extends Item {
    public Crowbar(Settings settings) {
        super(settings);
    }

}
