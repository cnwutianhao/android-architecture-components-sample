package com.tyhoo.nba.ui.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.tyhoo.nba.databinding.FragmentTeamDetailBinding
import com.tyhoo.nba.viewmodel.TeamDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamDetailFragment : Fragment() {

    private lateinit var teamDetailBinding: FragmentTeamDetailBinding

    private val args: TeamDetailFragmentArgs by navArgs()

    private var teamDetailJob: Job? = null

    private val teamDetailViewModel: TeamDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        teamDetailBinding = FragmentTeamDetailBinding.inflate(inflater, container, false)
        return teamDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        teamDetailJob?.cancel()
        teamDetailJob = lifecycleScope.launch {
            teamDetailViewModel.teamStanding(args.teamCode)
                .observe(viewLifecycleOwner) { teamStanding ->
                    teamDetailBinding.team = teamStanding.payload.team
                }
        }
    }

    override fun onDestroyView() {
        teamDetailJob?.cancel()
        super.onDestroyView()
    }
}