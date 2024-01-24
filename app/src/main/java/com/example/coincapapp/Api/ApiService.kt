package com.example.coincapapp.Api

import com.example.coincapapp.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    val coinCapService: CoinCapInterface = retrofit.create(CoinCapInterface::class.java)
}