package com.workmotion.poc.employee.enums;

/**
 * 5/22/2021
 * CREATED BY @Ayman Alsapagh
 **/
public enum States {
    ADDED("ADDED"),
    INCHECK("IN-CHECK"),
    APPROVED("APPROVED"),
    ACTIVE("ACTIVE");

    private String value;

    private States(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
