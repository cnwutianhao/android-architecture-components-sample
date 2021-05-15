package com.tyhoo.nba.data.teamstanding

import com.google.gson.annotations.SerializedName

data class TeamStandingResponse(
    @field:SerializedName("payload") val payload: TeamStandingPayloadResponse
)