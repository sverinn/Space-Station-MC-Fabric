package com.sverinn.ssmc.components;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class PrototypeLoader {
    public static void load() {
        // Путь к вашему YAML-файлу
        String filePath = "path/to/your/file.yaml";

        // Создаем экземпляр Yaml
        Yaml yaml = new Yaml();

        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {

            Map<String, Object> data = yaml.load(inputStream);
            System.out.println("Loaded YAML: " + data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}