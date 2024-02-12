package com.example.coincapapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import com.example.coincapapp.data.CoinCap
import com.example.coincapapp.ui.Detail
import org.junit.Rule
import org.junit.Test

class DetailTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Composable
    @Test
    fun detailContentDisplayed() {
        val coinCap = CoinCap(
            symbol = "BTC",
            currencySymbol = "USD",
            rateUsd = "50000.0",
            type = "Cryptocurrency"
        )
        val navController = rememberNavController()

        composeTestRule.setContent {
            Detail(coinCap = coinCap, navController = navController)
        }

        composeTestRule.onNodeWithText("SYMBOL : ${coinCap.symbol}").assertExists()
        composeTestRule.onNodeWithText("CURRENCY SYMBOL: ${coinCap.currencySymbol}").assertExists()
        composeTestRule.onNodeWithText("RATE TO USD: ${coinCap.rateUsd}").assertExists()
        composeTestRule.onNodeWithText("TYPE: ${coinCap.type}").assertExists()
    }
}