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
        String type = System.getProperty("type", "int");
        Properties properties = new ReadFile().getAppProperties();
        LOGGER.info("Application properties loaded");

        String userName = properties.getProperty("user.name");
        String format = System.getProperty("format", "json");
        LOGGER.info("user.name loaded = {}", userName);
        LOGGER.info("format loaded = {}", format);

        ObjectMapper mapper = format.equals("xml") ?
                new XmlMapper().enable(SerializationFeature.INDENT_OUTPUT):
                new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String output = "";
        try {
            output = mapper.writeValueAsString(" Hello " + userName + " ! ");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        LOGGER.info("output => {}", output);

//        switch (type) {
//            case "int": new MakeTable().getInteger(properties); break;
//            case "double": new MakeTable().getDouble(properties);break;
//            case "float": new MakeTable().getFloat(properties); break;
//            case "long": new MakeTable().getLong(properties); break;
//        }

    }

}