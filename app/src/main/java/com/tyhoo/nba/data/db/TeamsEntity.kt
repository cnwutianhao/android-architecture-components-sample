package com.tyhoo.nba.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class TeamsEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    val abbr: String,
    val city: String,
    val cityEn: String,
    val code: String,
    val conference: String,
    val displayAbbr: String,
    val displayConference: String,
    val division: String,
    val name: String,
    val nameEn: String
)