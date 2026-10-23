package com.example.lab_7

import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.jetbrains.annotations.TestOnly
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_races_and_return_home(){
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()


    }

    @Test
    fun navigate_to_driver_and_verify(){
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Luis Hamilton")

        composeTestRule
            .onNodeWithText("Luis Hamilton")
            .assertExists()

        composeTestRule
            .onNodeWithTag("clearButton")
            .performClick()

        composeTestRule
            .onNodeWithTag("goHome")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Driver")
            .assertExists()
    }
}