package com.plnyyanks.tba.apiv2.models;

public class Team {
    private String
        website,
        name,
        locality,
        region,
        country_name,
        location,
        key,
        nickname;
    private int
        team_number,
        rookie_year;

    public Team(){
        // Empty default constructor
    }

    public Team(String teamKey){
        this.key = teamKey;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getTeam_number() {
        return team_number;
    }

    public void setTeam_number(int team_number) {
        this.team_number = team_number;
    }

    public int getRookie_year() {
        return rookie_year;
    }

    public void setRookie_year(int rookie_year) {
        this.rookie_year = rookie_year;
    }
}
