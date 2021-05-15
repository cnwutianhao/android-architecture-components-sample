package com.tyhoo.nba.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PlayersEntity::class], version = 1, exportSchema = false)
abstract class PlayersDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayersDao

    companion object {
        @Volatile
        private var instance: PlayersDatabase? = null

        fun getInstance(context: Context): PlayersDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): PlayersDatabase {
            return Room.databaseBuilder(context, PlayersDatabase::class.java, "players").build()
        }
    }
}