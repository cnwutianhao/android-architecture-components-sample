package com.tyhoo.nba.di

import android.content.Context
import com.tyhoo.nba.data.db.PlayersDao
import com.tyhoo.nba.data.db.PlayersDatabase
import com.tyhoo.nba.data.db.TeamsDao
import com.tyhoo.nba.data.db.TeamsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providePlayersDatabase(@ApplicationContext context: Context): PlayersDatabase {
        return PlayersDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideTeamsDatabase(@ApplicationContext context: Context): TeamsDatabase {
        return TeamsDatabase.getInstance(context)
    }

    @Provides
    fun providePlayersDao(database: PlayersDatabase): PlayersDao {
        return database.playerDao()
    }

    @Provides
    fun provideTeamsDao(database: TeamsDatabase): TeamsDao {
        return database.teamDao()
    }
}