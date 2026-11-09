package com.shpp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class MakeTableTest {

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

    @Test
    @DisplayName("Should return true value more than zero")
    void shouldReturnIntegerValueMoreThanZero() {
        boolean isMoreThanZero = Integer.parseInt(properties.getProperty("increment")) > 0;
        assertTrue(isMoreThanZero, "Fail - increment must be more than zero");
    }

    // method to checking value is digit
    private boolean isDigit(int i) {
        return i >= 0 && i <= 9;
    }

    @Test
    @DisplayName("Should return true increment is digit")
    void shouldReturnIncrementIsDigit() {
        boolean incrementIsDigit = isDigit(Integer.parseInt(properties.getProperty("increment")));
        assertTrue(incrementIsDigit, "Fail - increment value must be digit");
    }

    @Test
    @DisplayName("Should return true min-number is digit")
    void shouldReturnMinNumberIsDigit() {
        boolean minNumberIsDigit = isDigit(Integer.parseInt(properties.getProperty("min-number")));
        assertTrue(minNumberIsDigit, "Fail - min-number value must be digit");
    }

    @Test
    @DisplayName("Should return true max-number is digit")
    void shouldReturnMaxNumberIsDigit() {
        boolean maxNumberIsDigit = isDigit(Integer.parseInt(properties.getProperty("max-number")));
        assertTrue(maxNumberIsDigit, "Fail - max-number value must be digit");
    }

}