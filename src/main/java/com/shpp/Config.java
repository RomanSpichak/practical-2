package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;

import static com.shpp.Constants.*;

public class Config {

    private static final Logger log = LoggerFactory.getLogger(Config.class);

    public static HashMap<String, String> getAppConfig() {

        Properties properties = new Properties();
        java.io.File external = new java.io.File(APPLICATION_PROPERTIES);
        if (external.exists()) {
            try (Reader reader = new FileReader(external, StandardCharsets.UTF_8)) {
                properties.load(reader);
            } catch (IOException e) {
                log.error("Error - mistake at reading external file: {}", e.getMessage());
            }
            return getMap(properties);
        }
        try (InputStream internal = App.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES)) {
            if (internal != null) {
                properties.load(new InputStreamReader(internal, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            log.error("Error - mistake at reading internal file: {}", e.getMessage());
        }
        return getMap(properties);
    }

    private static HashMap<String, String> getMap(Properties properties) {
        HashMap<String, String> map = new HashMap<>();
        properties.stringPropertyNames().forEach(
                name -> map.put(name, properties.getProperty(name)));
        map.put(FORMAT, System.getProperty(FORMAT, DEFAULT_FORMAT));
        map.put(TYPE, System.getProperty(TYPE, DEFAULT_TYPE));
        return map;
    }

}
