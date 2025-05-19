package com.sverinn.ssmc.tiles;

import com.sverinn.ssmc.object.item.ModItem;
import com.sverinn.ssmc.object.item.ModItems;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;

import java.util.List;

/**
 * Example:
 * - type: tile
 *   id: Plating
 *   name: tiles-plating
 *   sprite: /Textures/Tiles/plating.png
 *   baseTurf: Lattice
 *   isSubfloor: true
 *   footstepSounds:
 *     collection: FootstepPlating
 *   friction: 1.5
 *   heatCapacity: 10000
 */
public abstract class Tile {
    private String type;
    private String id;
    private String name;
    private String sprite;
    private String baseTurf;
    private boolean isSubfloor;
    private SoundEvent footstepSoundEvent;
    private double friction;
    private int heatCapacity;
    private Integer variants;
    private List<Double> placementVariants;
    private boolean weather;
    private boolean isSpace;
    private Item itemDrop = ModItems.PART_ROD_METAL;
    private int mass;
    private List<String> deconstructTools;

    // Геттеры и сеттеры
    // ...
}