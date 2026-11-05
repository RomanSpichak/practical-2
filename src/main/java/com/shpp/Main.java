package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        String type = System.getProperty("type", "int");
        Properties properties = new ReadFile().getAppProperties();

        switch (type) {
            case "int": new MakeTable().getInteger(properties); break;
            case "double": new MakeTable().getDouble(properties);break;
            case "float": new MakeTable().getFloat(properties); break;
            case "long": new MakeTable().getLong(properties); break;
        }

    }

}