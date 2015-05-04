package com.plnyyanks.tba.apiv2.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.plnyyanks.tba.apiv2.models.Award;
import com.plnyyanks.tba.apiv2.models.Event;
import com.plnyyanks.tba.apiv2.models.Match;
import com.plnyyanks.tba.apiv2.models.Team;

import org.junit.Test;

import java.util.List;

import rx.functions.Action1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by phil on 3/29/15.
 */
public class ObservableAPIv2EventTest extends AbstractObservableAPIv2Test {

    @Test
    public void testFetchEventsInYearObservable(){
        api.fetchEventsInYearObservable(2014, null).subscribe(new Action1<List<Event>>() {
            @Override
            public void call(List<Event> events) {
                assertTrue(events.size() > 0);
            }
        });
    }

    @Test
    public void testFetchEventObservable(){
        api.fetchEventObservable("2014cthar", null).subscribe(new Action1<Event>() {
            @Override
            public void call(Event event) {
                assertEquals(event.getKey(), "2014cthar");
            }
        });
    }

    @Test
    public void testFetchEventTeamsObservable(){
        api.fetchEventTeamsObservable("2014cthar", null).subscribe(new Action1<List<Team>>() {
            @Override
            public void call(List<Team> teams) {
                assertTrue(teams.size() > 0);
            }
        });
    }

    @Test
    public void testFetchEventRankingsObservable(){
        api.fetchEventRankingsObservable("2014cthar", null).subscribe(new Action1<JsonArray>() {
            @Override
            public void call(JsonArray rankings) {
                assertTrue(rankings.size() > 0);
                assertTrue(rankings.get(0).isJsonArray());
                assertEquals(rankings.get(0).getAsJsonArray().get(0).getAsString(), "Rank");
            }
        });
    }

    @Test
    public void testFetchEventMatchesObservable(){
        api.fetchEventMatchesObservable("2014cthar", null).subscribe(new Action1<List<Match>>() {
            @Override
            public void call(List<Match> matches) {
                assertTrue(matches.size() > 0);
            }
        });
    }

    @Test
    public void testFetchEventStatsObservable(){
        api.fetchEventStatsObservable("2014cthar", null).subscribe(new Action1<JsonObject>() {
            @Override
            public void call(JsonObject stats) {
                assertTrue(stats.has("oprs"));
                assertTrue(stats.has("dprs"));
                assertTrue(stats.has("ccwms"));
            }
        });
    }

    @Test
    public void testFetchEventAwardsObservable(){
        api.fetchEventAwardsObservable("2014cthar", null).subscribe(new Action1<List<Award>>() {
            @Override
            public void call(List<Award> awards) {
                assertTrue(awards.size() > 0);
            }
        });
    }

    @Test
    public void testFetchEventDistrictPointsObservable(){
        api.fetchEventDistrictPointsObservable("2014cthar", null).subscribe(new Action1<JsonObject>() {
            @Override
            public void call(JsonObject points) {
                assertTrue(points.has("points"));
                assertTrue(points.has("tiebreakers"));
            }
        });
    }
}