package com.tyhoo.nba.ui.player

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.tyhoo.nba.adapter.PlayersAdapter
import com.tyhoo.nba.databinding.FragmentPlayersBinding
import com.tyhoo.nba.viewmodel.PlayersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlayersFragment : Fragment() {

    private lateinit var playersBinding: FragmentPlayersBinding

    private var playersJob: Job? = null

    private val playersViewModel: PlayersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        playersBinding = FragmentPlayersBinding.inflate(inflater, container, false)
        return playersBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playersAdapter = PlayersAdapter()
        playersBinding.playerList.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
        playersBinding.playerList.adapter = playersAdapter
        subscribeUi(playersAdapter)
    }

    override fun onDestroyView() {
        playersJob?.cancel()
        super.onDestroyView()
    }

    private fun subscribeUi(adapter: PlayersAdapter) {
        playersJob?.cancel()
        playersJob = lifecycleScope.launch {
            playersViewModel.players.observe(viewLifecycleOwner) { players ->
                adapter.submitList(players)
            }
        }
    }
}