package com.tyhoo.nba.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.tyhoo.nba.adapter.PlayerSeasonStatusAdapter
import com.tyhoo.nba.databinding.FragmentPlayerDetailBinding
import com.tyhoo.nba.viewmodel.PlayerDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

@AndroidEntryPoint
class PlayerDetailFragment : Fragment() {

    private lateinit var playerDetailBinding: FragmentPlayerDetailBinding

    private val args: PlayerDetailFragmentArgs by navArgs()

    private var playerDetailJob: Job? = null

    private val playerDetailViewModel: PlayerDetailViewModel by viewModels()

    private lateinit var playerSeasonStatusAdapter: PlayerSeasonStatusAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Bind layout views to Architecture Components.
        // https://developer.android.com/topic/libraries/data-binding/architecture
        playerDetailBinding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        playerDetailBinding.lifecycleOwner = viewLifecycleOwner
        playerDetailBinding.viewModel = playerDetailViewModel

        return playerDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUI()
        requestData()
    }

    override fun onDestroyView() {
        playerDetailJob?.cancel()
        super.onDestroyView()
    }

    private fun subscribeUI() {
        playerSeasonStatusAdapter = PlayerSeasonStatusAdapter()
        playerDetailBinding.playerSeasonStatusList.adapter = playerSeasonStatusAdapter
    }

    private fun requestData() {
        playerDetailJob?.cancel()
        playerDetailJob = lifecycleScope.launchWhenResumed {
            playerDetailViewModel.requestData(
                viewLifecycleOwner, args.playerCode, playerSeasonStatusAdapter
            )
        }
    }
}