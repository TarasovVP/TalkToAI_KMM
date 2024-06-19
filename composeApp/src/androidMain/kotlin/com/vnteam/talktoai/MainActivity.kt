package com.vnteam.talktoai

import App
import PlatformMessageDisplayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.vnteam.talktoai.onboarding.OnboardingContent
import domain.models.ScreenState
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val platformMessageDisplayer: PlatformMessageDisplayer by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val screenState = remember { mutableStateOf(ScreenState()) }
            OnboardingContent(screenState.value)
            LaunchedEffect(screenState.value.currentScreenState.value) {
                screenState.value.currentScreenState.value?.let {
                    platformMessageDisplayer.showPopupMessage(it)
                }
            }
        }
    }
}