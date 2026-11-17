package com.shpp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        HashMap<String, String> appConfig = Config.getAppConfig();

        if (Validation.isNotValidProps(appConfig)) {
            log.error("Some properties has illegal values: {}", appConfig);
            return;
        }

        StringBuilder numbersTable = BuildTable.getTableAsString(appConfig);

        System.out.println("numbersTable = " + numbersTable);

        String tableFormatDoc = DocFormat.getTableFormatDoc(numbersTable);

    }


}
