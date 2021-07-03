package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerTeamsResponse(
    @field:SerializedName("profile") val profile: PlayerProfileResponse?,
    @field:SerializedName("statAverage") val statAverage: PlayerStatAverageResponse,
    @field:SerializedName("season") val season: String
)