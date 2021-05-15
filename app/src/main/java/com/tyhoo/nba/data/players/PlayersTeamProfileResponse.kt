package com.tyhoo.nba.data.players

import com.google.gson.annotations.SerializedName

data class PlayersTeamProfileResponse(
    @field:SerializedName("city") val city: String,
    @field:SerializedName("name") val name: String
)