package com.plnyyanks.tba.apiv2.test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.plnyyanks.tba.apiv2.JSONHelper;
import com.plnyyanks.tba.apiv2.models.Award;

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
public class AwardModelTest {

    Award teamAward;
    Award individualAward;

    @Before
    public void readJsonData(){
        BufferedReader individualReader;
        BufferedReader teamReader;
        Gson gson = JSONHelper.getGson();
        String basePath = new File("").getAbsolutePath();
        try {
            individualReader = new BufferedReader(new FileReader(basePath + "/src/test/java/com/plnyyanks/tba/apiv2/test/data/award_individual.json"));
            teamReader = new BufferedReader(new FileReader(basePath + "/src/test/java/com/plnyyanks/tba/apiv2/test/data/award_team.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            assertTrue(false);
            return;
        }

        individualAward = gson.fromJson(individualReader, Award.class);
        teamAward = gson.fromJson(teamReader, Award.class);
    }

    @Test
    public void testTeamAward(){
        assertNotNull(teamAward);
        assertEquals(teamAward.getEvent_key(), "2015cthar");
        assertEquals(teamAward.getAward_type(), 17);
        assertEquals(teamAward.getName(), "Quality Award sponsored by Motorola");
        assertEquals(teamAward.getYear(), 2015);

        JsonArray recipientList = teamAward.getRecipient_list();
        assertEquals(recipientList.size(), 1);
        assertTrue(recipientList.get(0).isJsonObject());

        JsonObject recipient = recipientList.get(0).getAsJsonObject();
        assertEquals(recipient.get("team_number").getAsInt(), 195);
        assertTrue(recipient.get("awardee").isJsonNull());
    }

    @Test
    public void testIndividualAward(){
        assertNotNull(individualAward);
        assertEquals(individualAward.getEvent_key(), "2015necmp");
        assertEquals(individualAward.getAward_type(), 5);
        assertEquals(individualAward.getName(), "Volunteer of the Year");
        assertEquals(individualAward.getYear(), 2015);

        JsonArray recipientList = individualAward.getRecipient_list();
        assertEquals(recipientList.size(), 1);
        assertTrue(recipientList.get(0).isJsonObject());

        JsonObject recipient = recipientList.get(0).getAsJsonObject();
        assertEquals(recipient.get("team_number").getAsInt(), 319);
        assertEquals(recipient.get("awardee").getAsString(), "Ty Tremblay");
    }
}
