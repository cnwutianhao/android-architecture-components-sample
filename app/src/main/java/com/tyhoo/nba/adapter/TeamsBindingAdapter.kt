package com.tyhoo.nba.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tyhoo.nba.R
import com.tyhoo.nba.util.GlideApp

@BindingAdapter("imageFromCode")
fun bindImageFromCode(view: ImageView, code: String) {
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