package com.plnyyanks.tba.apiv2.test;

import com.plnyyanks.tba.apiv2.APIv2Helper;
import com.plnyyanks.tba.apiv2.interfaces.APIv2;

import org.junit.Before;
import org.junit.Test;

import retrofit.RetrofitError;

/**
 * Created by phil on 5/5/15.
 */
public class APIv2ErrorTest {

    APIv2 api;

    @Before
    public void setupAPIClient(){
        // Make sure no App Id is set so an error is thrown
        APIv2Helper.setAppId("");
        api = APIv2Helper.getAPI();
    }

    @Test(expected = RetrofitError.class)
    public void testApiNoAppId(){
        // Since no App Id is set, TBA will return 400 Bad Request
        api.fetchTeam("frc254", null);
    }
}
