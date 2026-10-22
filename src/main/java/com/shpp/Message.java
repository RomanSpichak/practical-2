package com.shpp;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Message {

    private String toConsole;

    public Message(String message) {
        this.toConsole = message;
    }

    public String getToConsole() {
        return toConsole;
    }

    public void setToConsole(String toConsole) {
        this.toConsole = toConsole;
    }

}
