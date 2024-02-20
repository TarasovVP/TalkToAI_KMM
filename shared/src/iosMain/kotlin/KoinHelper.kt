import domain.repositories.MessageRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class KoinHelper: KoinComponent {
    private val messageRepository: MessageRepository by inject()
    fun getMessageRepository() = messageRepository
}