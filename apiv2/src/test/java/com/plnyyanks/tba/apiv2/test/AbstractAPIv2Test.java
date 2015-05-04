package com.plnyyanks.tba.apiv2.test;

import com.plnyyanks.tba.apiv2.APIv2Helper;
import com.plnyyanks.tba.apiv2.interfaces.APIv2;

import org.junit.Before;
import org.junit.Ignore;


/**
 * Class that hits TBA endpoints and tests that we can get data back
 * This class is ignored by default, so we aren't always hitting the server from automated tests
 * Change the 'shouldRun' variable to true if you'd like to run it.
 * Created by phil on 3/28/15.
 */
@Ignore
public abstract class AbstractAPIv2Test {
    APIv2 api;
    private static final String API_APP_ID = "plnyyanks:apiv2-java-junit:v0.1";

    @Before
    public void setupAPIClient(){
        APIv2Helper.setAppId(API_APP_ID);
        api = APIv2Helper.getAPI();
    }

}
