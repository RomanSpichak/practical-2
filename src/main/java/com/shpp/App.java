package com.shpp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

import static com.shpp.Constants.*;

public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        HashMap<String, String> appConfig = Config.getAppConfig();

        if (Validation.isValidProps(appConfig)) {
            log.error("Some properties has illegal values: {}", appConfig);
            return;
        }
        StringBuilder builder = Table.getTable(appConfig);

        log.info(builder.toString());
    }

}
