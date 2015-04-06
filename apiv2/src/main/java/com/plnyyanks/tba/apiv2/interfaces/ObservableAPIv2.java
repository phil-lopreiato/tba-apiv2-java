package com.plnyyanks.tba.apiv2.interfaces;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.plnyyanks.tba.apiv2.models.Award;
import com.plnyyanks.tba.apiv2.models.District;
import com.plnyyanks.tba.apiv2.models.Event;
import com.plnyyanks.tba.apiv2.models.Match;
import com.plnyyanks.tba.apiv2.models.Media;
import com.plnyyanks.tba.apiv2.models.Team;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by phil on 3/30/15.
 */
public interface ObservableAPIv2 {
    @GET("/teams/{pageNum}")
    public Observable<List<Team>> fetchTeamPageObservable(
            @Path("pageNum") int pageNum,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}")
    public Observable<Team> fetchTeamObservable(
            @Path("teamKey") String teamKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/{year}/events")
    public Observable<List<Event>> fetchTeamEventsObservable(
            @Path("teamKey") String teamKey,
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/event/{eventKey}/awards")
    public Observable<List<Award>> fetchTeamAtEventAwardsObservable(
            @Path("teamKey") String teamKey,
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/event/{eventKey}/matches")
    public Observable<List<Match>> fetchTeamAtEventMatchesObservable(
            @Path("teamKey") String teamKey,
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/years_participated")
    public Observable<List<Integer>> fetchTeamYearsParticipatedObservable(
            @Path("teamKey") String teamKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/{year}/media")
    public Observable<List<Media>> fetchTeamMediaInYearObservable(
            @Path("teamKey") String teamKey,
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/history/events")
    public Observable<List<Event>> fetchTeamEventHistoryObservable(
            @Path("teamKey") String teamKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/history/awards")
    public Observable<List<Award>> fetchTeamEventAwardsObservable(
            @Path("teamKey") String teamKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/events/{year}")
    public Observable<List<Event>> fetchEventsInYearObservable(
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}")
    public Observable<Event> fetchEventObservable(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/teams")
    public Observable<List<Team>> fetchEventTeamsObservable(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/rankings")
    public Observable<JsonArray> fetchEventRankingsObservable(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/matches")
    public Observable<List<Match>> fetchEventMatchesObservable(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/stats")
    public Observable<JsonObject> fetchEventStatsObservable(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/awards")
    public Observable<List<Award>> fetchEventAwardsObservable(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/district_points")
    public Observable<JsonObject> fetchEventDistrictPointsObservable(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/districts/{year}")
    public Observable<List<District>> fetchDistrictListObservable(
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/district/{districtShort}/{year}/events")
    public Observable<List<Event>> fetchDistrictEventsObservable(
            @Path("districtShort") String districtShort,
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/district/{districtShort}/{year}/rankings")
    public Observable<JsonArray> fetchDistrictRankingsObservable(
            @Path("districtShort") String districtShort,
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/match/{matchKey}")
    public Observable<Match> fetchMatchObservable(
            @Path("matchKey") String matchKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );
}