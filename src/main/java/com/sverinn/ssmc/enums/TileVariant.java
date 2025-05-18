package com.sverinn.ssmc.enums;

import net.minecraft.util.StringIdentifiable;

public enum TileVariant implements StringIdentifiable {
    DARK("dark"),
    WHITE("white"),
    GLASS("glass"),
    RGLASS("rglass");

    private final String name;

    public String asString()
    {
        return this.name;
    }

    TileVariant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}