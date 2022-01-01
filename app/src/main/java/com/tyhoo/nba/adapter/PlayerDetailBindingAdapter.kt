package com.tyhoo.nba.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tyhoo.nba.R
import com.tyhoo.nba.data.player.PlayerPayloadResponse
import com.tyhoo.nba.util.GlideApp

@BindingAdapter("playerDetailImageFromPlayerId")
fun bindPlayerDetailImageFromPlayerId(view: ImageView, playerId: String?) {
    // https://china.nba.cn/media/img/players/head/260x190/2544.png
    val imageUrl = "https://china.nba.cn/media/img/players/head/260x190/$playerId.png"

    GlideApp.with(view.context)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}

@BindingAdapter("playerDetailBackgroundFromTeamCode")
fun bindPlayerDetailBackgroundFromTeamCode(view: View, code: String?) {
    code?.let {
        var color: Int = R.color.white
        when (code) {
            "hawks" -> color = R.color.hawks
            "celtics" -> color = R.color.celtics
            "nets" -> color = R.color.nets
            "hornets" -> color = R.color.hornets
            "bulls" -> color = R.color.bulls
            "cavaliers" -> color = R.color.cavaliers
            "pistons" -> color = R.color.pistons
            "pacers" -> color = R.color.pacers
            "heat" -> color = R.color.heat
            "bucks" -> color = R.color.bucks
            "knicks" -> color = R.color.knicks
            "magic" -> color = R.color.magic
            "sixers" -> color = R.color.sixers
            "raptors" -> color = R.color.raptors
            "wizards" -> color = R.color.wizards
            "mavericks" -> color = R.color.mavericks
            "nuggets" -> color = R.color.nuggets
            "warriors" -> color = R.color.warriors
            "rockets" -> color = R.color.rockets
            "clippers" -> color = R.color.clippers
            "lakers" -> color = R.color.lakers
            "grizzlies" -> color = R.color.grizzlies
            "timberwolves" -> color = R.color.timberwolves
            "pelicans" -> color = R.color.pelicans
            "thunder" -> color = R.color.thunder
            "suns" -> color = R.color.suns
            "blazers" -> color = R.color.blazers
            "kings" -> color = R.color.kings
            "spurs" -> color = R.color.spurs
            "jazz" -> color = R.color.jazz
        }
        view.setBackgroundResource(color)
    }
}

@BindingAdapter("app:playerDetailPointsPg")
fun bindPlayerDetailPointsPg(view: TextView, payload: PlayerPayloadResponse?) {
    payload?.let {
        val teams = it.player.stats.regularSeasonStat.playerTeams
        val currentSeasonNum = teams.size - 1
        val currentSeasonPointsPg = teams[currentSeasonNum].statAverage.pointsPg

        view.text = currentSeasonPointsPg.toString()
    }
}

@BindingAdapter("app:playerDetailRebsPg")
fun bindPlayerDetailRebsPg(view: TextView, payload: PlayerPayloadResponse?) {
    payload?.let {
        val teams = it.player.stats.regularSeasonStat.playerTeams
        val currentSeasonNum = teams.size - 1
        val currentSeasonRebsPg = teams[currentSeasonNum].statAverage.rebsPg

        view.text = currentSeasonRebsPg.toString()
    }
}

@BindingAdapter("app:playerDetailAssistsPg")
fun bindPlayerDetailAssistsPg(view: TextView, payload: PlayerPayloadResponse?) {
    payload?.let {
        val teams = it.player.stats.regularSeasonStat.playerTeams
        val currentSeasonNum = teams.size - 1
        val currentSeasonAssistsPg = teams[currentSeasonNum].statAverage.assistsPg

        view.text = currentSeasonAssistsPg.toString()
    }
}

@BindingAdapter("app:playerDetailFloatFormat")
fun bindPlayerDetailFloatFormat(view: TextView, data: Float?) {
    data?.let {
        view.text = String.format("%.1f", data)
    }
}
