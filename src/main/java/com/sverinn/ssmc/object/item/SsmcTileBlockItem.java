package com.sverinn.ssmc.object.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

import static com.sverinn.ssmc.handlers.BlockPlacementHandler.handleBlockPlacement;

public class SsmcTileBlockItem extends BlockItem {

    public SsmcTileBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult place(ItemPlacementContext context) {
        // Проверяем, что это сервер (чтобы избежать двойного срабатывания)
        if (!context.getWorld().isClient()) {
            // Ваш кастомный код (например, сообщение, спавн сущности и т. д.)
            handleBlockPlacement(context);

            // Можно, например, открыть GUI:
            // ServerPlayNetworking.send((ServerPlayerEntity) player, ...);
        }

        // Отменяем стандартное размещение блока
        return ActionResult.FAIL; // FAIL предотвращает установку
    }
}