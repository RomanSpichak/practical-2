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
    private static final String ZERO = "0";


    public static boolean isNotValidProps(HashMap<String, String> appConfig) {
        if (!isAppNameNotTable(appConfig.get(APP_NAME)) &&
                !isAppSupportCyrillic(appConfig.get(GREETING))) {
            return false;
        }
        return !isNumbersHasIllegalFormat(appConfig);
    }

    private static boolean isNumbersHasIllegalFormat(HashMap<String, String> appConfig) {
        if (new BigDecimal(appConfig.get(INCREMENT)).compareTo(new BigDecimal(ZERO)) > 0 ||
                new BigDecimal(appConfig.get(MINIMUM)).compareTo(new BigDecimal(appConfig.get(MAXIMUM))) > 0 ||
                new BigDecimal(appConfig.get(MAXIMUM)).compareTo(new BigDecimal(ZERO)) > -1) {
            return true;
        }
        return new BigDecimal(appConfig.get(INCREMENT)).compareTo(new BigDecimal(appConfig.get(MAXIMUM))) == 0;
    }


    private static boolean isAppSupportCyrillic(String propValue) {
        return propValue.equalsIgnoreCase(CORRECT_EXTERNAL) ||
                propValue.equalsIgnoreCase(CORRECT_INTERNAL);
    }

    private static boolean isAppNameNotTable(String propValue) {
        return propValue.equalsIgnoreCase(CORRECT_APP_NAME);
    }


}
