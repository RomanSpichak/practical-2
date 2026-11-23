package com.shpp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    @DisplayName("Should return true if properties is no empty")
    void shouldReturnTrueIfPropertiesIsNoEmpty() {
        Properties properties = Config.getAppConfig();
        boolean isEmpty = properties.isEmpty();
        assertFalse(isEmpty, "Properties should be no empty");
    }

    @Test
    @DisplayName("Should return true if builder is no empty")
    void shouldReturnTrueIfBuilderIsNoEmpty() {
        Properties properties = Config.getAppConfig();
        StringBuilder builder = Table.getTable(properties);
        boolean isEmpty = builder.isEmpty();
        assertFalse(isEmpty, "Builder should be no empty");
    }

}