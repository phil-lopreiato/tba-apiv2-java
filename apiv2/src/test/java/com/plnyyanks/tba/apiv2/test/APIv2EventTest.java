package com.plnyyanks.tba.apiv2.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.plnyyanks.tba.apiv2.models.Award;
import com.plnyyanks.tba.apiv2.models.Event;
import com.plnyyanks.tba.apiv2.models.Match;
import com.plnyyanks.tba.apiv2.models.Team;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by phil on 3/29/15.
 */
public class APIv2EventTest extends AbstractAPIv2Test {

    @Test
    public void testFetchEventsInYear(){
        List<Event> events = api.fetchEventsInYear(2014, null);
        assertTrue(events.size() > 0);
    }

    @Test
    public void testFetchEvent(){
        Event event = api.fetchEvent("2014cthar", null);
        assertEquals(event.getKey(), "2014cthar");
    }

    @Test
    public void testFetchEventTeams(){
        List<Team> teams = api.fetchEventTeams("2014cthar", null);
        assertTrue(teams.size() > 0);
    }

    @Test
    public void testFetchEventRankings(){
        JsonArray rankings = api.fetchEventRankings("2014cthar", null);
        assertTrue(rankings.size() > 0);
        assertTrue(rankings.get(0).isJsonArray());
        assertEquals(rankings.get(0).getAsJsonArray().get(0).getAsString(), "Rank");
    }

    @Test
    public void testFetchEventMatches(){
        List<Match> matches = api.fetchEventMatches("2014cthar", null);
        assertTrue(matches.size() > 0);
    }

    @Test
    public void testFetchEventStats(){
        JsonObject stats = api.fetchEventStats("2014cthar", null);
        assertTrue(stats.has("oprs"));
        assertTrue(stats.has("dprs"));
        assertTrue(stats.has("ccwms"));
    }

    @Test
    public void testFetchEventAwards(){
        List<Award> awards = api.fetchEventAwards("2014cthar", null);
        assertTrue(awards.size() > 0);
    }

    @Test
    public void testFetchEventDistrictPoins(){
        JsonObject points = api.fetchEventDistrictPoints("2014cthar", null);
        assertTrue(points.has("points"));
        assertTrue(points.has("tiebreakers"));
    }
}