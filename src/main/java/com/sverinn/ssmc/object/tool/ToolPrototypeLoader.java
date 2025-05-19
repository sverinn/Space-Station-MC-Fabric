package com.sverinn.ssmc.object.tool;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ToolPrototypeLoader {
    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());

    public static List<ToolPrototype> loadToolPrototypes(Path filePath) throws IOException {
        return YAML_MAPPER.readValue(
                filePath.toFile(),
                new TypeReference<List<ToolPrototype>>() {}
        );
    }
}