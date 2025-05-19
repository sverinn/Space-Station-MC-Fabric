package com.sverinn.ssmc.object.component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sverinn.ssmc.util.Sound;

import java.util.List;
import java.util.Map;

public class PrototypeComponent {
    private String type;
    private Map<String, Object> properties;

    @JsonProperty("sound")
    private Sound soundData;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("sprite")
    private String sprite;

    public String getType() {
        return this.type;
    }

    public <E> List<E> getProperties() {

        return List.of();
    }

    // Другие специфичные поля компонентов
    // ...

    // Геттеры и сеттеры
    // ...
}