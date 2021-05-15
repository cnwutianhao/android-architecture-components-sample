package com.tyhoo.nba.data.players

import com.google.gson.annotations.SerializedName

data class PlayersPlayerResponse(
    @field:SerializedName("playerProfile") val playerProfile: PlayersPlayerProfileResponse,
    @field:SerializedName("teamProfile") val teamProfile: PlayersTeamProfileResponse
)