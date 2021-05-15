package com.tyhoo.nba.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.tyhoo.nba.data.SplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: SplashRepository
) : ViewModel() {

    suspend fun getPlayers(context: Context): Boolean {
        return repository.getPlayers(context)
    }

    suspend fun getTeams(context: Context): Boolean {
        return repository.getTeams(context)
    }
}