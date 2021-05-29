package com.tyhoo.nba.data.teamstanding

import com.google.gson.annotations.SerializedName

data class TeamStandingTeamResponse(
    @field:SerializedName("profile") val profile: TeamStandingTeamProfileResponse,
    @field:SerializedName("standings") val standings: TeamStandingTeamStandingResponse,
    @field:SerializedName("rank") val rank: TeamStandingTeamRankResponse
)