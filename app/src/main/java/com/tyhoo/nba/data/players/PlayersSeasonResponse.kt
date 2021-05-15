package com.tyhoo.nba.data.players

import com.google.gson.annotations.SerializedName

data class PlayersSeasonResponse(
    @field:SerializedName("yearDisplay") val yearDisplay: String
)