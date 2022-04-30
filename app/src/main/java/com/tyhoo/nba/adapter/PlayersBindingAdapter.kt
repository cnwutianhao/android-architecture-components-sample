package com.tyhoo.nba.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tyhoo.nba.util.GlideApp

@BindingAdapter(value = ["imageFromPlayerId"])
fun bindImageFromPlayerId(view: ImageView, playerId: String?) {
    // https://china.nba.cn/media/img/players/head/260x190/2544.png
    val imageUrl = "https://china.nba.cn/media/img/players/head/260x190/$playerId.png"

    GlideApp.with(view.context)
        .asDrawable()
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(view)
}