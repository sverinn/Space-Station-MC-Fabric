package com.sverinn.ssmc;

import com.sverinn.ssmc.audio.SsmcSounds;
import com.sverinn.ssmc.listeners.SsmcListeners;
import com.sverinn.ssmc.object.block.SsmcBlocks;
import com.sverinn.ssmc.object.item.SsmcItems;
import com.sverinn.ssmc.registries.SsmcItemGroupRegistries;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sverinn.ssmc.effects.SsmcEffects;


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
        SsmcSounds.initialize();
        SsmcEffects.initialize();
        SsmcItems.initialize();
        SsmcBlocks.initialize();
        SsmcItemGroupRegistries.initialize();
        SsmcListeners.initialize();


    }
}
