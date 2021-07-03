package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerProfileResponse(
    @field:SerializedName("abbr") val abbr: String,
    @field:SerializedName("city") val city: String,
    @field:SerializedName("cityEn") val cityEn: String,
    @field:SerializedName("code") val code: String,
    @field:SerializedName("conference") val conference: String,
    @field:SerializedName("displayAbbr") val displayAbbr: String,
    @field:SerializedName("displayConference") val displayConference: String,
    @field:SerializedName("division") val division: String,
    @field:SerializedName("id") val id: String,
    @field:SerializedName("isAllStarTeam") val isAllStarTeam: Boolean,
    @field:SerializedName("isLeagueTeam") val isLeagueTeam: Boolean,
    @field:SerializedName("leagueId") val leagueId: String,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("nameEn") val nameEn: String
)