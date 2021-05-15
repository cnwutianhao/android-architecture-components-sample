package com.tyhoo.nba.data.teams

import com.google.gson.annotations.SerializedName

data class TeamsListGroupsResponse(
    @field:SerializedName("teams") val teams: List<TeamsTeamResponse>,
    @field:SerializedName("conference") val conference: String
)