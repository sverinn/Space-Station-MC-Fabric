package com.sverinn.ssmc.object.item;

import com.sverinn.ssmc.object.block.SsmcBlocks;
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
import com.sverinn.ssmc.effects.SsmcEffects;


public class SsmcItems {

    public static final RegistryKey<ItemGroup> SSMC_FUN_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(Ssmc.MOD_ID, "fun"));
    public static final ItemGroup SSMC_FUN_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SsmcItems.BANANIUM))
            .displayName(Text.translatable("fun.ssmc"))
            .build();


    public static final RegistryKey<ItemGroup> SSMC_STRUCTURES_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(Ssmc.MOD_ID, "structures"));
    public static final ItemGroup SSMC_STRUCTURES_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SsmcItems.RODS))
            .displayName(Text.translatable("structures.ssmc"))
            .build();

    public static final RegistryKey<ItemGroup> SSMC_TOOLS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(Ssmc.MOD_ID, "tools"));
    public static final ItemGroup SSMC_TOOLS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SsmcItems.CROWBAR))
            .displayName(Text.translatable("tools.ssmc"))
            .build();

    public static final RegistryKey<ItemGroup> SSMC_GENERAL_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(Ssmc.MOD_ID, "general"));
    public static final ItemGroup SSMC_GENERAL_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SsmcItems.CROWBAR))
            .displayName(Text.translatable("general.ssmc"))
            .build();

    public static final FoodComponent HONK_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(SsmcEffects.HONK_EFFECT, 6 * 20, 1), 1.0f)
            .build();

    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = new Identifier(Ssmc.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static void initialize() {
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, SSMC_FUN_ITEM_GROUP_KEY, SSMC_FUN_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, SSMC_TOOLS_ITEM_GROUP_KEY, SSMC_TOOLS_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, SSMC_STRUCTURES_ITEM_GROUP_KEY, SSMC_STRUCTURES_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, SSMC_GENERAL_ITEM_GROUP_KEY, SSMC_GENERAL_ITEM_GROUP);

        Ssmc.LOGGER.info("Registering " + Ssmc.MOD_ID + " Items");
    }

    public static final Item BANANIUM = register(
            // Ignore the food component for now, we'll cover it later in the food section.
            new Item(new FabricItemSettings().food(HONK_FOOD_COMPONENT)),
            "bananium"
    );
    public static final Item CROWBAR = register(
            // Ignore the food component for now, we'll cover it later in the food section.
            new Item(new FabricItemSettings().maxCount(1).maxDamage(3)),
            "crowbar"
    );

    public static final Item SHEET_STEEL = register(
            // Ignore the food component for now, we'll cover it later in the food section.
            new Item(new FabricItemSettings().maxCount(30)),
            "sheet/steel"
    );

    public static final Item SHEET_GLASS = register(
            // Ignore the food component for now, we'll cover it later in the food section.
            new Item(new FabricItemSettings().maxCount(30)),
            "sheet/glass"
    );

    public static final Item SHEET_RGLASS = register(
            // Ignore the food component for now, we'll cover it later in the food section.
            new Item(new FabricItemSettings().maxCount(30)),
            "sheet/rglass"
    );

    public static final Item RODS = register(
            // Ignore the food component for now, we'll cover it later in the food section.
            new Item(new FabricItemSettings().maxCount(30)),
            "rods"
    );

   //public static final Item TILE_BLOCK_ITEM = new SsmcTileBlockItem(
   //        SsmcBlocks.TILE, // Ваш блок
   //        new Item.Settings()
   //);

    //public static final Item TILE_DARK = register(
    //        // Ignore the food component for now, we'll cover it later in the food section.
    //        new Item(new FabricItemSettings().maxCount(30)),
    //        "tile/dark"
    //);
////
    //public static final Item TILE_WHITE = register(
    //        // Ignore the food component for now, we'll cover it later in the food section.
    //        new Item(new FabricItemSettings().maxCount(30)),
    //        "tile/white"
    //);
}