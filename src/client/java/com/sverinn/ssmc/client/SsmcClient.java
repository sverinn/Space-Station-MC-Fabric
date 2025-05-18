package com.sverinn.ssmc.client;

import com.sverinn.ssmc.Ssmc;
import com.sverinn.ssmc.enums.TileVariant;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

import static com.sverinn.ssmc.object.block.SsmcBlocks.LATTICE;
import static com.sverinn.ssmc.object.block.SsmcBlocks.TILE;

public class SsmcClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        // Make it so the texture is different for each TILE BlockState
        ModelPredicateProviderRegistry.register(
                new Identifier("ssmc", "variant"),
                (stack, world, entity, seed) -> {
                    NbtCompound nbt = stack.getNbt();
                    if (nbt != null && nbt.contains("BlockStateTag")) {
                        String variant = nbt.getCompound("BlockStateTag").getString("variant");
                        return TileVariant.valueOf(variant.toUpperCase()).ordinal();
                    }
                    return 0; // Default variant (dark)
                }
        );
        // Make the texture cutout like grass or leaves
        BlockRenderLayerMap.INSTANCE.putBlock(LATTICE, RenderLayer.getCutout());
        // Make the texture translucent like glass
        BlockRenderLayerMap.INSTANCE.putBlock(TILE, RenderLayer.getTranslucent());
    }
}
