package com.shpp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


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
        boolean appPropIsEmpty = properties.isEmpty();
        Assertions.assertFalse(appPropIsEmpty);
    }

    /**
     * TODO
     *  Need test to:
     *  - increment not equals 0
     *  - min-max-increment properties has number format
     */
    
}
