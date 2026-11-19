package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.shpp.Constants.*;


public class Table {


    private static final Logger log = LoggerFactory.getLogger(Table.class);


    public static StringBuilder getTable(HashMap<String, String> appConfig) {

        StringBuilder builder = new StringBuilder("\n");
        builder.append(appConfig.get(GREETING)).append(" ").append(appConfig.get(USER_NAME)).append("\n");
        String type = appConfig.get(TYPE);
        if (type.equalsIgnoreCase("double") || type.equalsIgnoreCase("float")) {
            getFactorialTableNumbers(builder, appConfig, type);
        } else {
            getIntegerTableNumbers(builder, appConfig, type);
        }
        return builder;
    }

    private static void getIntegerTableNumbers(StringBuilder builder, HashMap<String, String> appConfig,
                                               String type) {
        try {
            long min = Long.parseLong(appConfig.get(MINIMUM));
            long max = Long.parseLong(appConfig.get(MAXIMUM));
            long inc = Long.parseLong(appConfig.get(INCREMENT));
            List<Long> numbers = new ArrayList<>();
            for (double i = min; i <= max; i += inc) {
                numbers.add(min);
                min += inc;
            }
            builder.append(String.format(PATTERN, type));
            numbers.forEach(number -> builder.append(String.format(PATTERN, number))); // add title row
            builder.append("\n");
            
            numbers.forEach(row -> {
                builder.append(String.format(PATTERN, row));
                numbers.forEach(col -> {
                    builder.append(String.format(String.format(PATTERN, row * col))); // add table
                });
                builder.append("\n");
            });
        } catch (NumberFormatException e) {
            log.error("Error in parse string to number {}", e.getMessage());
        }
    }

    private static void getFactorialTableNumbers(StringBuilder builder, HashMap<String, String> appConfig,
                                                 String type) {
        try {
            double min = Double.parseDouble(appConfig.get(MINIMUM));
            double max = Double.parseDouble(appConfig.get(MAXIMUM));
            double inc = Double.parseDouble(appConfig.get(INCREMENT));
            List<Double> numbers = new ArrayList<>();
            for (double i = min; i <= max; i += inc) {
                numbers.add(min);
                min += inc;
            }
            builder.append(String.format(PATTERN, type));
            numbers.forEach(number -> builder.append(String.format(PATTERN, number))); // add title row
            builder.append("\n");

            numbers.forEach(row -> {
                builder.append(String.format(PATTERN, row));
                numbers.forEach(col -> {
                    builder.append(String.format(String.format(PATTERN, row * col))); // add table
                });
                builder.append("\n");
            });
        } catch (NumberFormatException e) {
            log.error("Error in parse string to number {}", e.getMessage());
        }
    }

}



