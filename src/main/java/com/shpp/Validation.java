package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;

public class Validation {

    private static final Logger log = LoggerFactory.getLogger(Validation.class);
    private static final String APP_NAME = "app.name";
    private static final String GREETING = "greeting";
    private static final String INCREMENT = "increment";
    private static final String MINIMUM = "min.number";
    private static final String MAXIMUM = "max.number";
    private static final String CORRECT_APP_NAME = "table";
    private static final String CORRECT_EXTERNAL = "Привіт з зовнішнього файлу";
    private static final String CORRECT_INTERNAL = "Привіт з внутрішнього файлу";


    public static boolean isNotValidProps(HashMap<String, String> appConfig) {
        if (!isAppNameNotTable(appConfig.get(APP_NAME)) &&
                !isAppSupportCyrillic(appConfig.get(GREETING))) {
            return false;
        }
        return !isNumbersHasIllegalValues(appConfig);
    }

    private static boolean isNumbersHasIllegalValues(HashMap<String, String> appConfig) {
        try {
            BigDecimal increment = new BigDecimal(appConfig.get(INCREMENT));
            BigDecimal minimum = new BigDecimal(appConfig.get(MINIMUM));
            BigDecimal maximum = new BigDecimal(appConfig.get(MAXIMUM));
            if (increment.signum() <= 0) {
                return true;
            }
            if (minimum.compareTo(maximum) > 0) {
                return true;
            }
            return increment.compareTo(maximum) == 0;
        } catch (NumberFormatException | NullPointerException e) {
            log.error("Fail - number has illegal format: {}", e.getMessage());
            return true;
        }
    }

    private static boolean isAppSupportCyrillic(String propValue) {
        return propValue.equalsIgnoreCase(CORRECT_EXTERNAL) ||
                propValue.equalsIgnoreCase(CORRECT_INTERNAL);
    }

    private static boolean isAppNameNotTable(String propValue) {
        return propValue.equalsIgnoreCase(CORRECT_APP_NAME);
    }

}
