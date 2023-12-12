package com.example.country_info_travel_app;

public class Country {
    private String name;
    private String flagUrl;
    private String capital;
    private int population;
    private double area;
    private String region;
    private String subregion;

    public Country(String name, String flagUrl, String capital, int population, double area, String region, String subregion) {
        this.name = name;
        this.flagUrl = flagUrl;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.region = region;
        this.subregion = subregion;
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

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }
}
