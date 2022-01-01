package com.tyhoo.nba.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.tyhoo.nba.R
import com.tyhoo.nba.data.SplashRepository
import com.tyhoo.nba.ui.splash.SplashFragmentDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: SplashRepository
) : ViewModel() {

    suspend fun requestData(context: Context, owner: LifecycleOwner, view: View?) {
        playersObserver(context, owner, view)
    }

    private suspend fun playersObserver(
        context: Context, owner: LifecycleOwner, view: View?
    ) = Observer<Boolean> { result ->
        if (result == true) {
            viewModelScope.launch { teamsObserver(context, owner, view) }
        }
    }.apply {
        _loadingContent.value = context.getString(R.string.splash_load_players)
        getPlayers(context).observe(owner, this)
    }

    private suspend fun teamsObserver(
        context: Context, owner: LifecycleOwner, view: View?
    ) = Observer<Boolean> { result ->
        if (result == true) {
            val direction = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            view?.findNavController()?.navigate(direction)
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