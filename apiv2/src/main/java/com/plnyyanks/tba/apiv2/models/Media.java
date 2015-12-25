package com.plnyyanks.tba.apiv2.models;

import com.google.gson.JsonObject;

public class Media {
    private String
        type,
        foreign_key;
    private JsonObject details;

    public Media(){
        // Empty default constructor
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForeign_key() {
        return foreign_key;
    }

    public void setForeign_key(String foreign_key) {
        this.foreign_key = foreign_key;
    }

    public JsonObject getDetails() {
        return details;
    }

    public void setDetails(JsonObject details) {
        this.details = details;
    }
}
