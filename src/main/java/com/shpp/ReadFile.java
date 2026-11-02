package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

public class ReadFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFile.class);

    public Properties getAppProperties() {
        Properties properties = new Properties();
        java.io.File external = new java.io.File("application.properties");
        InputStream internal = Main.class.getClassLoader().getResourceAsStream("application.properties");
        if (external.exists()) {
            try {
                properties.load(new FileReader(external, StandardCharsets.UTF_8));
            } catch (IOException e) {
                LOGGER.error("Error reading external properties file: {}", e.getMessage());
            }
        } else if (internal != null) {
            try {
                properties.load(new InputStreamReader(internal, StandardCharsets.UTF_8));
            } catch (IOException e) {
                LOGGER.error("Error reading internal properties file: {}", e.getMessage());
            }
        }
        return properties;
    }

    public List<Number> getNumbers(String typeOfNumbers) {

        Number number;
        return null;
    }

}