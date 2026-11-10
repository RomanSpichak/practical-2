package com.shpp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MakeGreeting {


    private static final Logger LOGGER = LoggerFactory.getLogger(MakeGreeting.class);

    public String getGreeting(String userName, String format) {

        ObjectMapper mapper = format.equals("xml") ?
                new XmlMapper().enable(SerializationFeature.INDENT_OUTPUT):
                new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String output = "";
        try {
            output = mapper.writeValueAsString(" Hello " + userName + " ! ");
            LOGGER.info("Output text added to {} file", format);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error - mapper write as string = {}", e.getMessage());
        }
        return output;
    }

}
