package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;

import static com.shpp.Constants.*;

public class BuildTable {

    private static final Logger log = LoggerFactory.getLogger(BuildTable.class);

    public static StringBuilder getTableAsString(HashMap<String, String> appConfig) {

        StringBuilder builder = new StringBuilder(
                appConfig.get(GREETING + " " +
                        appConfig.get(USER_NAME)));
        try {
            var increment = new BigDecimal(appConfig.get(INCREMENT));
            var minimum = new BigDecimal(appConfig.get(MINIMUM));
            var maximum = new BigDecimal(appConfig.get(MAXIMUM));
            builder.append(INCREMENT + ": ").append(increment).append("\n").
                    append(MINIMUM + ": ").append(minimum).append("\n").
                    append(MAXIMUM + ": ").append(maximum).append("\n");

        } catch (NumberFormatException | NullPointerException e) {
            log.error("Fail - number has illegal format: {}", e.getMessage());
        }

        return builder;
    }




}
