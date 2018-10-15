package com.example.f.submisionfinal.util.netConfig

import com.example.f.submisionfinal.data.model.match.Match
import com.example.f.submisionfinal.data.model.player.Player
import com.example.f.submisionfinal.data.model.team.Team
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

//class untuk ambil respon dari retrofit

interface ResponseRetrofit {
    @GET("eventsnextleague.php")
    fun getNextMatch(@Query("id")id:String): Observable<Match>

    @GET("eventspastleague.php")
    fun getLastMatch(@Query("id")id:String): Observable<Match>

    @GET("lookupteam.php")
    fun getTeam(@Query("id")id:String?): Observable<Team>

    @GET("search_all_teams.php")
    fun getAllTeam(@Query("l")l:String):Observable<Team>

    @GET("lookup_all_players.php")
    fun getTeamPlayer(@Query("id")id:String): Observable<Player>

    @GET("lookupplayer.php")
    fun getPlayer(@Query("id")id:String):Observable<Player>

    @GET("searchteams.php")
    fun getTeamByName(@Query("t")t:String):Observable<Team>

    @GET("searchevents.php")
    fun getEventByName(@Query("e")e:String):Observable<Match>
}

//GET /api/v1/json/1/eventspastleague.php?id={leagueId}
//GET /api/v1/json/1/eventsnextleague.php?id={leagueId}
//GET /api/v1/json/1/lookupevent.php?id={eventId}
//GET /api/v1/json/1/search_all_teams.php?l={leagueName}
//GET /api/v1/json/1/lookupteam.php?id={teamId}
//GET /api/v1/json/1/searchevents.php?e={eventName}
//GET /api/v1/json/1/searchteams.php?t={teamName}
//GET /api/v1/json/1/lookup_all_players.php?id={teamId}
//GET /api/v1/json/1/lookupplayer.php?id={playerId}
//GET /api/v1/json/1/all_leagues.php