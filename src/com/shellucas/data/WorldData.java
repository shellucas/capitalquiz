package com.shellucas.data;

import com.shellucas.data.utils.Continent;
import com.shellucas.data.utils.CountryFileReader;

import java.util.Map;

/**
 * @author shelby
 */
public class WorldData {

    private static WorldData WORLD_DATA = new WorldData();

    // Each map represents a continent with key, value pairs for each country and capital in that continent respectively
    private final Map<String, String> africa;
    private final Map<String, String> asia;
    private final Map<String, String> europe;
    private final Map<String, String> northAmerica;
    private final Map<String, String> southAmerica;
    private final Map<String, String> australiaAndOceania;

    private WorldData() {
        final CountryFileReader reader = new CountryFileReader();

        this.africa = reader.getCountriesAndCapitals(Continent.AFRICA);
        this.asia = reader.getCountriesAndCapitals(Continent.ASIA);
        this.europe = reader.getCountriesAndCapitals(Continent.EUROPE);
        this.northAmerica = reader.getCountriesAndCapitals(Continent.NORTH_AMERICA);
        this.southAmerica = reader.getCountriesAndCapitals(Continent.SOUTH_AMERICA);
        this.australiaAndOceania = reader.getCountriesAndCapitals(Continent.OCEANIA);
    }

    public Map<String, String> getAfrica() {
        return africa;
    }

    public Map<String, String> getAsia() {
        return asia;
    }

    public Map<String, String> getEurope() {
        return europe;
    }

    public Map<String, String> getNorthAmerica() {
        return northAmerica;
    }

    public Map<String, String> getSouthAmerica() {
        return southAmerica;
    }

    public Map<String, String> getAustraliaAndOceania() {
        return australiaAndOceania;
    }

    public static WorldData getWORLD_DATA() {
        return WORLD_DATA;
    }
}
