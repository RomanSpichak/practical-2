package com.shpp;

import com.sun.jdi.Type;
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
    @DisplayName("Should return value more than zero")
    void shouldReturnIntegerValueMoreThanZero() {
        int increment = Integer.parseInt(properties.getProperty("increment"));
        assertTrue(increment > 0, "Fail - increment must be more than zero");
    }


}