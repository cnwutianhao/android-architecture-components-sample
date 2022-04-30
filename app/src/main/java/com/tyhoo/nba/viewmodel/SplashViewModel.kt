package com.tyhoo.nba.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.tyhoo.nba.R
import com.tyhoo.nba.base.TAG
import com.tyhoo.nba.data.SplashRepository
import com.tyhoo.nba.ui.splash.SplashFragmentDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: SplashRepository
) : ViewModel() {

    fun requestData(context: Context, owner: LifecycleOwner, view: View?) {
        viewModelScope.launch {
            val results = listOf(
                async { playersObserver(context, owner) },
                async { teamsObserver(context, owner) }
            )
            results.awaitAll()

            delay(1000)
            val direction = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            view?.findNavController()?.navigate(direction)
        }
    }

    private suspend fun playersObserver(
        context: Context, owner: LifecycleOwner
    ) = Observer<Boolean> { result ->
        if (result == true) {
            Log.d(TAG, "球员数据请求成功")
        } else {
            Log.d(TAG, "球员数据请求失败")
        }
    }.apply {
        _loadingContent.value = context.getString(R.string.splash_load_players)
        getPlayers(context).observe(owner, this)
    }

    private suspend fun teamsObserver(
        context: Context, owner: LifecycleOwner
    ) = Observer<Boolean> { result ->
        if (result == true) {
            Log.d(TAG, "球队数据请求成功")
        } else {
            Log.d(TAG, "球队数据请求失败")
        }
    }.apply {
        _loadingContent.value = context.getString(R.string.splash_load_teams)
        getTeams(context).observe(owner, this)
    }

    private suspend fun getPlayers(context: Context): LiveData<Boolean> {
        return repository.getPlayers(context)
    }

    private suspend fun getTeams(context: Context): LiveData<Boolean> {
        return repository.getTeams(context)
    }

    private val _loadingContent = MutableLiveData<String>()
    val loadingContent: LiveData<String>
        get() = _loadingContent
}