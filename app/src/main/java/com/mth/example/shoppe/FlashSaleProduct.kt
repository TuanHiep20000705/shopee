package com.mth.example.shoppe

import androidx.annotation.DrawableRes

data class FlashSaleProduct(
    val price: Int,
    @DrawableRes
    val imageId: Int,
    val saleRate: Int
)
