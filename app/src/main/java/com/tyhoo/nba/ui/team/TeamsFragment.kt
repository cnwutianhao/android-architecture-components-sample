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

@AndroidEntryPoint
class TeamsFragment : Fragment() {

    private lateinit var teamsBinding: FragmentTeamsBinding

    private var teamsJob: Job? = null

    private val teamsViewModel: TeamsViewModel by viewModels()

    private lateinit var teamsAdapter: TeamsAdapter

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
        subscribeUI()
        requestData()
    }

    override fun onDestroyView() {
        teamsJob?.cancel()
        super.onDestroyView()
    }

    private fun subscribeUI() {
        teamsAdapter = TeamsAdapter()
        teamsBinding.teamList.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
        teamsBinding.teamList.adapter = teamsAdapter
    }

    private fun requestData() {
        teamsJob?.cancel()
        teamsJob = lifecycleScope.launchWhenResumed {
            teamsViewModel.requestData(viewLifecycleOwner, teamsAdapter)
        }
    }
}