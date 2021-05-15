package com.tyhoo.nba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tyhoo.nba.data.db.TeamsEntity
import com.tyhoo.nba.databinding.ListItemTeamsBinding
import com.tyhoo.nba.ui.home.HomeFragmentDirections

class TeamsAdapter : ListAdapter<TeamsEntity, RecyclerView.ViewHolder>(TeamsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TeamsViewHolder(
            ListItemTeamsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val team = getItem(position)
        (holder as TeamsViewHolder).bind(team)
    }

    class TeamsViewHolder(
        private val binding: ListItemTeamsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.team?.let { team ->
                    navigateToTeamDetail(team, it)
                }
            }
        }

        private fun navigateToTeamDetail(team: TeamsEntity, view: View) {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToTeamDetailFragment(team.code)
            view.findNavController().navigate(direction)
        }

        fun bind(item: TeamsEntity) {
            binding.apply {
                team = item
                executePendingBindings()
            }
        }
    }
}

private class TeamsDiffCallback : DiffUtil.ItemCallback<TeamsEntity>() {
    override fun areItemsTheSame(oldItem: TeamsEntity, newItem: TeamsEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TeamsEntity, newItem: TeamsEntity): Boolean {
        return oldItem == newItem
    }
}