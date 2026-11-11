package com.shpp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeFileTest {

    /**
     * todo
     *  String format не равна null и не пустая
     *  String format если укаазан txt или другой формат не xml/json
     *  String out что не остался пустой
     */

    private String format;

    @BeforeEach
    void setUp() {
        // Starting default
        format = System.getProperty("format", "json");
    }

    @Test
    @DisplayName("Should return false if format is no empty")
    void shouldReturnFalseIfFormatIsEmpty() {
        boolean isEmpty = format.isEmpty();
        assertFalse(isEmpty, "Test - format can't be empty, use default json");
    }

}