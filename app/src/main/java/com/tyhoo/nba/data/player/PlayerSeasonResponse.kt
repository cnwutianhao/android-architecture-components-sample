package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerSeasonResponse(
    @field:SerializedName("yearDisplay") val yearDisplay: String
)