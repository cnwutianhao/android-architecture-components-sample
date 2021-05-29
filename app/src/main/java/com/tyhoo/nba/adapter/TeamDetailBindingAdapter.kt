package com.tyhoo.nba.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tyhoo.nba.R
import com.tyhoo.nba.util.GlideApp

@BindingAdapter("app:teamDetailBackgroundFromTeamCode")
fun bindTeamDetailBackgroundFromTeamCode(view: View, code: String?) {
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

@BindingAdapter("app:teamDetailImageFromTeamCode")
fun bindTeamDetailImageFromTeamCode(view: ImageView, code: String?) {
    code?.let {
        var teamLogo: Int = R.drawable.logo_lakers
        when (code) {
            "blazers" -> teamLogo = R.drawable.logo_blazers
            "bucks" -> teamLogo = R.drawable.logo_bucks
            "bulls" -> teamLogo = R.drawable.logo_bulls
            "cavaliers" -> teamLogo = R.drawable.logo_cavaliers
            "celtics" -> teamLogo = R.drawable.logo_celtics
            "clippers" -> teamLogo = R.drawable.logo_clippers
            "grizzlies" -> teamLogo = R.drawable.logo_grizzlies
            "hawks" -> teamLogo = R.drawable.logo_hawks
            "heat" -> teamLogo = R.drawable.logo_heat
            "hornets" -> teamLogo = R.drawable.logo_hornets
            "jazz" -> teamLogo = R.drawable.logo_jazz
            "kings" -> teamLogo = R.drawable.logo_kings
            "knicks" -> teamLogo = R.drawable.logo_knicks
            "lakers" -> teamLogo = R.drawable.logo_lakers
            "magic" -> teamLogo = R.drawable.logo_magic
            "mavericks" -> teamLogo = R.drawable.logo_mavericks
            "nets" -> teamLogo = R.drawable.logo_nets
            "nuggets" -> teamLogo = R.drawable.logo_nuggets
            "pacers" -> teamLogo = R.drawable.logo_pacers
            "pelicans" -> teamLogo = R.drawable.logo_pelicans
            "pistons" -> teamLogo = R.drawable.logo_pistons
            "raptors" -> teamLogo = R.drawable.logo_raptors
            "rockets" -> teamLogo = R.drawable.logo_rockets
            "sixers" -> teamLogo = R.drawable.logo_sixers
            "spurs" -> teamLogo = R.drawable.logo_spurs
            "suns" -> teamLogo = R.drawable.logo_suns
            "thunder" -> teamLogo = R.drawable.logo_thunder
            "timberwolves" -> teamLogo = R.drawable.logo_timberwolves
            "warriors" -> teamLogo = R.drawable.logo_warriors
            "wizards" -> teamLogo = R.drawable.logo_wizards
        }

        GlideApp.with(view.context)
            .load(teamLogo)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}