package com.tyhoo.nba.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tyhoo.nba.ui.team.TeamsFragment
import com.tyhoo.nba.ui.player.PlayersFragment

const val PLAYERS_PAGE_INDEX = 0
const val TEAMS_PAGE_INDEX = 1

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        PLAYERS_PAGE_INDEX to { PlayersFragment() },
        TEAMS_PAGE_INDEX to { TeamsFragment() }
    )

    override fun getItemCount(): Int {
        return tabFragmentsCreators.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}