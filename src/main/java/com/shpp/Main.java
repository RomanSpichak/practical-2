package com.shpp;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.NumberType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.naming.ldap.Control;
import javax.naming.ldap.HasControls;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;


public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        String typeOfNumbers = System.getProperty("type", "int");
        Properties properties = new ReadFile().getAppProperties();


    }

    
}