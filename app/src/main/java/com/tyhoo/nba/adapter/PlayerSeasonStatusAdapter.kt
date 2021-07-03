package com.tyhoo.nba.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tyhoo.nba.data.player.PlayerTeamsResponse
import com.tyhoo.nba.databinding.ListItemPlayerSeasonStatusBinding

class PlayerSeasonStatusAdapter :
    ListAdapter<PlayerTeamsResponse, RecyclerView.ViewHolder>(PlayerSeasonStatusDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlayerSeasonStatusViewHolder(
            ListItemPlayerSeasonStatusBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as PlayerSeasonStatusViewHolder).bind(item)
    }

    inner class PlayerSeasonStatusViewHolder(
        private val binding: ListItemPlayerSeasonStatusBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlayerTeamsResponse) {
            binding.apply {
                data = item
                executePendingBindings()
            }
        }
    }
}

private class PlayerSeasonStatusDiffCallback : DiffUtil.ItemCallback<PlayerTeamsResponse>() {

    override fun areItemsTheSame(
        oldItem: PlayerTeamsResponse, newItem: PlayerTeamsResponse
    ): Boolean {
        return oldItem.season == newItem.season
    }

    override fun areContentsTheSame(
        oldItem: PlayerTeamsResponse, newItem: PlayerTeamsResponse
    ): Boolean {
        return oldItem == newItem
    }
}