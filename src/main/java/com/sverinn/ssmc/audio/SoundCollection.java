package com.sverinn.ssmc.audio;

import com.sverinn.ssmc.Ssmc;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.math.random.LocalRandom;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static net.minecraft.command.argument.BlockPosArgumentType.getBlockPos;

public class SoundCollection {
    SoundEvent soundEvent;
    public void register(String[] id)
    {
        Identifier identifier = new Identifier(Ssmc.MOD_ID, id[0]);
        Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }
}
