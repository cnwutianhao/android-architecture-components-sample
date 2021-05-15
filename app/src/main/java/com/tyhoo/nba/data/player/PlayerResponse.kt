package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @field:SerializedName("payload") val payload: PlayerPayloadResponse
)