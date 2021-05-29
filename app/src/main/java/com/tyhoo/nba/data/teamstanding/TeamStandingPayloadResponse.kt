package com.tyhoo.nba.data.teamstanding

import com.google.gson.annotations.SerializedName

data class TeamStandingPayloadResponse(
    @field:SerializedName("season") val season: TeamStandingSeasonResponse,
    @field:SerializedName("team") val team: TeamStandingTeamResponse
)