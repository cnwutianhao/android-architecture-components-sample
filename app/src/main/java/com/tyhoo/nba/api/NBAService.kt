package com.tyhoo.nba.api

import com.tyhoo.nba.data.players.PlayersResponse
import com.tyhoo.nba.data.player.PlayerResponse
import com.tyhoo.nba.data.teams.TeamsResponse
import com.tyhoo.nba.data.teamstanding.TeamStandingResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface NBAService {

    /**
     * https://china.nba.com/static/data/league/playerlist.json
     */
    @GET("static/data/league/playerlist.json")
    suspend fun players(): PlayersResponse

    /**
     * https://china.nba.com/static/data/player/stats_lebron_james.json
     */
    @GET("static/data/player/stats_{code}.json")
    suspend fun player(@Path("code") code: String): PlayerResponse

    /**
     * https://china.nba.com/static/data/league/conferenceteamlist.json
     */
    @GET("static/data/league/conferenceteamlist.json")
    suspend fun teams(): TeamsResponse

    /**
     * https://china.nba.com/static/data/team/standing_hawks.json
     */
    @GET("static/data/team/standing_{code}.json")
    suspend fun teamStanding(@Path("code") code: String): TeamStandingResponse

    /**
     * https://china.nba.com/static/data/team/schedule_hawks.json
     */
    @GET("static/data/team/schedule_{code}.json")
    suspend fun teamSchedule(@Path("code") code: String)

    /**
     * https://china.nba.com/static/data/team/leader_hawks.json
     */
    @GET("static/data/team/leader_{code}.json")
    suspend fun teamLeader(@Path("code") code: String)

    companion object {
        private const val BASE_URL = "https://china.nba.com/"

        fun create(): NBAService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NBAService::class.java)
        }
    }
}