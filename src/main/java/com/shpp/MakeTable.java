package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MakeTable {

    private final static String INT = "int";
    private final static String DOUBLE = "double";
    private final static String FLOAT = "float";
    private final static String LONG = "long";
    private final static String MAXIMUM = "max.number";
    private final static String MINIMUM = "min.number";
    private final static String INCREMENT = "increment";
    private static final Logger LOGGER = LoggerFactory.getLogger(MakeTable.class);


    public static String integerTable(Properties properties, String type) {

        int minimum = 0, maximum = 0, increment = 0;
        try {
            minimum = Integer.parseInt(properties.getProperty(MINIMUM));
            maximum = Integer.parseInt(properties.getProperty(MAXIMUM));
            increment = Integer.parseInt(properties.getProperty(INCREMENT));
            LOGGER.debug("Minimum, maximum, increment are added");
        } catch (NumberFormatException e) {
            LOGGER.error("Invalid number format exception");
        }
        List<Integer> numbers = new ArrayList<>();
        if (minimum != maximum || increment != 0) {
            while (maximum >= minimum) {
                numbers.add(minimum);
                minimum = minimum + increment;}}

        StringBuilder builder = new StringBuilder();
        builder.append("minimum:").append(properties.getProperty(MINIMUM));
        builder.append(" maximum:").append(properties.getProperty(MAXIMUM));
        builder.append(" increment:").append(properties.getProperty(INCREMENT));
        builder.append("\n").append(String.format("%4s", "❌"));

        if (!numbers.isEmpty()) {
            numbers.forEach(number -> {
                builder.append(String.format("%5d", number));}); // tittle row
            builder.append("\n");
            numbers.forEach(row -> {
                builder.append(String.format("%5d", row)); // first row element
                numbers.forEach(col -> {
                    builder.append(String.format("%5d", row * col));});
                builder.append("\n");});}
        return builder.toString();
    }

}
