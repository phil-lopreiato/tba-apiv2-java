package com.plnyyanks.tba.apiv2.models;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Created by phil on 3/30/15.
 */
public class Match {
    private String
        key,
        comp_level,
        event_key;

    private int
        set_number,
        match_number;

    private JsonObject alliances;
    private JsonElement score_breakdown; // can be null
    private JsonArray videos;

    public Match(){
        // Empty default constructor
    }

    public Match(String matchKey){
        this.key = matchKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getComp_level() {
        return comp_level;
    }

    public void setComp_level(String comp_level) {
        this.comp_level = comp_level;
    }

    public String getEvent_key() {
        return event_key;
    }

    public void setEvent_key(String event_key) {
        this.event_key = event_key;
    }

    public int getSet_number() {
        return set_number;
    }

    public void setSet_number(int set_number) {
        this.set_number = set_number;
    }

    public int getMatch_number() {
        return match_number;
    }

    public void setMatch_number(int match_number) {
        this.match_number = match_number;
    }

    public JsonObject getAlliances() {
        return alliances;
    }

    public void setAlliances(JsonObject alliances) {
        this.alliances = alliances;
    }

    public JsonElement getScore_breakdown() {
        return score_breakdown;
    }

    public void setScore_breakdown(JsonElement score_breakdown) {
        this.score_breakdown = score_breakdown;
    }

    public JsonArray getVideos() {
        return videos;
    }

    public void setVideos(JsonArray videos) {
        this.videos = videos;
    }
}
