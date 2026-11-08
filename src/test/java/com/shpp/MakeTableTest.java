package com.shpp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;
import java.util.Properties;

public class MakeTableTest {

    private Properties properties;

    @BeforeEach
    public void init(){
        properties = new ReadFile().getAppProperties();
    }

    @Test
    @DisplayName("Should return no empty app.prop")
    void shouldReturnNoEmptyAppProp() {
        Assertions.assertFalse(properties.isEmpty());
    }

    @Test
    @DisplayName("???")
    void test() {

    }

}
