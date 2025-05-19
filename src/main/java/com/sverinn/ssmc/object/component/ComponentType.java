package com.sverinn.ssmc.object.component;

import net.minecraft.util.StringIdentifiable;

/**
 * In original it is done using reflections, but for now let's keep it simple
 */
public enum ComponentType implements StringIdentifiable {
    EMITSOUNDONLAND("EmitSoundOnLand"),
    TAG("Tag"),
    SPRITE("Sprite");

    private final String name;

    @Override
    public String asString() {
        return this.name;
    }

    ComponentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
