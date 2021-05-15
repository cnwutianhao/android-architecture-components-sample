package com.tyhoo.nba.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class PlayersEntity(
    @PrimaryKey @ColumnInfo(name = "playerId") val playerId: String,
    val code: String,
    val displayName: String,
    val jerseyNo: String,
    val position: String,
    val teamCity: String,
    val teamName: String
)