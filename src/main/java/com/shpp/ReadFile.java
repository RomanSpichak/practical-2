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

    public static List<AppProp> getList(Properties properties) {
        List<AppProp> list = new ArrayList<>();
        list.add(new AppProp(MINIMUM,
                Integer.parseInt(properties.getProperty(MINIMUM)),
                Double.parseDouble(properties.getProperty(MINIMUM)),
                Float.parseFloat(properties.getProperty(MINIMUM)),
                Long.parseLong(properties.getProperty(MINIMUM))));
        list.add(new AppProp(MAXIMUM,
                Integer.parseInt(properties.getProperty(MAXIMUM)),
                Double.parseDouble(properties.getProperty(MAXIMUM)),
                Float.parseFloat(properties.getProperty(MAXIMUM)),
                Long.parseLong(properties.getProperty(MAXIMUM))));
        list.add(new AppProp(INCREMENT,
                Integer.parseInt(properties.getProperty(INCREMENT)),
                Double.parseDouble(properties.getProperty(INCREMENT)),
                Float.parseFloat(properties.getProperty(INCREMENT)),
                Long.parseLong(properties.getProperty(INCREMENT))));
        return list;
    }


}