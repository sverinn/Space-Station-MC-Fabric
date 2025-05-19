package com.sverinn.ssmc.effects;

import com.sverinn.ssmc.Ssmc;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Custom StatusEffects
 */
public class ModStatusEffects {
    public static final StatusEffect HONK_EFFECT = new HonkStatusEffect();

    public static void initialize() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier("ssmc", "honk"), HONK_EFFECT);
        Ssmc.LOGGER.info("Registering " + Ssmc.MOD_ID + " Status Effects");
    }
}
