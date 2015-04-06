package com.plnyyanks.tba.apiv2.test;

import com.plnyyanks.tba.apiv2.models.Match;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by phil on 3/29/15.
 */
public class APIv2MatchTest extends AbstractAPIv2Test{

    @Test
    public void testFetchMatch() {
        Match match = api.fetchMatch("2014cmp_f1m1", null);
        assertEquals(match.getKey(), "2014cmp_f1m1");
    }

}
