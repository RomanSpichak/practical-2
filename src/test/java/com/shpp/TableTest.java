package com.shpp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    private String max, min, inc;

    @BeforeEach
    void setUp() {
        HashMap<String, String> map = Config.getAppConfig();
        min = map.get("min.number");
        max = map.get("max.number");
        inc = map.get("increment");
    }

    @Test
    @DisplayName("Should return true if increment not equals maximum")
    void shouldReturnTrueIfIncrementNotEqualsMaximum() {
        boolean isSameValue = inc.equals(max);
        assertFalse(isSameValue, "Increment and maximum equals same value");
    }

    @Test
    @DisplayName("Should return true if minimum not equals maximum")
    void shouldReturnTrueIfMinimumEqualsMaximum() {
        boolean isSameValue = min.equals(max);
        assertFalse(isSameValue, "Minimum and maximum equals same value");
    }

    @Test
    @DisplayName("Should return true if increment less by zero")
    void shouldReturnTrueIfIncrementLessByZero() {
        boolean isLessByZero = inc.startsWith("-");
        assertFalse(isLessByZero, "Increment should be positive value");
    }

    @Test
    @DisplayName("Should return true if maximum less by zero")
    void shouldReturnTrueIfMaximumLessByZero() {
        boolean isLessByZero = max.startsWith("-");
        assertFalse(isLessByZero, "Maximum should be positive value");
    }

    @Test
    @DisplayName("Should return true if minimum less by zero")
    void shouldReturnTrueIfMinimumLessByZero() {
        boolean isLessByZero = min.startsWith("-");
        assertFalse(isLessByZero, "Minimum should be positive value");
    }

    @Test
    @DisplayName("Should return true if increment equals zero")
    void shouldReturnTrueIfIncrementEqualsZero() {
        double incVal = Double.parseDouble(inc);
        boolean isEqualsZero = incVal == 0.00;
        assertFalse(isEqualsZero, "Increment should be not zero value");
    }

    @Test
    @DisplayName("Should return true if maximum equals zero")
    void shouldReturnTrueIfMaximumEqualsZero() {
        double maxVal = Double.parseDouble(max);
        boolean isEqualsZero = maxVal == 0.00;
        assertFalse(isEqualsZero, "Maximum should be not zero value");
    }

}