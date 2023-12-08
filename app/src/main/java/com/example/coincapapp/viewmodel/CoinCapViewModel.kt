package com.example.coincapapp.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coincapapp.Api.coinCapService
import kotlinx.coroutines.launch

class CoinCapViewModel () : ViewModel(){

    private val _coinCapState = mutableStateOf(CoinCapState())
    val coinCapState : State<CoinCapState> = _coinCapState

    init {
        fetchCoinCap()
    }

    fun fetchCoinCap() {
        viewModelScope.launch {
            try {
                val response = coinCapService.getCoinCap()

                _coinCapState.value = _coinCapState.value.copy(
                    list = response.data,
                    error = null,
                    isLoading = false
                )
                Log.d("Checking_response", response.data.toString())

            } catch (e: Exception) {
                _coinCapState.value = _coinCapState.value.copy(
                    isLoading = false,
                    error = e.message.toString()
                )
                Log.d("Checking_error", e.message.toString())
            }
        }
    }
}