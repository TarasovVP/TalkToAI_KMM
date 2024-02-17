package com.vnteam.talktoai

import App
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import domain.repositories.MessageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val messageRepository: MessageRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(messageRepository) { message ->
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}