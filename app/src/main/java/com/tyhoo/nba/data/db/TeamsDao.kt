package com.tyhoo.nba.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamsDao {
    @Query("SELECT * FROM teams")
    fun getTeams(): Flow<List<TeamsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamList(teams: List<TeamsEntity>)

    @Query("DELETE FROM teams")
    suspend fun deleteTeamList()
}