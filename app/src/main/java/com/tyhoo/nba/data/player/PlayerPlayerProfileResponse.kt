package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerPlayerProfileResponse(
    @field:SerializedName("code") val code: String,
    @field:SerializedName("country") val country: String,
    @field:SerializedName("displayName") val displayName: String,
    @field:SerializedName("draftYear") val draftYear: String,
    @field:SerializedName("experience") val experience: String,
    @field:SerializedName("height") val height: String,
    @field:SerializedName("jerseyNo") val jerseyNo: String,
    @field:SerializedName("playerId") val playerId: String,
    @field:SerializedName("position") val position: String,
    @field:SerializedName("schoolType") val schoolType: String,
    @field:SerializedName("weight") val weight: String
)