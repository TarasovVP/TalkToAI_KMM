import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import domain.ApiRequest
import domain.models.MessageApi
import domain.repositories.MessageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(messageRepository: MessageRepository = koinInject(), onMessageDisplay: (String) -> Unit = {}) {

    val platformCoroutineDispatcher = PlatformCoroutineDispatcher()

    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        val greeting = remember { Greeting().greet() }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                doSomething(messageRepository, platformCoroutineDispatcher, onMessageDisplay) }
            ) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource("compose-multiplatform.xml"), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

fun doSomething(
    messageRepository: MessageRepository? = null,
    platformCoroutineDispatcher: PlatformCoroutineDispatcher,
    onMessageDisplay: (String) -> Unit = {}
) {
    CoroutineScope(platformCoroutineDispatcher.io).launch {
        messageRepository?.sendRequest(
            ApiRequest(
                model = "gpt-3.5-turbo", temperature = 0.7f, messages = listOf(
                    MessageApi(role = "user", content = "Hello")
                )
            )
        )?.collect {
            launch(platformCoroutineDispatcher.main) {
                onMessageDisplay.invoke(it.toString())
            }
        } ?: withContext(platformCoroutineDispatcher.main) {
            onMessageDisplay.invoke("No message repository")
        }
    }
}