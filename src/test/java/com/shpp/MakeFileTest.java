package com.shpp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeFileTest {

    private String format;

    @BeforeEach
    void setUp() {
        format = System.getProperty("format", "json");
    }

    @Test
    @DisplayName("Should return true if format is empty")
    void shouldReturnTrueIfFormatIsEmpty() {
        boolean isEmpty = format.isEmpty();
        assertFalse(isEmpty, "Test - format can't be empty, use default json");
    }

    @Test
    @DisplayName("Should return false if format not equals xml or json")
    void shouldReturnFalseIfFormatNotEqualsXmlOrJson() {
        /*
            ХЗ вообще что тут проверяю
         */
        boolean isSupportedFormat = format.equalsIgnoreCase("xml") ||
                format.equalsIgnoreCase("json");
        assertTrue(isSupportedFormat, "Test - format is not supported, please use xml or json");
    }

}