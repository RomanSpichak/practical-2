package com.shpp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Properties;

public class ReadFileTest {

    private Properties appProp;

    @BeforeEach
    void init () {
        appProp = new ReadFile().getAppProperties();
    }

    @Test
    @DisplayName("Should return no empty properties")
    void shouldReturnNoEmptyProperties() {
        Assertions.assertFalse(appProp.isEmpty());
    }

    @Test
    @DisplayName("Should load application properties")
    void shouldLoadApplicationProperties() {
        Assertions.assertEquals("table", appProp.getProperty("app-name"));
    }

    @Test
    @DisplayName("Should return Cyrillic greeting")
    void shouldReturnCyrillicGreeting() {
        Assertions.assertEquals("Привіт", appProp.getProperty("greeting"));
    }

}
