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
import retrofit2.http.Query

interface NBAService {

    /**
     * https://china.nba.cn/stats2/league/playerlist.json
     */
    @GET("stats2/league/playerlist.json")
    suspend fun players(): PlayersResponse

    /**
     * https://china.nba.cn/stats2/player/stats.json?playerCode=lebron_james
     */
    @GET("stats2/player/stats.json")
    suspend fun player(@Query("playerCode") playerCode: String): PlayerResponse

    /**
     * https://china.nba.cn/stats2/league/conferenceteamlist.json
     */
    @GET("stats2/league/conferenceteamlist.json")
    suspend fun teams(): TeamsResponse

    /**
     * https://china.nba.cn/stats2/team/standing.json?teamCode=hawks
     */
    @GET("stats2/team/standing.json")
    suspend fun teamStanding(@Query("teamCode") teamCode: String): TeamStandingResponse

    /**
     * https://china.nba.cn/stats2/team/schedule.json?teamCode=hawks
     */
    @GET("stats2/team/schedule.json")
    suspend fun teamSchedule(@Query("teamCode") teamCode: String)

    /**
     * https://china.nba.cn/stats2/team/leader.json?teamCode=hawks
     */
    @GET("stats2/team/leader.json")
    suspend fun teamLeader(@Query("teamCode") teamCode: String)

    companion object {
        private const val BASE_URL = "https://china.nba.cn/"

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