package com.plnyyanks.tba.apiv2.test;

import com.google.gson.JsonArray;
import com.plnyyanks.tba.apiv2.models.District;
import com.plnyyanks.tba.apiv2.models.Event;

import org.junit.Test;

import java.util.List;

import rx.functions.Action1;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by phil on 3/29/15.
 */
public class ObservableAPIv2DistrictTest extends AbstractObservableAPIv2Test {

    @Test
    public void testFetchDistrictListObservable() {
        api.fetchDistrictListObservable(2014, null).subscribe(new Action1<List<District>>() {
            @Override
            public void call(List<District> districts) {
                assertEquals(districts.size(), 4);
                assertEquals(districts.get(0).getKey(), "fim");
            }
        });
    }

    @Test
    public void testFetchDistrictEventsObservable(){
        api.fetchDistrictEventsObservable("ne", 2014, null).subscribe(new Action1<List<Event>>() {
            @Override
            public void call(List<Event> events) {
                assertTrue(events.size() > 0);
            }
        });
    }

    @Test
    public void testFetchDistrictRankingsObservable(){
        api.fetchDistrictRankingsObservable("ne", 2014, null).subscribe(new Action1<JsonArray>() {
            @Override
            public void call(JsonArray rankings) {
                assertTrue(rankings.size() > 0);
                assertTrue(rankings.get(0).isJsonObject());
            }
        });
    }
}
