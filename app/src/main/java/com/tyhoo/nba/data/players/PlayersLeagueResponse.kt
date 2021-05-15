package com.tyhoo.nba.data.players

import com.google.gson.annotations.SerializedName

data class PlayersLeagueResponse(
    @field:SerializedName("name") val name: String
)