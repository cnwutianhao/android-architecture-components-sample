package com.tyhoo.nba.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayersDao {
    @Query("SELECT * FROM players")
    fun getPlayers(): Flow<List<PlayersEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayerList(players: List<PlayersEntity>)
}