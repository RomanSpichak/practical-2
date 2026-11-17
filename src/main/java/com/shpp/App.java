package com.shpp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class App {


    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        HashMap<String, String> appConfig = Config.geAppConfig();

//        String table = v2_TableBuilder.getTableInString(config);

//        String serialized = v2_SerializationString.getSerialized(table);

//        log.info(serialized);
    }


}
