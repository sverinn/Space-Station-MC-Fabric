package com.sverinn.ssmc.effects;

import com.sverinn.ssmc.Ssmc;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SsmcEffects {
    public static final StatusEffect HONK_EFFECT = new HonkEffect();

    public static void initialize() {
        Registry.register(Registries.STATUS_EFFECT, new Identifier("ssmc", "honk"), HONK_EFFECT);
        Ssmc.LOGGER.info("Registering " + Ssmc.MOD_ID + " Effects");
    }
}
