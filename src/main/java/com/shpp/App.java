package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    static void main() {

        Properties appConfig = Config.getAppConfig();

        StringBuilder builder = Table.getTable(appConfig);

        if (log.isInfoEnabled()) {
            log.info(builder.toString());
        }

    }


}
