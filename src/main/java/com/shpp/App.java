package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Application output to console table of multiply numbers
 */
public class App {


    private static final Logger log = LoggerFactory.getLogger(App.class);
    private static final String APPLICATION_PROPERTIES = "application.properties";


    public static void main(String[] args) {

        Properties properties = ConfigLoader.loadProperties(APPLICATION_PROPERTIES);
        properties.forEach((key, value) -> {
            log.info("{}: {}", key, value);});


    }


}
