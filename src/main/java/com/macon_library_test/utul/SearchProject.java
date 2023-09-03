package com.macon_library_test.utul;

public class SearchProject {

    private String number;
    private String title;
    private String country;
    private String region;
    private String city;
    private String client;
    private String segment;
    private String type;
    private String period;

    public SearchProject() {
    }

    public SearchProject(String number, String title, String country, String region, String city, String client, String segment, String type, String period) {
        this.number = number;
        this.title = title;
        this.country = country;
        this.region = region;
        this.city = city;
        this.client = client;
        this.segment = segment;
        this.type = type;
        this.period = period;
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

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
