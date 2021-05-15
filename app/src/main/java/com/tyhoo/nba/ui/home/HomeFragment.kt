package com.tyhoo.nba.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.tyhoo.nba.R
import com.tyhoo.nba.adapter.HomePagerAdapter
import com.tyhoo.nba.adapter.PLAYERS_PAGE_INDEX
import com.tyhoo.nba.adapter.TEAMS_PAGE_INDEX
import com.tyhoo.nba.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = HomePagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            PLAYERS_PAGE_INDEX -> R.drawable.players_tab_selector
            TEAMS_PAGE_INDEX -> R.drawable.teams_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            PLAYERS_PAGE_INDEX -> "Players"
            TEAMS_PAGE_INDEX -> "Teams"
            else -> null
        }
    }
}