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

        StringBuilder builder = new StringBuilder().append("\n");
        builder.append(appConfig.get(GREETING)).append(" ").append(appConfig.get(USER_NAME)).append("\n");
        String type = appConfig.get(TYPE);
        if (isFactorialTypeNumbers(type)) {
            getFactorialTableNumbers(builder, appConfig, type);
        } else {
            //
        }


        return builder;
    }

    private static void getFactorialTableNumbers(StringBuilder builder,
                                                 HashMap<String, String> appConfig,
                                                 String type) {
        try {

            double min = Double.parseDouble(appConfig.get(MINIMUM));
            double max = Double.parseDouble(appConfig.get(MAXIMUM));
            double inc = Double.parseDouble(appConfig.get(INCREMENT));
            String patternTitle = getPattern(max) + "s";
            builder.append(String.format(patternTitle, "type: ")).
                    append(String.format(patternTitle, type)).append("\n").
                    append(String.format(patternTitle, " min: ")).
                    append(String.format(patternTitle, min)).append("\n").
                    append(String.format(patternTitle, " max: ")).
                    append(String.format(patternTitle, max)).append("\n").
                    append(" inc: ").append(inc).append("\n").append("\n");
            List<Double> numbers = new ArrayList<>();
            for (double i = min; i <= max ; i = i + inc) {
                numbers.add(min);
                min += inc;
            }
            if (numbers.isEmpty()) {
                log.error("List whit number to multiply is empty :{}", numbers);
                return;
            }
//            builder.append("\n").append(String.format(patternTitle, "build table ... ")).append("\n");
            String patternTable = getPattern(max) + "d";
            addHeaderToTable(numbers, patternTitle, builder);


        } catch (NumberFormatException e) {
            log.error("Error in parse string to number {}", e.getMessage());
        }
    }

    private static void addHeaderToTable(List<Double> numbers, String patternTitle, StringBuilder builder) {
        numbers.forEach(number -> builder.append(String.format(patternTitle, number)));
    }

    private static String getPattern(double max) {
       double sum = max * max;
       String string = sum + "";
       int sizeMAX = string.length() + 2; // factorial
       return "%" + sizeMAX;
    }


    private static boolean isFactorialTypeNumbers(String type) {
        return type.equalsIgnoreCase(DOUBLE) || type.equalsIgnoreCase(FLOAT);
    }


}



