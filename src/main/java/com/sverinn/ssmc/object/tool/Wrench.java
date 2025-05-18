package com.sverinn.ssmc.object.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;

import static com.sverinn.ssmc.audio.SsmcSounds.WRENCH;

public class Wrench extends Item {
    public Wrench(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            // Play the sound and specify location, category and who made the sound.
            // No entity made the sound, so we specify null.
            context.getWorld().playSound(null, context.getBlockPos(),
                    WRENCH, SoundCategory.PLAYERS,
                    1f, 1f);
        }

        return super.useOnBlock(context);
    }
}

