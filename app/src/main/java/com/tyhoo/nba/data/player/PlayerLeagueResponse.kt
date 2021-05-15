package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerLeagueResponse(
    @field:SerializedName("name") val name: String
)