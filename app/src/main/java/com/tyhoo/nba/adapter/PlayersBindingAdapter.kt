package com.tyhoo.nba.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tyhoo.nba.util.GlideApp

@BindingAdapter("imageFromPlayerId")
fun bindImageFromPlayerId(view: ImageView, playerId: String?) {
    // https://china.nba.com/media/img/players/head/260x190/2544.png
    val imageUrl = "https://china.nba.com/media/img/players/head/260x190/$playerId.png"

    GlideApp.with(view.context)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}