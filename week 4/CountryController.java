package com.example.countrywebservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Map<String, Country> countries = new HashMap<>();

    static {
        countries.put("in", new Country("in", "India"));
        countries.put("us", new Country("us", "United States"));
        countries.put("uk", new Country("uk", "United Kingdom"));
        countries.put("jp", new Country("jp", "Japan"));
    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {
        return countries.getOrDefault(code.toLowerCase(), new Country("NA", "Country not found"));
    }
}
