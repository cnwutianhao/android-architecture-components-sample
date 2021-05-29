package com.tyhoo.nba.data.teamstanding

import com.google.gson.annotations.SerializedName

data class TeamStandingTeamStandingResponse(
    @field:SerializedName("clinched") val clinched: String,
    @field:SerializedName("confRank") val confRank: Int,
    @field:SerializedName("divRank") val divRank: Int,
    @field:SerializedName("last10") val last10: String,
    @field:SerializedName("losses") val losses: Int,
    @field:SerializedName("onHotStreak") val onHotStreak: String,
    @field:SerializedName("streak") val streak: String,
    @field:SerializedName("wins") val wins: Int
)