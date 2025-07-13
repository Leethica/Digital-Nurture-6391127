package com.example.countryapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Map<String, String> countries = new HashMap<>();

    static {
        countries.put("in", "India");
        countries.put("us", "United States");
        countries.put("uk", "United Kingdom");
        countries.put("jp", "Japan");
        countries.put("fr", "France");
    }

    @GetMapping("/countries/{code}")
    public String getCountryByCode(@PathVariable String code) {
        String country = countries.get(code.toLowerCase());
        if (country != null) {
            return country;
        } else {
            return "Country code not found!";
        }
    }
}
