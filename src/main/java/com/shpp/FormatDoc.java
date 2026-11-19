package com.shpp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

import static com.shpp.Constants.*;

public class FormatDoc {

    private static final Logger log = LoggerFactory.getLogger(FormatDoc.class);

    public static String makeFilaAsString(StringBuilder builder, HashMap<String, String> appConfig) {

        boolean isXML = appConfig.get(FORMAT).equalsIgnoreCase("xml");
        ObjectMapper mapper = isXML ? new XmlMapper() : new ObjectMapper();
        String doc = "";
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            JsonNode node = mapper.readTree(builder.toString());
            doc = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
        } catch (JsonProcessingException e) {
            log.error("FormatDoc - fail when making serialization {}", e.getMessage());
        }
        return doc;
    }

}
