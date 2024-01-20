package com.example.coincapapp.Api

import com.example.coincapapp.data.CoinCap
import com.example.coincapapp.data.CoinCapList
import retrofit2.http.GET
import retrofit2.http.Path

private const val EXTENSION_URL = "v2/rates"

interface CoinCapInterface {

    @GET(EXTENSION_URL)
    suspend fun getCoinCap() : CoinCapList

    @GET("$EXTENSION_URL/{id}")
    suspend fun getCoinCapDetails(
        @Path("id") id : String?
    ) : CoinCap
}