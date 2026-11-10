package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Application -= table =- Started");

        Properties properties = new ReadFile().getAppProperties();
        String userName = properties.getProperty("user.name");
        LOGGER.info("User name loaded = {}", userName);
        String greeting = properties.getProperty("greeting");

        String format = System.getProperty("format", "json");
        LOGGER.info("Format loaded = {}", format);
        String type = System.getProperty("type", "int");
        LOGGER.info("Type loaded = {}", type);

        String toFile = greeting + " " + userName + " !";
        String file = new MakeFile().getFile(toFile, format);
        LOGGER.info("Greeting: {}", file);

        LOGGER.info("Table multiply making ...");
        new MakeTable().getTable(properties, type);

        LOGGER.info("Application -= table =- Finished");
    }

}