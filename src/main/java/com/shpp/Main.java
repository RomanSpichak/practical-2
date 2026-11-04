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
        Properties properties = new ReadFile().getAppProperties();

        makeIntegerTable(properties);
        makeDoubleTable(properties);

    }

    private static void makeDoubleTable(Properties properties) {
        double minNumber = Double.parseDouble(properties.getProperty("min-number"));
        double maxNumber = Double.parseDouble(properties.getProperty("max-number"));
        double increment = Double.parseDouble(properties.getProperty("increment"));
        List<Double> list = new ArrayList<>();
        while (maxNumber >= minNumber) {
            list.add(minNumber);
            minNumber = minNumber + increment;
        }
        System.out.println(" # " + list);
        list.forEach(row -> {
            List<Double> listRow = new ArrayList<>();
            list.forEach(col -> {
                listRow.add(row * col);
            });
            System.out.println("[" + row + "] " + listRow);
        });
    }

    private static void makeIntegerTable(Properties properties) {
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