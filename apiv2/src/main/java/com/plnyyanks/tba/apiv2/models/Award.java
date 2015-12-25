package com.plnyyanks.tba.apiv2.models;

import com.google.gson.JsonArray;

public class Award {
    private String
        name,
        event_key;

    private int
        award_type,
        year;

    private JsonArray recipient_list;

    public Award(){
        // Empty default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent_key() {
        return event_key;
    }

    public void setEvent_key(String event_key) {
        this.event_key = event_key;
    }

    public int getAward_type() {
        return award_type;
    }

    public void setAward_type(int award_type) {
        this.award_type = award_type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public JsonArray getRecipient_list() {
        return recipient_list;
    }

    public void setRecipient_list(JsonArray recipient_list) {
        this.recipient_list = recipient_list;
    }
}
