package com.vnteam.talktoai

import App
import PlatformMessageDisplayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import domain.repositories.MessageRepository
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val messageRepository: MessageRepository by inject()
    private val platformMessageDisplayer: PlatformMessageDisplayer by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(messageRepository) { message ->
                if (message.isNotEmpty()) platformMessageDisplayer.showPopupMessage(message)
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}