package com.sverinn.ssmc.components;

import org.apache.logging.log4j.core.layout.YamlLayout;
import org.jetbrains.annotations.Nullable;

public class PrototypeComponent {
    private String type;
    @Nullable private YamlLayout properties;

    public String getType() {
        return this.type;
    }

    public @Nullable YamlLayout getProperties() {

        return this.properties;
    }

    // Другие специфичные поля компонентов
    // ...

    // Геттеры и сеттеры
    // ...
}