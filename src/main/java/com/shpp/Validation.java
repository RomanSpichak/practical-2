package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Validation {


    private static final Logger log = LoggerFactory.getLogger(Validation.class);
    private static final String APP_NAME = "app.name";
    private static final String GREETING = "greeting";
    private static final String INCREMENT = "increment";
    private static final String MINIMUM = "min.number";
    private static final String MAXIMUM = "max.number";
    private static final String CORRECT_APP_NAME = "table";
    private static final String CORRECT_GREETING_EXTERNAL = "Привіт з зовнішнього файлу";
    private static final String CORRECT_GREETING_INTERNAL = "Привіт з внутрішнього файлу";


    public static boolean isValidProps(HashMap<String, String> appConfig) {

        boolean isValidProps = true;

        if (isAppNameNotTable(appConfig.get(APP_NAME))) {
            return false;
        }
        if (isAppSupportCyrillic(appConfig.get(GREETING))) {
            return false;
        }



        return isValidProps;
    }

    private static boolean isAppSupportCyrillic(String propValue) {
        return propValue.equalsIgnoreCase(CORRECT_GREETING_EXTERNAL) ||
                propValue.equalsIgnoreCase(CORRECT_GREETING_INTERNAL);
    }

    private static boolean isAppNameNotTable(String propValue) {
        return propValue.equalsIgnoreCase(CORRECT_APP_NAME);
    }


}
