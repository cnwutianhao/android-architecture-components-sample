package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerRegularSeasonStatResponse(
    @field:SerializedName("playerTeams") val playerTeams: List<PlayerTeamsResponse>
)