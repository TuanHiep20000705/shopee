package com.mth.example.shoppe

import androidx.annotation.DrawableRes

data class Feature(
    val title: String,
    @DrawableRes
    val iconId: Int
)
