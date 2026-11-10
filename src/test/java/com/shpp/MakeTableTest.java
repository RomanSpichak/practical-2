package com.shpp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class MakeTableTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MakeTableTest.class);
    private Properties properties;

    @BeforeEach
    void setUp() {
        properties = new ReadFile().getAppProperties();
    }

    @Test
    @DisplayName("Should return false if application properties is empty")
    void shouldReturnFalseIfApplicationPropertiesIsEmpty() {
        assertFalse(properties.isEmpty(), "Fail - application properties is empty ...");
    }

    // method to checking value is digit
    private boolean isDigit(Properties property, String propertyKey) {
        boolean result = false;
        try {
            Integer.parseInt(property.getProperty(propertyKey));
            result = true;
        } catch (NumberFormatException e) {
            LOGGER.error("Fail - must be a number {}", e.getMessage());
        }
        return result;
    }

    @Test
    @DisplayName("Should return true increment is digit")
    void shouldReturnIncrementIsDigit() {
        boolean incrementIsDigit = isDigit(properties, "increment");
        assertTrue(incrementIsDigit, "Fail - increment value must be digit");
    }

    @Test
    @DisplayName("Should return true min.number is digit")
    void shouldReturnMinNumberIsDigit() {
        boolean minNumberIsDigit = isDigit(properties, "min.number");
        assertTrue(minNumberIsDigit, "Fail - min-number value must be digit");
    }

    @Test
    @DisplayName("Should return true max.number is digit")
    void shouldReturnMaxNumberIsDigit() {
        boolean maxNumberIsDigit = isDigit(properties, "max.number");
        assertTrue(maxNumberIsDigit, "Fail - max-number value must be digit");
    }

    @Test
    @DisplayName("Should return true value more than zero")
    void shouldReturnIntegerValueMoreThanZero() {
        boolean isMoreThanZero = Integer.parseInt(properties.getProperty("increment")) > 0;
        assertTrue(isMoreThanZero, "Fail - increment must be more than zero");
    }

}