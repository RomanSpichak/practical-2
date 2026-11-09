package com.shpp;

import org.junit.jupiter.api.*;

import java.util.Map;
import java.util.Properties;

public class ReadFileTest {

    private Properties properties;

    @BeforeEach
    void init() {
        properties = new ReadFile().getAppProperties();
    }

    @Test
    @DisplayName("Should return no empty properties")
    void shouldReturnNoEmptyProperties() {
        boolean appPropIsEmpty = properties.isEmpty();
        Assertions.assertFalse(appPropIsEmpty);
    }

    @Test
    @DisplayName("Should load application properties")
    void shouldLoadApplicationProperties() {
        String appName = properties.getProperty("app-name");
        String expected = "table";
        Assertions.assertEquals(expected, appName);
    }

    @Test
    @DisplayName("Should return Cyrillic greeting")
    void shouldReturnCyrillicGreeting() {
        String greeting = properties.getProperty("greeting");
        String expected = "Привіт";
        Assertions.assertEquals(expected, greeting);
    }

}
