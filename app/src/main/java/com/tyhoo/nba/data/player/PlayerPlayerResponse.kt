package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerPlayerResponse(
    @field:SerializedName("playerProfile") val playerProfile: PlayerPlayerProfileResponse,
    @field:SerializedName("teamProfile") val teamProfile: PlayerTeamProfileResponse
)