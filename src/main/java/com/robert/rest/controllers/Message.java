package com.robert.rest.controllers;

/**
 * Created by work on 1/18/15.
 */
//Must Have a getter or public fields for json conversion to work
public class Message {

    private String value;


    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
