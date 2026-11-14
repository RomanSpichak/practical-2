package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigLoader {

    private static final Logger log = LoggerFactory.getLogger(ConfigLoader.class);

    public static Properties loadProperties(String fileName) {

        Properties properties = new Properties();
        java.io.File external = new java.io.File(fileName);
        if (external.exists()) {
            try (Reader reader = new FileReader(external, StandardCharsets.UTF_8)) {
                properties.load(reader);
            } catch (IOException e) {
                log.error("Error - external file not found: {}", e.getMessage());
            }
            return properties;
        }
        try (InputStream internal = Main.class.getClassLoader().getResourceAsStream(fileName)) {
            if (internal != null) {
                properties.load(new  InputStreamReader(internal, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            log.error("Error - internal file not found: {}", e.getMessage());
        }
        return properties;
    }

}
