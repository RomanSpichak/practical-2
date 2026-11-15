package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;

public class v2_ConfigLoader {


    private static final Logger log = LoggerFactory.getLogger(v2_ConfigLoader.class);
    private static final String APPLICATION_PROPERTIES = "application.properties";

    public static HashMap<String, String> getApplicationConfig() {

        Properties properties = new Properties();
        java.io.File external = new java.io.File(APPLICATION_PROPERTIES);
        if (external.exists()) {
            try (Reader reader = new FileReader(external, StandardCharsets.UTF_8)) {
                properties.load(reader);
            } catch (IOException e) {
                log.error("Error - mistake at reading external file: {}", e.getMessage());
            }
            log.debug("Application properties successful load from external file: {}", properties);
            return saveAppPropToMap(properties);
        }
        try (InputStream internal = Main.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES)) {
            if (internal != null) {
                properties.load(new InputStreamReader(internal, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            log.error("Error - mistake at reading internal file: {}", e.getMessage());
        }
        log.debug("Application properties successful load from internal file: {}", properties);
        return saveAppPropToMap(properties);
    }

    private static HashMap<String, String> saveAppPropToMap(Properties properties) {
        HashMap<String, String> map = new HashMap<>();
        properties.stringPropertyNames().forEach(name -> map.put(name, properties.getProperty(name)));
        return map;
    }

    public static void main(String[] args) {
        System.out.println(v2_ConfigLoader.getApplicationConfig());
    }

}
