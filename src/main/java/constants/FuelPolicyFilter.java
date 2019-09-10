package constants;

public enum FuelPolicyFilter {

    FULL_TO_FULL("fullfull"),
    QUARTER_TO_QUARTER("quarterquarter"),
    SAME_TO_SAME("samesame");

    private String type;

    FuelPolicyFilter(String type){
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
