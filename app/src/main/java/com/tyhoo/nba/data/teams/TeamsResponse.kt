package com.tyhoo.nba.data.teams

import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @field:SerializedName("payload") val payload: TeamsPayloadResponse
)