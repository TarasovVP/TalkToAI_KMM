package com.vnteam.talktoai

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import data.database.db_entities.Message
import domain.CommonExtensions.EMPTY
import domain.enums.MessageStatus
import domain.repositories.MessageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.util.Date

class MainActivity : ComponentActivity() {

    private val messageRepository: MessageRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            messageRepository.insertMessage(Message(id = Date().time + 1,
                chatId = 1,
                author = "gpt-3.5-turbo",
                message = "Hello, Who are you?",
                updatedAt = 123456,
                status = MessageStatus.REQUESTING))
        }
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}