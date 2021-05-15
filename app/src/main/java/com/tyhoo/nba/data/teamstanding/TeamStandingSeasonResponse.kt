package com.tyhoo.nba.data.teamstanding

import com.google.gson.annotations.SerializedName

data class TeamStandingSeasonResponse(
    @field:SerializedName("isCurrent") val isCurrent: String,
    @field:SerializedName("rosterSeasonType") val rosterSeasonType: Int,
    @field:SerializedName("rosterSeasonYear") val rosterSeasonYear: String,
    @field:SerializedName("rosterSeasonYearDisplay") val rosterSeasonYearDisplay: String,
    @field:SerializedName("scheduleSeasonType") val scheduleSeasonType: Int,
    @field:SerializedName("scheduleSeasonYear") val scheduleSeasonYear: String,
    @field:SerializedName("scheduleYearDisplay") val scheduleYearDisplay: String,
    @field:SerializedName("statsSeasonType") val statsSeasonType: Int,
    @field:SerializedName("statsSeasonYear") val statsSeasonYear: String,
    @field:SerializedName("statsSeasonYearDisplay") val statsSeasonYearDisplay: String,
    @field:SerializedName("year") val year: String,
    @field:SerializedName("yearDisplay") val yearDisplay: String
)