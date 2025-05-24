package com.sverinn.ssmc.listeners;

import com.sverinn.ssmc.Ssmc;

/**
 * Initialize all listeners
 *
 * For now, please use a listener for each unique Event type.
 */
public class ModListeners {
    public static void initialize()
    {
        UseItemListeners.initialize();
        UseBlockListeners.initialize();
        Ssmc.LOGGER.info("Registering " + Ssmc.MOD_ID + " Listeners");
    }
}
