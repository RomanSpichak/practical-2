package com.shpp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info("Application -= table =- Started");

        Properties properties = new ReadFile().getAppProperties();
        String userName = properties.getProperty("user.name");
        LOGGER.info("user name loaded = {}", userName);

        String format = System.getProperty("format", "json");
        LOGGER.info("format loaded = {}", format);
        String type = System.getProperty("type", "int");
        LOGGER.info("type loaded = {}", type);

        String greeting = new MakeGreeting().getGreeting(userName, format);
        LOGGER.info("greeting: {}", greeting);

        LOGGER.info("Table multiply making ...");
        new MakeTable().getTable(properties, type);

        LOGGER.info("Application -= table =- Finished");
    }

}