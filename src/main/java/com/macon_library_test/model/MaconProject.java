package com.macon_library_test.model;

import javax.validation.constraints.*;

public class MaconProject {

    private int id;

    @NotEmpty(message = "Number should not be empty")
    @Size(min = 6, max = 6, message = "Number should be in 6 characters")
    private String number;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 200, message = "Title should be between 2 and 200 characters")
    private String title;

    @NotEmpty(message = "Country should not be empty")
    @Size(min = 2, max = 100, message = "Country should be between 2 and 100 characters")
    private String country;

    @NotEmpty(message = "Region should not be empty")
    @Size(min = 2, max = 100, message = "Region should be between 2 and 100 characters")
    private String region;

    @NotEmpty(message = "City should not be empty")
    @Size(min = 2, max = 100, message = "City should be between 2 and 100 characters")
    private String city;

    @NotEmpty(message = "Client should not be empty")
    @Size(min = 2, max = 100, message = "Client should be between 2 and 100 characters")
    private String client;

    @NotEmpty(message = "Market segment should not be empty")
    @Size(min = 2, max = 100, message = "Market segment should be between 2 and 100 characters")
    private String marketSegment;

    @NotNull(message = "Year should not be null")
    @Min(value = 2004, message = "Year should be more than 2004")
    private int year;

    public MaconProject() {
    }

    public MaconProject(int id, String number, String title, String country, String region, String city, String client, String marketSegment, int year) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.country = country;
        this.region = region;
        this.city = city;
        this.client = client;
        this.marketSegment = marketSegment;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMarketSegment() {
        return marketSegment;
    }

    public void setMarketSegment(String marketSegment) {
        this.marketSegment = marketSegment;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
