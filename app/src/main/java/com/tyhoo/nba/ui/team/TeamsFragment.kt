package com.tyhoo.nba.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.tyhoo.nba.adapter.TeamsAdapter
import com.tyhoo.nba.databinding.FragmentTeamsBinding
import com.tyhoo.nba.viewmodel.TeamsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamsFragment : Fragment() {

    private lateinit var teamsBinding: FragmentTeamsBinding

    private var teamsJob: Job? = null

    private val teamsViewModel: TeamsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        teamsBinding = FragmentTeamsBinding.inflate(inflater, container, false)
        return teamsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val teamsAdapter = TeamsAdapter()
        teamsBinding.teamList.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
        teamsBinding.teamList.adapter = teamsAdapter
        subscribeUi(teamsAdapter)
    }

    private fun subscribeUi(adapter: TeamsAdapter) {
        teamsJob?.cancel()
        teamsJob = lifecycleScope.launch {
            teamsViewModel.teams.observe(viewLifecycleOwner) { teams ->
                adapter.submitList(teams)
            }
        }
    }

    companion object {
        const val TAG = "TeamsFragment"
    }
}