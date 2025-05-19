package com.sverinn.ssmc.audio;

import com.sverinn.ssmc.Ssmc;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static java.lang.System.in;

public class SoundCollectionRegistry {
    private Map<String, SoundCollection> soundCollections;
    public void register(String id, List<Path> paths)
    {
        for (Path path : paths)
        {
            String key = path.getFileName().toString();
            Identifier identifier = new Identifier(Ssmc.MOD_ID, key);
            Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
            SoundDefinitionManager.addSoundDefinition(identifier, "sound.ssmc." + key, path);
        }
    }

    public SoundCollection get(String id)
    {
        return this.soundCollections.get(id);
    }
}
