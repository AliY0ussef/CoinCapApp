package com.example.coincapapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.coincapapp.data.CoinCap
import com.example.coincapapp.ui.Home
import com.example.coincapapp.viewmodel.CoinCapState
import com.example.coincapapp.viewmodel.CoinCapViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test


class HomeTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeLoadingState() {
        // Given a loading state
        val viewModel = mockk<CoinCapViewModel>()
        every { viewModel.coinCapState } returns mutableStateOf(CoinCapState(isLoading = true))

        composeTestRule.setContent {
            Home(viewModel = viewModel) {}
        }

        composeTestRule.onNodeWithText("Loading...").assertIsDisplayed()
    }

    @Test
    fun homeErrorState() {
        // Given an error state
        val viewModel = mockk<CoinCapViewModel>()
        every { viewModel.coinCapState } returns mutableStateOf(CoinCapState(error = "Mock Error"))

        composeTestRule.setContent {
            Home(viewModel = viewModel) {}
        }

        composeTestRule.onNodeWithText("Error Occurred").assertIsDisplayed()
    }

    @Test
    fun homeSuccessState() {
        // Given a success state
        val mockCoinCap = CoinCap("1","BTC", "$", "Bitcoin", "50000")
        val viewModel = mockk<CoinCapViewModel>()
        every { viewModel.coinCapState } returns mutableStateOf(CoinCapState(list = listOf(mockCoinCap)))

        composeTestRule.setContent {
            Home(viewModel = viewModel) {}
        }

        composeTestRule.onNodeWithText("Coin Cap").assertIsDisplayed()
    }
}