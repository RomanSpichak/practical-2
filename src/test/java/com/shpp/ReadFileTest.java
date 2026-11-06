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
    @DisplayName("Should load application properties from external file")
    void shouldLoadApplicationPropertiesFromExternalFile() {
        Assertions.assertEquals("table", appProp.getProperty("app-name"));
        Assertions.assertEquals("1.0", appProp.getProperty("app-version"));
        Assertions.assertEquals("external", appProp.getProperty("location"));
    }

}
