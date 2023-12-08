package com.example.coincapapp

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coincapapp.data.CoinCap
import com.example.coincapapp.ui.Detail
import com.example.coincapapp.ui.Home

@Composable
fun Navigation(
    navHostController: NavHostController = rememberNavController()
) {

    NavHost(navController = navHostController, startDestination = Screen.HomeScreen.route){
        composable(route = Screen.HomeScreen.route){
            Home(navigateToDetail = {
                navHostController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navHostController.navigate(Screen.DetailScreen.route)
            })
        }

        composable(
            route = Screen.DetailScreen.route
        ){
            val coinCap = navHostController.previousBackStackEntry?.savedStateHandle?.get<CoinCap>("cat") ?: CoinCap("","","", "", "")
            Detail(coinCap = coinCap)
        }
    }
}