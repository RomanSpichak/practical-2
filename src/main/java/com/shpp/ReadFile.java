package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ReadFile {

    private final static String MAXIMUM = "max.number";
    private final static String MINIMUM = "min.number";
    private final static String INCREMENT = "increment";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFile.class);

    public static Properties getAppProperties() {

        Properties properties = new Properties();

        java.io.File external = new java.io.File("application.properties");
        if (external.exists()) {
            try {
                properties.load(new FileReader(external, StandardCharsets.UTF_8));
            } catch (IOException e) {
                LOGGER.error("Error reading external properties file: {}", e.getMessage());
            }
            LOGGER.debug("Properties file loaded successfully from external file");
            return properties;
        }
        try (InputStream internal = Main.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (internal != null) {
                properties.load(new InputStreamReader(internal, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            LOGGER.error("Error reading internal properties file: {}", e.getMessage());
        }
        LOGGER.debug("Properties file loaded successfully from internal file");
        return properties;
    }


}