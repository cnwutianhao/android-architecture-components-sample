package com.tyhoo.nba.di

import com.tyhoo.nba.api.NBAService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideNBAService(): NBAService {
        return NBAService.create()
    }
}