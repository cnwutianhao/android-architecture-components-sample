package com.tyhoo.nba.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TeamsEntity::class], version = 1, exportSchema = false)
abstract class TeamsDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamsDao

    companion object {
        @Volatile
        private var instance: TeamsDatabase? = null

        fun getInstance(context: Context): TeamsDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): TeamsDatabase {
            return Room.databaseBuilder(context, TeamsDatabase::class.java, "teams").build()
        }
    }
}