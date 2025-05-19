package com.sverinn.ssmc.object.block;

import com.sverinn.ssmc.enums.TileBlockVariant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import static com.sverinn.ssmc.object.block.ModBlocks.TILE;


/**
 * TILE Block class with multiple blockstate. Each blockstate has its own custom drop and model.
 * What is common across blockstates of this block: Tool interaction logic, model geometry.
 */
public class TileBlock extends Block {
    public static final EnumProperty<TileBlockVariant> TILE_VARIANT = EnumProperty.of("variant", TileBlockVariant.class);

    public TileBlock(Settings settings) {
        super(settings);
        // Устанавливаем состояние по умолчанию
        this.setDefaultState(this.getStateManager().getDefaultState().with(TILE_VARIANT, TileBlockVariant.DARK));
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
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        // Проверяем что блок действительно заменяется (а не просто обновляется)
        if (!state.isOf(newState.getBlock())) {
            if (!world.isClient()) {
                // Получаем вариант блока (с защитой от null)
                String variant = state.get(TILE_VARIANT).asString();

                // Создаем предмет
                ItemStack itemStack = new ItemStack(TILE);

                // Устанавливаем NBT только если вариант не дефолтный
                NbtCompound tag = new NbtCompound();
                NbtCompound blockStateTag = new NbtCompound();
                blockStateTag.putString("variant", variant.toUpperCase());
                tag.put("BlockStateTag", blockStateTag);
                itemStack.setNbt(tag);

                float y = pos.getY()+0.7f;

                // Дропаем с небольшим случайным смещением
                ItemScatterer.spawn(world, pos.getX(), y, pos.getZ(), itemStack);
            }
        }

        //noinspection deprecation
        super.onStateReplaced(state, world, pos, newState, moved);
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
