package com.shpp;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static com.shpp.Constants.*;


public class Table {



    public static StringBuilder getTable(Properties appConfig) {

        var builder = new StringBuilder("\n");
        builder.append(appConfig.get(GREETING)).append(" ").
                append(appConfig.get(USER_NAME)).append("\n");

        var min = new BigDecimal(appConfig.getProperty(MINIMUM));
        var max = new BigDecimal(appConfig.getProperty(MAXIMUM));
        var inc = new BigDecimal(appConfig.getProperty(INCREMENT));

        String type = appConfig.getProperty(TYPE);

        builder.append(String.format(PATTERN, type));

        List<BigDecimal> numbers = new ArrayList<>();
        for (var i = min; i.compareTo(max) <= 0; i = i.add(inc)) {
            numbers.add(i);
            builder.append(String.format(PATTERN, i));
        }
        builder.append("\n");

        numbers.forEach(row -> {
            builder.append(String.format(PATTERN, row));
            numbers.forEach(col -> {
                builder.append(String.format(PATTERN, row.multiply(col)));
            });
            builder.append("\n");
        });

        return builder;
    }

}



