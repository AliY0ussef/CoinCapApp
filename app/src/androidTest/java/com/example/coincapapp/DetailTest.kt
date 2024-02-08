package com.example.coincapapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.example.coincapapp.data.CoinCap
import com.example.coincapapp.ui.Detail
import org.junit.Rule
import org.junit.Test

class DetailTest {

    // Create a Compose test rule
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun detailScreen_RenderedCorrectly() {
        // Mock data
        val coinCap = CoinCap(
            symbol = "BTC",
            currencySymbol = "$",
            rateUsd = "50000",
            type = "Crypto"
        )

        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        // Launch the composable with mock data
        composeTestRule.setContent {
            Detail(coinCap = coinCap, navController = navController)
        }

        // Verify that the text elements are displayed correctly
        composeTestRule.onNodeWithText("SYMBOL : ${coinCap.symbol}").assertExists()
        composeTestRule.onNodeWithText("CURRENCY SYMBOL: ${coinCap.currencySymbol}").assertExists()
        composeTestRule.onNodeWithText("RATE TO USD: ${coinCap.rateUsd}").assertExists()
        composeTestRule.onNodeWithText("TYPE: ${coinCap.type}").assertExists()
    }
}