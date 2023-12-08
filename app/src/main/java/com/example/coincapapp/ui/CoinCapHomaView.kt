package com.example.coincapapp.ui

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coincapapp.data.CoinCap
import com.example.coincapapp.viewmodel.CoinCapViewModel

@Composable
fun Home(
    modifier : Modifier = Modifier,
    viewModel : CoinCapViewModel = viewModel(),
    navigateToDetail : (CoinCap) -> Unit
){
    val coinCapState = viewModel.coinCapState

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        when{
            coinCapState.value.isLoading -> {
                CircularProgressIndicator(
                    modifier = modifier.align(Alignment.Center)
                )
            }

            coinCapState.value.error != null -> {
                Text(
                    text = "Error Occured"
                )
                Log.d("Checking_view", coinCapState.value.error.toString())
            }

            else -> {
                CoinCapScreen(listCoinCaps = coinCapState.value.list, navigateToDetail)
            }
        }
    }
}

@Composable
fun CoinCapScreen(
    listCoinCaps : List<CoinCap>,
    navigateToDetail : (CoinCap) -> Unit
){
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopBarView(
                title = "Coin Cap"
            ) {

            }
        },
        scaffoldState = scaffoldState
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            items(listCoinCaps){
                coinCap -> CoinCapItem(coinCap = coinCap, navigateToDetail)
            }
        }
    }
}

@Composable
fun CoinCapItem(
    coinCap : CoinCap,
    navigateToDetail : (CoinCap) -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { navigateToDetail(coinCap) },
        elevation = 4.dp
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            coinCap.currencySymbol?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )
            }

            coinCap.symbol?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )
            }
        }
    }
}