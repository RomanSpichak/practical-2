package com.shpp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class MakeTable {

    private final static String INT = "int";
    private final static String DOUBLE = "double";
    private final static String FLOAT = "float";
    private final static String LONG = "long";
    private final static String MAXIMUM = "max.number";
    private final static String MINIMUM = "min.number";
    private final static String INCREMENT = "increment";


    private static final Logger LOGGER = LoggerFactory.getLogger(MakeTable.class);

    public static void getTable(Properties properties, String type) {
        switch (type) {
            case INT: getInteger(properties); break;
            case DOUBLE: getDouble(properties);break;
            case FLOAT: getFloat(properties); break;
            case LONG: getLong(properties); break;
        }
    }

    private static void getInteger(Properties properties) {
        if (properties != null) {
            int minNumber = Integer.parseInt(properties.getProperty(MINIMUM));
            int maxNumber = Integer.parseInt(properties.getProperty(MAXIMUM));
            int increment = Integer.parseInt(properties.getProperty(INCREMENT));
            List<Integer> list = new ArrayList<>();
            while (maxNumber >= minNumber) {
                list.add(minNumber);
                minNumber = minNumber + increment;
            }
            System.out.println("int " + list);
            list.forEach(row -> {
                List<Integer> listRow = new ArrayList<>();
                list.forEach(col -> {
                    listRow.add(row * col);
                });
                System.out.println("[" + row + "] " + listRow);
            });
        }
    }

    private static void getDouble(Properties properties) {
        if (properties != null) {
            double minNumber = Double.parseDouble(properties.getProperty("min.number"));
            double maxNumber = Double.parseDouble(properties.getProperty("max.number"));
            double increment = Double.parseDouble(properties.getProperty("increment"));
            List<Double> list = new ArrayList<>();
            while (maxNumber >= minNumber) {
                list.add(minNumber);
                minNumber = minNumber + increment;
            }
            System.out.println("double " + list);
            list.forEach(row -> {
                List<Double> listRow = new ArrayList<>();
                list.forEach(col -> {
                    listRow.add(row * col);
                });
                System.out.println("[" + row + "] " + listRow);
            });
        }
    }

    private static void getFloat(Properties properties) {
        if (properties != null) {
            float minNumber = Float.parseFloat(properties.getProperty("min.number"));
            float maxNumber = Float.parseFloat(properties.getProperty("max.number"));
            float increment = Float.parseFloat(properties.getProperty("increment"));
            List<Float> list = new ArrayList<>();
            while (maxNumber >= minNumber) {
                list.add(minNumber);
                minNumber = minNumber + increment;
            }
            System.out.println("float " + list);
            list.forEach(row -> {
                List<Float> listRow = new ArrayList<>();
                list.forEach(col -> {
                    listRow.add(row * col);
                });
                System.out.println("[" + row + "] " + listRow);
            });
        }
    }

    private static void getLong(Properties properties) {
        if (properties != null) {
            long minNumber = Long.parseLong(properties.getProperty("min.number"));
            long maxNumber = Long.parseLong(properties.getProperty("max.number"));
            long increment = Long.parseLong(properties.getProperty("increment"));
            List<Long> list = new ArrayList<>();
            while (maxNumber >= minNumber) {
                list.add(minNumber);
                minNumber = minNumber + increment;
            }
            System.out.println("long " + list);
            list.forEach(row -> {
                List<Long> listRow = new ArrayList<>();
                list.forEach(col -> {
                    listRow.add(row * col);
                });
                System.out.println("[" + row + "] " + listRow);
            });
        }
    }

    public static String integerTable(Properties properties, String type) {

        int minNumber = Integer.parseInt(properties.getProperty(MINIMUM));
        int maxNumber = Integer.parseInt(properties.getProperty(MAXIMUM));
        int increment = Integer.parseInt(properties.getProperty(INCREMENT));
        int size = maxNumber / increment;
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = minNumber;
            minNumber = minNumber + increment;
        }

        StringBuilder stringBuilder = new StringBuilder("Table with numbers ");
        stringBuilder.append(List.of(numbers)).append("\n").append(String.format("%5s", "##"));

        for (int titleNumber : numbers) {
            stringBuilder.append(String.format("%5d", titleNumber));
        }


        stringBuilder.append("\n");
        for (int row : numbers) {
            stringBuilder.append(String.format("%5d", row));
            for (int col : numbers) {
                stringBuilder.append(String.format("%5d", row * col));
            }
            stringBuilder.append("\n");
        }
        stringBuilder.delete(stringBuilder.length() -1, stringBuilder.length());
        return stringBuilder.toString();
    }

}
