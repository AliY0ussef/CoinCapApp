package com.example.coincapapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import com.example.coincapapp.ui.TopBarView
import org.junit.Rule
import org.junit.Test


class TopBarViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun topBarViewTest() {
        val title = "Test Title"

        val onBackNavigation: () -> Unit = {}

        composeTestRule.setContent {
            TopBarView(title = title, onBackNavigation = onBackNavigation)
        }

        composeTestRule.onNodeWithText(title).assertIsDisplayed()

        if (!title.contains("Coin Cap")) {
            composeTestRule.onNodeWithContentDescription("Back").assertIsDisplayed()
        }
    }
}