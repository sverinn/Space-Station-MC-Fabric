package com.sverinn.ssmc.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.sound.SoundCategory;

import java.util.Random;

import static com.sverinn.ssmc.audio.ModSoundEvents.BIKEHORN;

/**
 * Honk honk
 */
public class HonkStatusEffect extends StatusEffect {
    protected HonkStatusEffect() {
        // category: StatusEffectCategory - describes if the effect is helpful (BENEFICIAL), harmful (HARMFUL) or useless (NEUTRAL)
        // color: int - Color is the color assigned to the effect (in RGB)
        super(StatusEffectCategory.NEUTRAL, 0xe9b8b3);
    }

    // Called every tick to check if the effect can be applied or not
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the effect every tick
        return duration % 37 < amplifier;
    }

    // Called when the effect is applied
    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient) {
            entity.getWorld().playSound(null, entity.getBlockPos(), BIKEHORN, SoundCategory.MASTER, 1f * amplifier, 0.5f + new Random().nextFloat()); // Higher amplifier gives you experience faster
        }
    }
}
