package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {


        String type = System.getProperty("type", "int");

        makeIntValue();


    }

    private static void makeIntValue() {
        Properties properties = new ReadFile().getAppProperties();
        int minNumber = Integer.parseInt(properties.getProperty("min-number"));
        int maxNumber = Integer.parseInt(properties.getProperty("max-number"));
        int increment = Integer.parseInt(properties.getProperty("increment"));
        List<Integer> list = new ArrayList<>();
        while (maxNumber >= minNumber) {
            list.add(minNumber);
            minNumber = minNumber + increment;
        }
        System.out.println(" # " + list);
        list.forEach(row -> {
            List<Integer> listRow = new ArrayList<>();
            list.forEach(col -> {
                listRow.add(row * col);
            });
            System.out.println("[" + row + "] " + listRow);
        });
    }


}