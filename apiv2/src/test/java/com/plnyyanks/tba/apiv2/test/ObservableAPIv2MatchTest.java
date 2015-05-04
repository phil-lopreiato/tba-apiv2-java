package com.plnyyanks.tba.apiv2.test;

import com.plnyyanks.tba.apiv2.models.Match;

import org.junit.Test;

import rx.functions.Action1;

import static org.junit.Assert.assertEquals;

/**
 * Created by phil on 3/29/15.
 */
public class ObservableAPIv2MatchTest extends AbstractObservableAPIv2Test {

    @Test
    public void testFetchMatchObservable() {
        api.fetchMatchObservable("2014cmp_f1m1", null).subscribe(new Action1<Match>() {
            @Override
            public void call(Match match) {
                assertEquals(match.getKey(), "2015cmp_f1m1");
            }
        });
    }
}
