package com.shpp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    private HashMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = Config.getAppConfig();
    }

    @Test
    @DisplayName("Should return no empty properties")
    void shouldReturnNoEmptyProperties() {
        boolean isEmpty = map.isEmpty();
        assertFalse(isEmpty, "Application properties is empty");
    }

    @Test
    @DisplayName("Should return app name table")
    void shouldReturnAppNameTable() {
        boolean isValidName = map.get("app.name").equalsIgnoreCase("table");
        assertTrue(isValidName, "Application name not 'table'");
    }

    @Test
    @DisplayName("Should return true if application support Cyrillic")
    void shouldReturnTrueIfAppSupportCyrillic() {
        boolean isCyrillic = map.get("greeting").contains("Привіт");
        assertTrue(isCyrillic, "Application not support Cyrillic");
    }

    @Test
    @DisplayName("Should return valid port external 8888 or internal 88")
    void shouldReturnCurrentPort() {
        boolean isValidPort = map.get("port").equals("8888") || map.get("port").equals("88");
        assertTrue(isValidPort, "Should port return external 8888 or internal 88");
    }

    @Test
    @DisplayName("Should return exception if not numeric value of increment")
    void shouldReturnExceptionIfNotNumericValueOfIncrement() {
        String inc = map.get("increment");
        assertDoesNotThrow(() -> new BigDecimal(inc), "The increment must be a numeric value");
    }

    @Test
    @DisplayName("Should return exception if not numeric value of min.number")
    void shouldReturnExceptionIfNotNumericValueOfMinNumber() {
        String min = map.get("min.number");
        assertDoesNotThrow(() -> new BigDecimal(min), "The minimum must be a numeric value");
    }

    @Test
    @DisplayName("Should return exception if not numeric value of max.number")
    void shouldReturnExceptionIfNotNumericValueOfMaxNumber() {
        String max = map.get("max.number");
        assertDoesNotThrow(() -> new BigDecimal(max), "The maximum must be a numeric");
    }

}