package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerStatAverageResponse(
    @field:SerializedName("assistsPg") val assistsPg: Float,
    @field:SerializedName("pointsPg") val pointsPg: Float,
    @field:SerializedName("rebsPg") val rebsPg: Float
)