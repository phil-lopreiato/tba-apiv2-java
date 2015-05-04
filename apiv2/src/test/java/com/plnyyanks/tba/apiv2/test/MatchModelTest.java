package com.plnyyanks.tba.apiv2.test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.plnyyanks.tba.apiv2.models.Match;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by phil on 5/4/15.
 */
public class MatchModelTest {
    Match match;

    @Before
    public void readJsonData(){
        BufferedReader matchReader;
        Gson gson = new Gson();
        String basePath = new File("").getAbsolutePath();
        try {
            matchReader = new BufferedReader(new FileReader(basePath + "/src/test/java/com/plnyyanks/tba/apiv2/test/data/match_2014cmp_f1m1.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            assertTrue(false);
            return;
        }

        match = gson.fromJson(matchReader, Match.class);
    }

    @Test
    public void testMatchModel(){
        assertNotNull(match);
        assertEquals(match.getKey(), "2014cmp_f1m1");
        assertEquals(match.getComp_level(), "f");
        assertEquals(match.getMatch_number(), 1);
        assertEquals(match.getSet_number(), 1);
        assertEquals(match.getEvent_key(), "2014cmp");
        assertEquals(match.getTime_string(), "5:38 PM");
        assertEquals(match.getTime(), 1398551880);
        assertTrue(match.getScore_breakdown().isJsonNull());
        assertNotNull(match.getVideos());
        assertNotNull(match.getAlliances());

        JsonArray videos = match.getVideos();
        assertEquals(videos.size(), 2);
        assertTrue(videos.get(0).isJsonObject());
        JsonObject video1 = videos.get(0).getAsJsonObject();
        assertEquals(video1.get("type").getAsString(), "youtube");
        assertEquals(video1.get("key").getAsString(), "jdJutaggCMk");

        JsonObject alliances = match.getAlliances().getAsJsonObject();
        assertTrue(alliances.has("blue") && alliances.get("blue").isJsonObject());
        assertTrue(alliances.has("red") && alliances.get("red").isJsonObject());
        JsonObject blueAlliance = alliances.get("blue").getAsJsonObject();
        assertTrue(blueAlliance.has("score") && blueAlliance.has("teams"));
        assertEquals(blueAlliance.get("score").getAsInt(), 361);
        assertTrue(blueAlliance.get("teams").isJsonArray());
        JsonArray blueTeams = blueAlliance.get("teams").getAsJsonArray();
        assertEquals(blueTeams.size(), 3);
        assertEquals(blueTeams.get(0).getAsString(), "frc469");
    }
}