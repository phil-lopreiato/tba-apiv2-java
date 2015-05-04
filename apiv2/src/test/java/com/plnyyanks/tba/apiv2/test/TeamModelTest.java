package com.plnyyanks.tba.apiv2.test;

import com.google.gson.Gson;
import com.plnyyanks.tba.apiv2.models.Team;

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
public class TeamModelTest {
    Team team;

    @Before
    public void readJsonData(){
        BufferedReader teamReader;
        Gson gson = new Gson();
        String basePath = new File("").getAbsolutePath();
        try {
            teamReader = new BufferedReader(new FileReader(basePath + "/src/test/java/com/plnyyanks/tba/apiv2/test/data/team_frc1124.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            assertTrue(false);
            return;
        }

        team = gson.fromJson(teamReader, Team.class);
    }

    @Test
    public void testTeamModel(){
        assertNotNull(team);
        assertEquals(team.getKey(), "frc1124");
        assertEquals(team.getWebsite(), "http://www.uberbots.org");
        assertEquals(team.getName(), "Avon Public Schools/UTC & AVON HIGH SCHOOL");
        assertEquals(team.getLocality(), "Avon");
        assertEquals(team.getRookie_year(), 2003);
        assertEquals(team.getRegion(), "CT");
        assertEquals(team.getTeam_number(), 1124);
        assertEquals(team.getLocation(), "Avon, CT, USA");
        assertEquals(team.getCountry_name(), "USA");
        assertEquals(team.getNickname(), "UberBots");
    }
}
