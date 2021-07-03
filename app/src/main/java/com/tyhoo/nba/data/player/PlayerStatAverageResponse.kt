package com.tyhoo.nba.data.player

import com.google.gson.annotations.SerializedName

data class PlayerStatAverageResponse(
    @field:SerializedName("assistsPg") val assistsPg: Float,
    @field:SerializedName("blocksPg") val blocksPg: Float,
    @field:SerializedName("defRebsPg") val defRebsPg: Float,
    @field:SerializedName("fgaPg") val fgaPg: Float,
    @field:SerializedName("fgmPg") val fgmPg: Float,
    @field:SerializedName("fgpct") val fgpct: Float,
    @field:SerializedName("foulsPg") val foulsPg: Float,
    @field:SerializedName("ftaPg") val ftaPg: Float,
    @field:SerializedName("ftmPg") val ftmPg: Float,
    @field:SerializedName("ftpct") val ftpct: Float,
    @field:SerializedName("games") val games: Int,
    @field:SerializedName("gamesStarted") val gamesStarted: Int,
    @field:SerializedName("minsPg") val minsPg: Float,
    @field:SerializedName("offRebsPg") val offRebsPg: Float,
    @field:SerializedName("pointsPg") val pointsPg: Float,
    @field:SerializedName("rebsPg") val rebsPg: Float,
    @field:SerializedName("stealsPg") val stealsPg: Float,
    @field:SerializedName("tpaPg") val tpaPg: Float,
    @field:SerializedName("tpmPg") val tpmPg: Float,
    @field:SerializedName("tppct") val tppct: Float,
    @field:SerializedName("turnoversPg") val turnoversPg: Float
)