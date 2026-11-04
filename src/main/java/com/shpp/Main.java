package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        HashMap<String, IChangeType> changeTypeMap = new ChangeType().getMap();
        HashMap<String, String> appProperties = new ReadFile().getAppProperties();

        System.out.println("appProperties " + appProperties);

        List<Number> numbersToTable = new ArrayList<>();
    }

    
}