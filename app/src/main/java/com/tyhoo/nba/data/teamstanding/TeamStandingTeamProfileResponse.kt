package com.tyhoo.nba.data.teamstanding

import com.google.gson.annotations.SerializedName

data class TeamStandingTeamProfileResponse(
    @field:SerializedName("abbr") val abbr: String,
    @field:SerializedName("city") val city: String,
    @field:SerializedName("cityEn") val cityEn: String,
    @field:SerializedName("code") val code: String,
    @field:SerializedName("conference") val conference: String,
    @field:SerializedName("displayAbbr") val displayAbbr: String,
    @field:SerializedName("displayConference") val displayConference: String,
    @field:SerializedName("division") val division: String,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("nameEn") val nameEn: String
)