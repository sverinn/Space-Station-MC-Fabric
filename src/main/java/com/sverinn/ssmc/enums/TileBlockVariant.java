package com.sverinn.ssmc.enums;

import net.minecraft.util.StringIdentifiable;

/**
 * BlockStates for TILE block.
 * DARK = 0
 */
public enum TileBlockVariant implements StringIdentifiable {
    DARK("dark"),
    WHITE("white"),
    GLASS("glass"),
    RGLASS("rglass");

    private final String name;

    public String asString()
    {
        return this.name;
    }

    /**
     * Try with .toUpperCase()
     * @param name
     */
    TileBlockVariant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}