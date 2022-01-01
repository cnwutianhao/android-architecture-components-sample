package com.tyhoo.nba.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tyhoo.nba.databinding.FragmentSplashBinding
import com.tyhoo.nba.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

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
        // Bind layout views to Architecture Components.
        // https://developer.android.com/topic/libraries/data-binding/architecture
        splashBinding = FragmentSplashBinding.inflate(inflater, container, false)
        splashBinding.lifecycleOwner = viewLifecycleOwner
        splashBinding.viewModel = splashViewModel

        return splashBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestData()
    }

    override fun onDestroyView() {
        splashJob?.cancel()
        super.onDestroyView()
    }

    private fun requestData() {
        splashJob?.cancel()
        splashJob = lifecycleScope.launchWhenResumed {
            splashViewModel.requestData(requireContext(), viewLifecycleOwner, view)
        }
    }
}