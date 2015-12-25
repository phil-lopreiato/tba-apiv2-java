package com.plnyyanks.tba.apiv2.models;

public class District {
    private String
        name,
        key; // Note - not full key, it's abbreviation

    public District(){
        // Empty default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
