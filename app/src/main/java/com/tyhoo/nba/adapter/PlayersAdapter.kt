package com.tyhoo.nba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tyhoo.nba.data.db.PlayersEntity
import com.tyhoo.nba.databinding.ListItemPlayersBinding
import com.tyhoo.nba.ui.home.HomeFragmentDirections

class PlayersAdapter : ListAdapter<PlayersEntity, RecyclerView.ViewHolder>(PlayersDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlayersViewHolder(
            ListItemPlayersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val player = getItem(position)
        (holder as PlayersViewHolder).bind(player)
    }

    class PlayersViewHolder(
        private val binding: ListItemPlayersBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.player?.let { player ->
                    navigateToPlayerDetail(player, it)
                }
            }
        }

        private fun navigateToPlayerDetail(player: PlayersEntity, view: View) {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToPlayerDetailFragment(player.code)
            view.findNavController().navigate(direction)
        }

        fun bind(item: PlayersEntity) {
            binding.apply {
                player = item
                executePendingBindings()
            }
        }
    }
}

class PlayersDiffCallback : DiffUtil.ItemCallback<PlayersEntity>() {

    override fun areItemsTheSame(oldItem: PlayersEntity, newItem: PlayersEntity): Boolean {
        return oldItem.playerId == newItem.playerId
    }

    override fun areContentsTheSame(oldItem: PlayersEntity, newItem: PlayersEntity): Boolean {
        return oldItem == newItem
    }
}