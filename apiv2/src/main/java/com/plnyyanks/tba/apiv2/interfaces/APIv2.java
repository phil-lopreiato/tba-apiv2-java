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

/**
 * Created by phil on 3/30/15.
 */
public interface APIv2 {
    @GET("/teams/{pageNum}")
    public List<Team> fetchTeamPage(
            @Path("pageNum") int pageNum,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}")
    public Team fetchTeam(
            @Path("teamKey") String teamKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/{year}/events")
    public List<Event> fetchTeamEvents(
            @Path("teamKey") String teamKey,
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/event/{eventKey}/awards")
    public List<Award> fetchTeamAtEventAwards(
            @Path("teamKey") String teamKey,
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/event/{eventKey}/matches")
    public List<Match> fetchTeamAtEventMatches(
            @Path("teamKey") String teamKey,
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/years_participated")
    public List<Integer> fetchTeamYearsParticipated(
            @Path("teamKey") String teamKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/{year}/media")
    public List<Media> fetchTeamMediaInYear(
            @Path("teamKey") String teamKey,
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/history/events")
    public List<Event> fetchTeamEventHistory(
            @Path("teamKey") String teamKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/team/{teamKey}/history/awards")
    public List<Award> fetchTeamAwardHistory(
            @Path("teamKey") String teamKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/events/{year}")
    public List<Event> fetchEventsInYear(
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}")
    public Event fetchEvent(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/teams")
    public List<Team> fetchEventTeams(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/rankings")
    public JsonArray fetchEventRankings(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/matches")
    public List<Match> fetchEventMatches(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/stats")
    public JsonObject fetchEventStats(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/awards")
    public List<Award> fetchEventAwards(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/event/{eventKey}/district_points")
    public JsonObject fetchEventDistrictPoints(
            @Path("eventKey") String eventKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/districts/{year}")
    public List<District> fetchDistrictList(
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/district/{districtShort}/{year}/events")
    public List<Event> fetchDistrictEvents(
            @Path("districtShort") String districtShort,
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/district/{districtShort}/{year}/rankings")
    public JsonArray fetchDistrictRankings(
            @Path("districtShort") String districtShort,
            @Path("year") int year,
            @Header("If-Modified-Since") String ifModifiedSince
    );

    @GET("/match/{matchKey}")
    public Match fetchMatch(
            @Path("matchKey") String matchKey,
            @Header("If-Modified-Since") String ifModifiedSince
    );
}