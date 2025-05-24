package com.sverinn.ssmc.object.block.tiles;

import com.sverinn.ssmc.enums.TileBlockVariant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import static com.sverinn.ssmc.enums.TileBlockVariant.DARK;
import static com.sverinn.ssmc.object.block.ModBlocks.TILE;


//TODO: Make this a horizontal surface only instead of full block

/**
 * TILE Block class with multiple blockstate. Each blockstate has its own custom drop and model.
 * What is common across blockstates of this block: Tool interaction logic, model geometry.
 */
public class TileBlock extends Block {
    public static final EnumProperty<TileBlockVariant> TILE_VARIANT = EnumProperty.of("variant", TileBlockVariant.class);

    public TileBlock(Settings settings) {
        super(settings);
        // Устанавливаем состояние по умолчанию
        this.setDefaultState(this.getStateManager().getDefaultState().with(TILE_VARIANT, DARK));
    }

    public static ItemStack createStackWithVariant(TileBlockVariant variant) {
        ItemStack stack = new ItemStack(TILE); // Замените на ваш блок
        NbtCompound nbt = new NbtCompound();
        NbtCompound stateTag = new NbtCompound();
        stateTag.putString("variant", variant.asString());
        nbt.put("BlockStateTag", stateTag);
        stack.setNbt(nbt);
        return stack;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TILE_VARIANT); // Добавляем наше свойство в блок
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        ItemStack stack = super.getPickStack(world, pos, state);
        NbtCompound nbt = new NbtCompound();
        NbtCompound stateTag = new NbtCompound();
        stateTag.putString("variant", state.get(TILE_VARIANT).asString());
        nbt.put("BlockStateTag", stateTag);
        stack.setNbt(nbt);
        return stack;
    }

}
