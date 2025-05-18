package com.sverinn.ssmc.listeners;

import com.sverinn.ssmc.Ssmc;

/**
 * Initialize all listeners
 */
public class SsmcListeners {
    public static void initialize()
    {
        UseItemListeners.initialize();
        UseBlockListeners.initialize();
        Ssmc.LOGGER.info("Registering " + Ssmc.MOD_ID + " Listeners");
    }
}
