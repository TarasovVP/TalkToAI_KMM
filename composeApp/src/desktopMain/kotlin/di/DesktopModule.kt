package di

import PlatformMessageDisplayer
import chat.ChatViewModel
import data.database.DatabaseDriverFactory
import domain.usecases.ChatUseCase
import mapperimpls.MessageUIMapper
import mapperimpls.MessageUIMapperImpl
import org.koin.dsl.module
import usecaseimpls.ChatUseCaseImpl

val desktopModule = module {
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