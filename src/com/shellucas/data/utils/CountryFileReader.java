package com.shellucas.data.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shelby
 */
public class CountryFileReader {

    private Path file;

    public CountryFileReader() {
    }

    public Map<String, String> getCountriesAndCapitals(Continent continent) {
        setContinent(continent);

        Map<String, String> countries = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] country = line.split(" - ");
                countries.put(country[0], country[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }

    private void setContinent(Continent continent) {
        String BASE_URL = "src/com/shellucas/data/resources/";
        String url = BASE_URL;
        switch (continent) {
            case AFRICA: url += "capitals_africa"; break;
            case ASIA: url += "capitals_asia"; break;
            case EUROPE: url += "capitals_europe"; break;
            case NORTH_AMERICA: url += "capitals_north_america"; break;
            case SOUTH_AMERICA: url += "capitals_south_america"; break;
            case OCEANIA: url += "capitals_oceania"; break;
        }
        this.file = Paths.get(url);
    }
    
    
}
