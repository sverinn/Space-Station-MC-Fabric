package com.sverinn.ssmc.object.tool;

import com.sverinn.ssmc.object.component.PrototypeComponent;

import java.util.List;

public class ToolPrototype {
    private String type;
    private String name;
    private String parent;
    private String id;
    private String description;
    private String suffix;
    private List<String> parentList;
    private List<PrototypeComponent> components;

    public String getId() {
        return id.toLowerCase();
    }

    public List<PrototypeComponent> getComponents() {
        // Защита от null - возвращаем пустой список вместо null
        return components != null ? components : List.of();
    }

    // Геттеры и сеттеры
    // ...
}