package com.tyhoo.nba.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.tyhoo.nba.databinding.FragmentPlayerDetailBinding
import com.tyhoo.nba.viewmodel.PlayerDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlayerDetailFragment : Fragment() {

    private lateinit var playerDetailBinding: FragmentPlayerDetailBinding

    private val args: PlayerDetailFragmentArgs by navArgs()

    private var playerDetailJob: Job? = null

    private val playerDetailViewModel: PlayerDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        playerDetailBinding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return playerDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playerDetailJob?.cancel()
        playerDetailJob = lifecycleScope.launch {
            playerDetailViewModel.player(args.playerCode).observe(viewLifecycleOwner) { player ->
                playerDetailBinding.payload = player.payload
            }
        }
    }

    override fun onDestroyView() {
        playerDetailJob?.cancel()
        super.onDestroyView()
    }
}