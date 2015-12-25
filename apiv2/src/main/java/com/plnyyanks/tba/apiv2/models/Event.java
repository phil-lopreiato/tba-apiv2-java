package com.plnyyanks.tba.apiv2.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class Event {
    private String
        key,
        name,
        short_name,
        event_code,
        event_type_string,
        event_district_string,
        location,
        venue_address,
        website,
        start_date,
        end_date,
        facebook_eid;


    private int
        event_type,
        event_district,
        year;

    private boolean official;
    private List<Team> teams;
    private List<Match> matches;
    private List<Award> awards;
    private JsonArray webcast;
    private JsonArray alliances;
    private JsonObject district_points;

    public Event(){
        // Empty default constructor
    }

    public Event(String eventKey){
        this.key = eventKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getEvent_code() {
        return event_code;
    }

    public void setEvent_code(String event_code) {
        this.event_code = event_code;
    }

    public String getEvent_type_string() {
        return event_type_string;
    }

    public void setEvent_type_string(String event_type_string) {
        this.event_type_string = event_type_string;
    }

    public String getEvent_district_string() {
        return event_district_string;
    }

    public void setEvent_district_string(String event_district_string) {
        this.event_district_string = event_district_string;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVenue_address() {
        return venue_address;
    }

    public void setVenue_address(String venue_address) {
        this.venue_address = venue_address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getEvent_type() {
        return event_type;
    }

    public void setEvent_type(int event_type) {
        this.event_type = event_type;
    }

    public int getEvent_district() {
        return event_district;
    }

    public void setEvent_district(int event_district) {
        this.event_district = event_district;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public JsonArray getWebcast() {
        return webcast;
    }

    public void setWebcast(JsonArray webcast) {
        this.webcast = webcast;
    }

    public JsonArray getAlliances() {
        return alliances;
    }

    public void setAlliances(JsonArray alliances) {
        this.alliances = alliances;
    }

    public JsonObject getDistrict_points() {
        return district_points;
    }

    public void setDistrict_points(JsonObject district_points) {
        this.district_points = district_points;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getFacebook_eid() {
        return facebook_eid;
    }

    public void setFacebook_eid(String facebook_eid) {
        this.facebook_eid = facebook_eid;
    }
}
