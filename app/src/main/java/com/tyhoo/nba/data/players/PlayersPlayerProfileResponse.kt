package com.tyhoo.nba.data.players

import com.google.gson.annotations.SerializedName

data class PlayersPlayerProfileResponse(
    @field:SerializedName("code") val code: String,
    @field:SerializedName("displayName") val displayName: String,
    @field:SerializedName("jerseyNo") val jerseyNo: String,
    @field:SerializedName("playerId") val playerId: String,
    @field:SerializedName("position") val position: String
)