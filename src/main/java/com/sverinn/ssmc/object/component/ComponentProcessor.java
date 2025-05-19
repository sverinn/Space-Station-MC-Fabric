package com.sverinn.ssmc.object.component;

import java.util.List;

public class ComponentProcessor {

    public static List<String> getToolQualities(PrototypeComponent component) {
        if (component.getType().equals("Tool") && component.getProperties() != null) {
            return (List<String>) component.getProperties().getFirst();
        }
        return List.of();
    }

    // Другие методы обработки компонентов
}
