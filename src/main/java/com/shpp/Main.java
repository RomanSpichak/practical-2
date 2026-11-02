package com.shpp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Properties;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        String typeOfNumbers = System.getProperty("type", "int");
        List<Number> numbers = new ReadFile().getNumbers(typeOfNumbers);

    }

}