package com.shpp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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
    @DisplayName("Should return false if increment and maximum are not equal values")
    void shouldReturnFalseIfIncrementAndMaximumIsEqualValues() {
        boolean isEqualValues = new BigDecimal(inc).compareTo(new BigDecimal(max)) == 0;
        assertFalse(isEqualValues, "Increment and maximum are equal values");
    }

    @Test
    @DisplayName("Should return false if minimum and maximum are not equal values")
    void shouldReturnFalseIfMinimumAndMaximumAreNotEqualValues() {
        boolean isEqualValues = new BigDecimal(min).compareTo(new BigDecimal(max)) == 0;
        assertFalse(isEqualValues, "Minimum and maximum  are equal values");
    }

    @Test
    @DisplayName("Should return false if increment not less by zero")
    void shouldReturnTrueIfIncrementNotLessByZero() {
        boolean isLessByZero = new BigDecimal(inc).signum() < 0;
        assertFalse(isLessByZero, "Increment value should be more by zero");
    }

    @Test
    @DisplayName("Should return false if maximum not less by zero")
    void shouldReturnTrueIfMaximumNotLessByZero() {
        boolean isLessByZero = new BigDecimal(max).signum() < 0;
        assertFalse(isLessByZero, "Maximum value should be more by zero");
    }

    @Test
    @DisplayName("Should return false if minimum not less by zero")
    void shouldReturnTrueIfMinimumNotLessByZero() {
        boolean isLessByZero = new BigDecimal(min).signum() < 0;
        assertFalse(isLessByZero, "Minimum value should be more by zero");
    }

    @Test
    @DisplayName("Should return false if increment not equals zero")
    void shouldReturnFalseIfIncrementNotEqualsZero() {
        boolean isEqualsZero = new BigDecimal(inc).signum() == 0;
        assertFalse(isEqualsZero, "Increment should be not zero value");
    }

    @Test
    @DisplayName("Should return true if maximum equals zero")
    void shouldReturnTrueIfMaximumEqualsZero() {
        boolean isEqualsZero = new BigDecimal(max).signum() == 0;
        assertFalse(isEqualsZero, "Maximum should be not zero value");
    }

}