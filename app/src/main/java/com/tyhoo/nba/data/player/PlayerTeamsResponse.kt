package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerTeamsResponse(
    @field:SerializedName("statAverage") val statAverage: PlayerStatAverageResponse
)