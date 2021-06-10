package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerStatsResponse(
    @field:SerializedName("regularSeasonStat") val regularSeasonStat: PlayerRegularSeasonStatResponse
)