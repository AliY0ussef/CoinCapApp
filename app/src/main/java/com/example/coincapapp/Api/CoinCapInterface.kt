package com.example.coincapapp.Api

import com.example.coincapapp.Constants
import com.example.coincapapp.data.CoinCapList
import retrofit2.http.GET

interface CoinCapInterface {

    @GET(Constants.EXTENSION_URL)
    suspend fun getCoinCap() : CoinCapList

}