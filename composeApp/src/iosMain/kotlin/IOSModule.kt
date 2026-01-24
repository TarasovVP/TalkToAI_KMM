
import data.database.DatabaseDriverFactory
import domain.usecases.ChatUseCase
import mapperimpls.MessageUIMapper
import mapperimpls.MessageUIMapperImpl
import org.koin.dsl.module
import presentation.chat.ChatViewModel
import usecaseimpls.ChatUseCaseImpl

val iosModule = module {
    single {
        DatabaseDriverFactory()
    }
    single {
        PlatformMessageDisplayer()
    }
    single<ChatUseCase> {
        ChatUseCaseImpl(
            chatRepository = get(),
            messageRepository = get()
        )
    }
    single<MessageUIMapper> {
        MessageUIMapperImpl()
    }
    single {
        ChatViewModel(
            chatUseCase = get(),
            messageUIMapper = get()
        )
    }
}