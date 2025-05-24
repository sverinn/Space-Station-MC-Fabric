package com.sverinn.ssmc.object.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import com.sverinn.ssmc.Ssmc;
import com.sverinn.ssmc.effects.ModStatusEffects;

import java.util.function.Supplier;

//TODO: Rewrite to allow dynamic import from Prototypes
/**
 * Handles registration of all custom items and item groups for the SSMC mod.
 * Responsibilities:
 * - Creates and registers item groups
 * - Registers all custom items
 * - Manages item properties and settings
 *
 * Note: Remember to update assets/models/item and assets/textures/item when adding new items
 */
public class ModItems {
    // Constants for food components
    public static final FoodComponent HONK_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            // Duration is in ticks (20 ticks = 1 second)
            .statusEffect(new StatusEffectInstance(ModStatusEffects.HONK_EFFECT, 6 * 20, 1), 1.0f)
            .build();

    // Item Group Registry Keys
    public static final RegistryKey<ItemGroup> SSMC_FUN_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(Ssmc.MOD_ID, "fun"));
    public static final RegistryKey<ItemGroup> SSMC_STRUCTURES_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(Ssmc.MOD_ID, "structures"));
    public static final RegistryKey<ItemGroup> SSMC_TOOLS_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(Ssmc.MOD_ID, "tools"));
    public static final RegistryKey<ItemGroup> SSMC_GENERAL_ITEM_GROUP_KEY =
            RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(Ssmc.MOD_ID, "general"));

    // Registered Items
    public static final Item BANANIUM = registerItem(
            new Item(new FabricItemSettings().food(HONK_FOOD_COMPONENT)), "bananium");
    public static final Item CROWBAR = registerItem(
            new Item(new FabricItemSettings().maxCount(1).maxDamage(3)), "crowbar");
    public static final Item SHEET_STEEL = registerItem(
            new Item(new FabricItemSettings().maxCount(30)), "sheet/steel");
    public static final Item SHEET_GLASS = registerItem(
            new Item(new FabricItemSettings().maxCount(30)), "sheet/glass");
    public static final Item SHEET_RGLASS = registerItem(
            new Item(new FabricItemSettings().maxCount(30)), "sheet/rglass");
    public static final Item PART_ROD_METAL = registerItem(
            new Item(new FabricItemSettings().maxCount(30)), "objects/materials/parts.rsi/partrodmetal");
    public static final Item CUTTERS = registerItem(
            new Item(new FabricItemSettings().maxCount(1).fireproof()), "cutters");

    // Item Groups
    public static final ItemGroup SSMC_FUN_ITEM_GROUP = createItemGroup(
            SSMC_FUN_ITEM_GROUP_KEY, () -> new ItemStack(BANANIUM), "fun.ssmc");
    public static final ItemGroup SSMC_STRUCTURES_ITEM_GROUP = createItemGroup(
            SSMC_STRUCTURES_ITEM_GROUP_KEY, () -> new ItemStack(PART_ROD_METAL), "structures.ssmc");
    public static final ItemGroup SSMC_TOOLS_ITEM_GROUP = createItemGroup(
            SSMC_TOOLS_ITEM_GROUP_KEY, () -> new ItemStack(CROWBAR), "tools.ssmc");
    public static final ItemGroup SSMC_GENERAL_ITEM_GROUP = createItemGroup(
            SSMC_GENERAL_ITEM_GROUP_KEY, () -> new ItemStack(CROWBAR), "general.ssmc");

    /**
     * Helper method to create an item group with consistent settings
     *
     * @param key The registry key for the item group
     * @param iconSupplier Supplier for the group's icon
     * @param translationKey Translation key for the display name
     * @return Configured ItemGroup
     */
    private static ItemGroup createItemGroup(RegistryKey<ItemGroup> key,
                                             Supplier<ItemStack> iconSupplier,
                                             String translationKey) {
        return FabricItemGroup.builder()
                .icon(iconSupplier)
                .displayName(Text.translatable(translationKey))
                .build();
    }

    /**
     * Registers an item with the game registry
     *
     * @param item The item to register
     * @param id The string identifier for the item
     * @return The registered item
     */
    public static Item registerItem(Item item, String id) {
        Identifier itemID = new Identifier(Ssmc.MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }

    /**
     * Initializes all items and item groups
     */
    public static void initialize() {
        // Register all item groups
        Registry.register(Registries.ITEM_GROUP, SSMC_FUN_ITEM_GROUP_KEY, SSMC_FUN_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, SSMC_TOOLS_ITEM_GROUP_KEY, SSMC_TOOLS_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, SSMC_STRUCTURES_ITEM_GROUP_KEY, SSMC_STRUCTURES_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, SSMC_GENERAL_ITEM_GROUP_KEY, SSMC_GENERAL_ITEM_GROUP);

        Ssmc.LOGGER.info("Registering " + Ssmc.MOD_ID + " Items");
    }
}