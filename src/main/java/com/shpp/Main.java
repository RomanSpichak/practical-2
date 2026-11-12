package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.debug("Application -= table =- Started");

        Properties properties = ReadFile.getAppProperties();
        String userName = properties.getProperty("user.name");
        LOGGER.debug("User name loaded = {}", userName);
        String greeting = properties.getProperty("greeting");

        String format = System.getProperty("format", "json");
        LOGGER.debug("Format loaded = {}", format);
        String type = System.getProperty("type", "int");
        LOGGER.debug("Type loaded = {}", type);

        String string = MakeFile.getString(greeting + " " + userName, format);
        LOGGER.info("Greeting: {}", string);

        String table = MakeTable.integerTable(properties, type);
        LOGGER.info(table);

        LOGGER.debug("Application -= table =- Finished");


    }

}