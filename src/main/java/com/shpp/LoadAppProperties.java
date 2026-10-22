package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class LoadAppProperties {

    private static final Logger logger = LoggerFactory.getLogger(LoadAppProperties.class);

    public String loadUserName() {

        Properties properties = new Properties();

        java.io.File configurationFile = new java.io.File("application.properties");

        if (configurationFile.exists()) {
            try (java.io.FileReader reader = new FileReader(configurationFile, StandardCharsets.UTF_8)) {
                properties.load(reader);
                logger.info("Configuration successfully loaded from external file");
            } catch (java.io.IOException e) {
                logger.error("Error reading external properties file", e);
            }
        } else {
            try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("application.properties")) {
                if (inputStream != null) {
                    logger.debug("Internal application.properties file successfully loaded");
                    try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
                        properties.load(inputStreamReader);
                    } catch (IOException e) {
                        logger.error("Application.properties file not found: {}", e.getMessage());
                    }
                }
            } catch (IOException e) {
                logger.error("Critical error reading internal configuration file: {}", e.getMessage());
            }
        }
        return properties.getProperty("username");
    }

}
