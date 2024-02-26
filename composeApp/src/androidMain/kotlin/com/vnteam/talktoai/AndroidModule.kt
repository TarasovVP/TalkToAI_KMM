package com.vnteam.talktoai

import PlatformMessageDisplayer
import com.vnteam.talktoai.chat.ChatViewModel
import mapperimpls.MessageUIMapper
import data.database.DatabaseDriverFactory
import domain.usecases.ChatUseCase
import mapperimpls.MessageUIMapperImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import usecaseimpls.ChatUseCaseImpl

val androidModule = module {
    single {
        DatabaseDriverFactory(androidContext())
    }
    single {
        PlatformMessageDisplayer(androidContext())
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
    viewModel {
        ChatViewModel(
            application = androidApplication(),
            chatUseCase = get(),
            messageUIMapper = get()
        )
    }
}