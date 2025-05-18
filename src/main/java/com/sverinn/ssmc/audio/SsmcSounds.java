package com.sverinn.ssmc.audio;

import com.sverinn.ssmc.Ssmc;
import net.fabricmc.api.ModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


/**
 * Register sounds.
 * Don't forget to update assets/sounds.json
 */
public class SsmcSounds {


    private SsmcSounds() {
        // private empty constructor to avoid accidental instantiation
    }
    // ITEM_METAL_WHISTLE is the name of the custom sound event
    // and is called in the mod to use the custom sound
    public static final SoundEvent HONK_SOUND = registerSound("honk"); // Honk sound
    public static final SoundEvent CROWBAR = registerSound("crowbar"); // Crowbar sound
    public static final SoundEvent WRENCH = registerSound("wrench");
    public static final SoundEvent GENHIT = registerSound("genhit");
    public static final SoundEvent CUTTERS = registerSound("wirecutter");

    // actual registration of all the custom SoundEvents
    private static SoundEvent registerSound(String id) {
        Identifier identifier = new Identifier(Ssmc.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    // This static method starts class initialization, which then initializes
    // the static class variables (e.g. ITEM_METAL_WHISTLE).
    public static void initialize() {
        Ssmc.LOGGER.info("Registering " + Ssmc.MOD_ID + " Sounds");
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized
    }
}