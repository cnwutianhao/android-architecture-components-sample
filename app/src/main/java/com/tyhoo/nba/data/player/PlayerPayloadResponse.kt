package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerPayloadResponse(
    @field:SerializedName("league") val league: PlayerLeagueResponse,
    @field:SerializedName("season") val season: PlayerSeasonResponse,
    @field:SerializedName("leagueSeasonAverage") val leagueSeasonAverage: PlayerLeagueSeasonAverageResponse,
    @field:SerializedName("player") val player: PlayerPlayerResponse
)