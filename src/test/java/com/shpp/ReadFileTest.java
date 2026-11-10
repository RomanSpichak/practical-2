package com.shpp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    private Properties properties;

    @BeforeEach
    void setUp() {
        properties = new ReadFile().getAppProperties();
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
    @DisplayName("Should return Cyrillic greeting")
    void shouldReturnCyrillicGreeting() {
        String greeting = properties.getProperty("greeting");
        assertEquals("Привіт", greeting, () -> "Fail - greeting ...");
    }

}