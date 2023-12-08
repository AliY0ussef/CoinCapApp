package com.example.coincapapp.viewmodel

import com.example.coincapapp.data.CoinCap

data class CoinCapState(
    val isLoading : Boolean = true,
    val list : List<CoinCap> = emptyList(),
    val error : String? = ""
)