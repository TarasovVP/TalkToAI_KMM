package com.vnteam.talktoai

import App
import PlatformMessageDisplayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import domain.CommonExtensions.EMPTY
import domain.repositories.MessageRepository
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val messageRepository: MessageRepository by inject()
    private val platformMessageDisplayer: PlatformMessageDisplayer by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val messageState: MutableState<String> = remember { mutableStateOf(String.EMPTY) }
            App(messageRepository, messageState)
            LaunchedEffect(messageState.value) {
                if (messageState.value.isNotEmpty()) platformMessageDisplayer.showPopupMessage(messageState.value)
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}