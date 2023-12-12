package com.example.country_info_travel_app;

public class Country {
    private String name;
    private String flagUrl;

    public Country(String name, String flagUrl) {
        this.name = name;
        this.flagUrl = flagUrl;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }
}
