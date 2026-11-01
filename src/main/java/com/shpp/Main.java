package com.shpp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Properties properties = new ReadFile().getProperties();

        String userName = properties.getProperty("user-name");
        String format = System.getProperty("format", "json");

        ObjectMapper mapper = "xml".equals(format) ? new XmlMapper() : new ObjectMapper();
        String toConsole = "";
        try {
            toConsole = mapper.writeValueAsString("Привіт " + userName);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error while serializing object to format: {}", format, e);
        }
        LOGGER.info(toConsole);
    }

}