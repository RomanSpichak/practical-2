package com.shpp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;



public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("The application was launched with the following arguments: {}", Arrays.toString(args));

        String userName = new LoadAppProperties().loadUserName();
        logger.info("User read, name: {}", userName);

        Message toConsole = new Message("Привіт " + userName + " !!!");
        String format = System.getProperty("format", "json");
        logger.info("Selected form: {}", format);

        ObjectMapper mapper = "xml".equals(format) ? new XmlMapper() : new ObjectMapper();
        String outputToConsole = "";
        try {
            outputToConsole = mapper.writeValueAsString(toConsole);
        } catch (JsonProcessingException e) {
            logger.error("Error while serializing object to format: {}", format, e);
        }
        System.out.println("outputToConsole: " + outputToConsole);
        logger.info("The application has stopped working");
    }

}