package com.shpp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    private Properties properties;
    private static final String EXTERNAL = "Привіт з зовнішнього файлу";
    private static final String INTERNAL = "Привіт з внутрішнього файлу";
    private static final String GREETING = "greeting";

    @BeforeEach
    void setUp() {
        properties = x_ReadFile.getAppProperties();
    }

    @Test
    @DisplayName("Should return false if properties is not empty")
    void shouldReturnFalseIfPropertiesIsNotEmpty() {
        assertFalse(properties.isEmpty(), () -> "Fail - properties is empty ...");
    }

    @Test
    @DisplayName("Should return application name = table")
    void shouldReturnApplicationNameTable() {
        String appName = properties.getProperty("app.name");
        assertEquals("table", appName, () -> "Fail - application name ...");
    }

    @Test
    @DisplayName("Should return true if read Cyrillic alphabet")
    void shouldReturnTrueIfReadCyrillicAlphabet() {
        boolean isExternal = properties.getProperty(GREETING).equalsIgnoreCase(EXTERNAL);
        boolean isInternal = properties.getProperty(GREETING).equalsIgnoreCase(INTERNAL);
        assertTrue(isExternal || isInternal);
    }

}