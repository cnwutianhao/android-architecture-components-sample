package com.tyhoo.nba.data.players

import com.google.gson.annotations.SerializedName

data class PlayersResponse(
    @field:SerializedName("payload") val payload: PlayersPayloadResponse
)