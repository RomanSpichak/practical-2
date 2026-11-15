package com.shpp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class v2_App extends v2_SerializationString {


    private static final Logger log = LoggerFactory.getLogger(v2_App.class);

    public static void main(String[] args) {

        HashMap<String, String> config = v2_ConfigLoader.getApplicationConfig();

        String table = v2_TableBuilder.getTableInString(config);

        String serialized = v2_SerializationString.getSerialized(table);

        log.info(serialized);
    }


}
