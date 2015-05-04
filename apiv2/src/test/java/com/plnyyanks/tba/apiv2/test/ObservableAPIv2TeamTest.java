package com.plnyyanks.tba.apiv2.test;

import com.plnyyanks.tba.apiv2.models.Award;
import com.plnyyanks.tba.apiv2.models.Event;
import com.plnyyanks.tba.apiv2.models.Match;
import com.plnyyanks.tba.apiv2.models.Media;
import com.plnyyanks.tba.apiv2.models.Team;

import org.junit.Test;

import java.util.List;

import rx.functions.Action1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObservableAPIv2TeamTest extends AbstractObservableAPIv2Test {

    @Test
    public void testFetchTeamPage(){
        api.fetchTeamPageObservable(0, null).subscribe(new Action1<List<Team>>() {
            @Override
            public void call(List<Team> teams) {
                assertTrue(teams.size() > 0);
            }
        });
    }

    @Test
    public void testFetchTeam(){
        api.fetchTeamObservable("frc1124", null).subscribe(new Action1<Team>() {
            @Override
            public void call(Team team) {
                assertEquals(team.getKey(), "frc1124");
            }
        });
    }

    @Test
    public void testFetchTeamEvents(){
        api.fetchTeamEventsObservable("frc1124", 2014, null).subscribe(new Action1<List<Event>>() {
            @Override
            public void call(List<Event> events) {
                assertEquals(events.size(), 4);
            }
        });
    }

    @Test
    public void testFetchTeamAtEventAwards(){
        api.fetchTeamAtEventAwardsObservable("frc1124", "2014cthar", null).subscribe(new Action1<List<Award>>() {
            @Override
            public void call(List<Award> awards) {
                assertEquals(awards.size(), 1);
            }
        });
    }

    @Test
    public void testFetchTeamAtEventMatches(){
        api.fetchTeamAtEventMatchesObservable("frc254", "2014cmp", null).subscribe(new Action1<List<Match>>() {
            @Override
            public void call(List<Match> matches) {
                assertEquals(matches.size(), 5);
            }
        });
    }

    @Test
    public void testFetchTeamYearsParticipated(){
        api.fetchTeamYearsParticipatedObservable("frc1124", null).subscribe(new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> years) {
                assertTrue(years.size() > 0);
                assertEquals((int) years.get(0), 2003);
            }
        });
    }

    @Test
    public void testFetchTeamMediaInYear(){
        api.fetchTeamMediaInYearObservable("frc1124", 2014, null).subscribe(new Action1<List<Media>>() {
            @Override
            public void call(List<Media> medias) {
                assertEquals(medias.size(), 1);
            }
        });
    }
}
