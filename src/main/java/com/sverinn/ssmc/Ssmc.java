package com.sverinn.ssmc;

import com.sverinn.ssmc.audio.ModSoundEvents;
import com.sverinn.ssmc.listeners.ModListeners;
import com.sverinn.ssmc.object.block.ModBlocks;
import com.sverinn.ssmc.object.item.ModItems;
import com.sverinn.ssmc.registries.ModItemGroupRegistries;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sverinn.ssmc.effects.ModStatusEffects;


public class Ssmc implements ModInitializer {

    /**
     * Register mod id to reuse across the project using Ssmc.MOD_ID
     * And Logger using Ssmc.LOGGER
     * E.g. Ssmc.LOGGER.info("Sample text");
     */
    public static final String MOD_ID = "ssmc";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    /**
     *Register mod classes. Runs once on startup.
     */
    @Override
    public void onInitialize() {
        LOGGER.info("Starting SSMC.");
        ModSoundEvents.initialize();
        ModStatusEffects.initialize();
        ModItems.initialize();
        ModBlocks.initialize();
        ModItemGroupRegistries.initialize();
        ModListeners.initialize();
    }
}
