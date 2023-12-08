package com.example.coincapapp.repo

import com.example.coincapapp.data.CoinCap

interface CoinCapRepo {

    suspend fun getCoinCap() : List<CoinCap>
}