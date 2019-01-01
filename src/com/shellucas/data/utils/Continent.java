package com.shellucas.data.utils;

public enum Continent {

    AFRICA("Africa"),
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    SOUTH_AMERICA("South America"),
    OCEANIA("Australia and Oceania");

    private String name;

    Continent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
