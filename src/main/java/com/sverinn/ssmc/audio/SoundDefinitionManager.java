package com.sverinn.ssmc.audio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.util.Identifier;

import java.nio.file.Path;
import java.util.List;

/**
 * This class provides automatic SoundEvent registration in sounds.json
 */

//TODO: Finish this
public class SoundDefinitionManager {
    private static final JsonObject soundsJson = new JsonObject();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static void addSoundDefinition(Identifier soundId, String subtitleKey, Path path) {
        JsonObject soundEntry = new JsonObject();

        soundEntry.addProperty("subtitle", subtitleKey);

        JsonArray soundsArray = new JsonArray();
        soundsArray.add("ssmc:" + path.toString());
        soundEntry.add("sounds", soundsArray);

        soundsJson.add(soundId.getPath(), soundEntry);

    }

    public static void addSoundDefinition(Identifier soundId, String subtitleKey, List<Path> paths) {
        JsonObject soundEntry = new JsonObject();

        soundEntry.addProperty("subtitle", subtitleKey);

        JsonArray soundsArray = new JsonArray();
        for (Path path : paths) {
            soundsArray.add("ssmc:" + path.toString());
        }
            soundEntry.add("sounds", soundsArray);

        soundsJson.add(soundId.getPath(), soundEntry);

    }

}
