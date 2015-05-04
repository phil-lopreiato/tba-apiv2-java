package com.plnyyanks.tba.apiv2.test;

import com.plnyyanks.tba.apiv2.APIv2Helper;
import com.plnyyanks.tba.apiv2.interfaces.ObservableAPIv2;

import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assume.assumeTrue;


/**
 * Class that hits TBA endpoints and tests that we can get data back
 * This class is ignored by default, so we aren't always hitting the server from automated tests
 * Change the 'shouldRun' variable to true if you'd like to run it.
 * Created by phil on 3/28/15.
 */
@Ignore
public abstract class AbstractObservableAPIv2Test {
    ObservableAPIv2 api;

    @Before
    public void setupAPIClient(){
        boolean shouldRun = true; //TODO move to configuration file

        APIv2Helper.APIv2RequestInterceptor.isFromJunit = true;
        api = APIv2Helper.getObservableAPI();
        assumeTrue(shouldRun);
    }

}
