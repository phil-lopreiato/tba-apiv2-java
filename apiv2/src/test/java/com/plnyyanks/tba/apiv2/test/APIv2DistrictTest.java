package com.plnyyanks.tba.apiv2.test;

import com.google.gson.JsonArray;
import com.plnyyanks.tba.apiv2.models.District;
import com.plnyyanks.tba.apiv2.models.Event;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by phil on 3/29/15.
 */
public class APIv2DistrictTest extends AbstractAPIv2Test {

    @Test
    public void testFetchDistrictList() {
        List<District> districts = api.fetchDistrictList(2014, null);
        assertEquals(districts.size(), 4);
        assertEquals(districts.get(0).getKey(), "fim");
    }

    @Test
    public void testFetchDistrictEvents(){
        List<Event> events = api.fetchDistrictEvents("ne", 2014, null);
        assertTrue(events.size() > 0);
    }

    @Test
    public void testFetchDistrictRankings(){
        JsonArray rankings = api.fetchDistrictRankings("ne", 2014, null);
        assertTrue(rankings.size() > 0);
        assertTrue(rankings.get(0).isJsonObject());
    }
}
