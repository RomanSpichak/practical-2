package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class TableBuilder {


    private static final Logger log = LoggerFactory.getLogger(TableBuilder.class);
    private static final String TYPE = "type";
    private static final String DOUBLE = "double";
    private static final String FLOAT = "float";

    public static String getTableInString(Properties properties) {

        if (isCorrectData(properties)) {
            return buildTable(properties);
        }
        log.debug("Properties data is not correct");
        return "Properties data is not correct";
    }

    private static String buildTable(Properties properties) {
        StringBuilder builder = new StringBuilder();
        if (isFractionalNumber(TYPE)) {
            // code
        }
        // code
        return builder.toString();
    }

    private static boolean isFractionalNumber(String type) {
        return type.equalsIgnoreCase(DOUBLE) || type.equalsIgnoreCase(FLOAT);
    }

    private static boolean isCorrectData(Properties properties) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(TableBuilder.isFractionalNumber("short"));
    }

}
