package com.shellucas.data;

import com.shellucas.data.utils.Continent;
import com.shellucas.data.utils.CountryFileReader;

import java.util.Map;

/**
 * @author shelby
 */
public class WorldData {

    // Each map represents a continent with key, value pairs for each country and capital in that continent respectively
    private Map<String, String> africa;
    private Map<String, String> asia;
    private Map<String, String> europe;
    private Map<String, String> northAmerica;
    private Map<String, String> southAmerica;
    private Map<String, String> australiaAndOceania;

    public WorldData() {
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

}
