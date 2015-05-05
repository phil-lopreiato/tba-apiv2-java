package com.plnyyanks.tba.apiv2.test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.plnyyanks.tba.apiv2.JSONHelper;
import com.plnyyanks.tba.apiv2.models.Event;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by phil on 5/4/15.
 */
public class EventModelTest {
    Event event;

    @Before
    public void readJsonData(){
        BufferedReader eventReader;
        Gson gson = JSONHelper.getGson();
        String basePath = new File("").getAbsolutePath();
        try {
            eventReader = new BufferedReader(new FileReader(basePath + "/src/test/java/com/plnyyanks/tba/apiv2/test/data/event_2015cthar.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            assertTrue(false);
            return;
        }

        event = gson.fromJson(eventReader, Event.class);
    }

    @Test
    public void testEventModel(){
        assertNotNull(event);
        assertEquals(event.getKey(), "2015cthar");
        assertEquals(event.getWebsite(), "http://www.nefirst.org/");
        assertTrue(event.isOfficial());
        assertEquals(event.getStart_date(), "2015-03-27");
        assertEquals(event.getEnd_date(), "2015-03-29");
        assertEquals(event.getName(), "NE District - Hartford Event");
        assertEquals(event.getShort_name(), "Hartford");
        assertEquals(event.getFacebook_eid(), null);
        assertEquals(event.getEvent_district_string(), "New England");
        assertEquals(event.getVenue_address(), "Hartford Public High School\n55 Forest Street\nHartford, CT 06105\nUSA");
        assertEquals(event.getEvent_district(), 3);
        assertEquals(event.getLocation(), "Hartford, CT, USA");
        assertEquals(event.getEvent_code(), "cthar");
        assertEquals(event.getYear(), 2015);
        assertEquals(event.getEvent_type_string(), "District");
        assertEquals(event.getEvent_type(), 1);
        assertFalse(event.getWebcast().isJsonNull());
        assertTrue(event.getWebcast().isJsonArray());
        assertFalse(event.getAlliances().isJsonNull());
        assertTrue(event.getAlliances().isJsonArray());

        JsonArray webcast = event.getWebcast().getAsJsonArray();
        assertEquals(webcast.size(), 1);
        assertTrue(webcast.get(0).isJsonObject());
        JsonObject castObject = webcast.get(0).getAsJsonObject();
        assertEquals(castObject.get("type").getAsString(), "twitch");
        assertEquals(castObject.get("channel").getAsString(), "nefirst_red");

        JsonArray alliances = event.getAlliances().getAsJsonArray();
        assertEquals(alliances.size(), 8);
        assertTrue(alliances.get(0).isJsonObject());
        JsonObject alliance1 = alliances.get(0).getAsJsonObject();
        assertTrue(alliance1.has("declines") && alliance1.get("declines").isJsonArray());
        assertEquals(alliance1.get("declines").getAsJsonArray().size(), 0);
        assertTrue(alliance1.has("picks") && alliance1.get("picks").isJsonArray());
        assertEquals(alliance1.get("picks").getAsJsonArray().size(), 3);
        assertEquals(alliance1.get("picks").getAsJsonArray().get(0).getAsString(), "frc195");
    }
}
