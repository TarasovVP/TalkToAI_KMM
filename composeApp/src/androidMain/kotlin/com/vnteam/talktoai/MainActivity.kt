package com.vnteam.talktoai

import App
import PlatformMessageDisplayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.vnteam.talktoai.chat.ChatScreen
import domain.models.InfoMessage
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val platformMessageDisplayer: PlatformMessageDisplayer by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isMessageDeleteModeState = remember { mutableStateOf<Boolean?>(null) }
            val infoMessageState = remember { mutableStateOf<InfoMessage?>(null) }
            val progressVisibilityState = remember { mutableStateOf(false) }
            ChatScreen(
                1L,
                isMessageDeleteModeState,
                infoMessageState = infoMessageState,
                progressVisibilityState = progressVisibilityState
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}