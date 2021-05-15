package com.tyhoo.nba.data.players

import com.google.gson.annotations.SerializedName

data class PlayersPayloadResponse(
    @field:SerializedName("league") val league: PlayersLeagueResponse,
    @field:SerializedName("season") val season: PlayersSeasonResponse,
    @field:SerializedName("players") val players: List<PlayersPlayerResponse>
)