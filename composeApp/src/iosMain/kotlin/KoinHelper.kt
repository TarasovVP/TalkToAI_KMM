import io.ktor.utils.io.errors.IOException
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import presentation.chat.ChatViewModel

class KoinHelper : KoinComponent {
    private val chatViewModel: ChatViewModel by inject()

    @Throws(
        IOException::class,
        IllegalArgumentException::class,
        IllegalStateException::class
    )
    fun getChatViewModel(): ChatViewModel = chatViewModel
}