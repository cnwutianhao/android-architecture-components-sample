package com.tyhoo.nba.data.teams

import com.google.gson.annotations.SerializedName

data class TeamsPayloadResponse(
    @field:SerializedName("listGroups") val listGroups: List<TeamsListGroupsResponse>
)