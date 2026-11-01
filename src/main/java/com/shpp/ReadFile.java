package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ReadFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFile.class);

    public Properties getProperties() {

        Properties properties = new Properties();
        java.io.File configurationFile = new java.io.File("application.properties");
        if (configurationFile.exists()) {
            try (java.io.FileReader reader = new FileReader(configurationFile, StandardCharsets.UTF_8)) {
                properties.load(reader);
            } catch (java.io.IOException e) {
                LOGGER.error("Error reading external properties file", e);
            }
        } else {
            try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("application.properties")) {
                if (inputStream != null) {
                    try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
                        properties.load(inputStreamReader);
                    } catch (IOException e) {
                        LOGGER.error("Application.properties file not found: {}", e.getMessage());
                    }
                }
            } catch (IOException e) {
                LOGGER.error("Critical error reading internal configuration file: {}", e.getMessage());
            }
        }
        return properties;
    }

}