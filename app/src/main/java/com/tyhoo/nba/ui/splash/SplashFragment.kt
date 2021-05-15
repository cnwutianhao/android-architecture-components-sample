package com.tyhoo.nba.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.tyhoo.nba.databinding.FragmentSplashBinding
import com.tyhoo.nba.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var splashBinding: FragmentSplashBinding

    private var splashJob: Job? = null

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        splashBinding = FragmentSplashBinding.inflate(inflater, container, false)
        return splashBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getPlayers()
    }

    private fun getPlayers() {
        splashJob?.cancel()
        splashJob = lifecycleScope.launch {
            if (splashViewModel.getPlayers(requireContext())) {
                getTeams()
            }
        }
    }

    private fun getTeams() {
        splashJob?.cancel()
        splashJob = lifecycleScope.launch {
            if (splashViewModel.getTeams(requireContext())) {
                val direction = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                view?.findNavController()?.navigate(direction)
            }
        }
    }

    companion object {
        const val TAG = "SplashFragment"
    }
}