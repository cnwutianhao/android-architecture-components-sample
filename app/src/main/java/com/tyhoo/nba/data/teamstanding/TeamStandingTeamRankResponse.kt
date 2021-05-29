package com.tyhoo.nba.data.teamstanding

import com.google.gson.annotations.SerializedName

data class TeamStandingTeamRankResponse(
    @field:SerializedName("apg") val apg: String,
    @field:SerializedName("oppg") val oppg: String,
    @field:SerializedName("ppg") val ppg: String,
    @field:SerializedName("rpg") val rpg: String
)