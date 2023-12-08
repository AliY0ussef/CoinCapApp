package com.example.coincapapp.Api

import com.example.coincapapp.data.CoinCap
import com.example.coincapapp.data.CoinCapList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://api.coincap.io/"
private const val EXTENSION_URL = "v2/rates"

interface CoinCapInterface {

    @GET(EXTENSION_URL)
    suspend fun getCoinCap() : CoinCapList

    @GET("$EXTENSION_URL/{id}")
    suspend fun getCoinCapDetails(
        @Path("id") id : String?
    ) : CoinCap
}

val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

val coinCapService = retrofit.create(CoinCapInterface::class.java)