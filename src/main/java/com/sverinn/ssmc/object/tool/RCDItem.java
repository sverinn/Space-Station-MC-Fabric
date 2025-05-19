package com.sverinn.ssmc.object.tool;

import java.util.List;

public class RCDItem extends BaseToolItem {
    private int maxCharges;
    private List<String> availablePrototypes;

    public RCDItem(ToolPrototype prototype) {
        super(prototype);
        // Извлечение данных о зарядах и доступных прототипах
        prototype.getComponents().stream()
                .filter(c -> c.getType().equals("RCD"))
                .findFirst()
                .ifPresent(rcd -> this.availablePrototypes = (List<String>) rcd.getProperties().getFirst());
    }

    // Реализация функционала RCD
}