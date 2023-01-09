package com.mth.example.shoppe

import androidx.annotation.DrawableRes

data class Product(
    val title: String,
    @DrawableRes
    val imageId: Int,
    val priceProduct: Int
)