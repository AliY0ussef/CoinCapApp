package com.example.coincapapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoinCap(
    val id             : String? = null,
    val symbol         : String? = null,
    val currencySymbol : String? = null,
    val type           : String? = null,
    val rateUsd        : String? = null
) : Parcelable

data class CoinCapList (
    val data      : List<CoinCap>,
    val timestamp : Long
)