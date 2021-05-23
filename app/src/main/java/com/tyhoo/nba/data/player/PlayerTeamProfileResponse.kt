package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerTeamProfileResponse(
    @field:SerializedName("abbr") val abbr: String,
    @field:SerializedName("city") val city: String,
    @field:SerializedName("code") val code: String,
    @field:SerializedName("displayConference") val displayConference: String,
    @field:SerializedName("division") val division: String,
    @field:SerializedName("name") val name: String
)