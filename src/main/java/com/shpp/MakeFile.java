package com.shpp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MakeFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(MakeFile.class);

    public String getString(String valueToFile, String format) {

        ObjectMapper mapper = format.equals("xml") ? new XmlMapper(): new ObjectMapper();
        String out = "";
        try {
            out = mapper.writeValueAsString(valueToFile);
            LOGGER.info("Output text added to {} file", format);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error - mapper write as out = {}", e.getMessage());
        }
        return out;
    }

}
