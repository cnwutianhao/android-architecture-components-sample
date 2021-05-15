package com.tyhoo.nba.data.teams

import com.google.gson.annotations.SerializedName

data class TeamsTeamResponse(
    @field:SerializedName("profile") val profile: TeamsTeamProfileResponse
)