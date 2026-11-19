package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;

import static com.shpp.Constants.*;

public class Validation {

    private static final Logger log = LoggerFactory.getLogger(Validation.class);


    public static boolean isValidProps(HashMap<String, String> appConfig) {
        if (!appConfig.get(APP_NAME).equalsIgnoreCase(CORRECT_APP_NAME)) {
            return false;
        }
        if (!appConfig.get(GREETING).equalsIgnoreCase(CORRECT_EXTERNAL) ||
                !appConfig.get(GREETING).equalsIgnoreCase(CORRECT_INTERNAL)) {
            return false;
        }
        return !isNumbersHasIllegalValues(appConfig);
    }

    private static boolean isNumbersHasIllegalValues(HashMap<String, String> appConfig) {
        try {

            double increment = Double.parseDouble(appConfig.get(INCREMENT));
            double minimum = Double.parseDouble(appConfig.get(MINIMUM));
            double maximum = Double.parseDouble(appConfig.get(MAXIMUM));
            if (increment <= 0 || maximum <= 0 || minimum <= 0) {
                return true;
            }
            if (minimum == increment) {
                return true;
            }
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            log.error("Fail - number has illegal format: {}", e.getMessage());
            return true;
        }
    }


}
