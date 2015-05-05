package com.plnyyanks.tba.apiv2.test;

import com.plnyyanks.tba.apiv2.APIv2Helper;
import com.plnyyanks.tba.apiv2.interfaces.APIv2;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by phil on 5/5/15.
 */
public class APIv2ErrorTest {

    APIv2 api;

    @Before
    public void setupAPIClient(){
        // Do not set the App ID and try and get an error
        api = APIv2Helper.getAPI();
    }

    @Test(expected = Throwable.class)
    public void testApiNoAppId(){
        api.fetchTeam("frc1124", null);
    }
}
