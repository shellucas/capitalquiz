package com.shellucas.data.utils;

import quiz.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shelby
 */
public class CountryFileReader {

    private static final String PATH = "/capitals/capitals_";
    private InputStream inputStream;

    public CountryFileReader() {
    }

    public Map<String, String> getCountriesAndCapitals(Continent continent) {
        setContinent(continent);

        Map<String, String> countries = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] country = line.split(" - ");
                countries.put(country[0], country[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }git 
        return countries;
    }

    private void setContinent(Continent continent) {
        URL inputUrl = Main.class.getResource(PATH + continent.name().toLowerCase());
        try {
            this.inputStream = inputUrl.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
