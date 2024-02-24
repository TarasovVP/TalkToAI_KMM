package com.vnteam.talktoai

import PlatformMessageDisplayer
import com.vnteam.talktoai.chat.ChatUseCaseImpl
import com.vnteam.talktoai.chat.ChatViewModel
import com.vnteam.talktoai.mapperimpls.MessageUIMapper
import com.vnteam.talktoai.mapperimpls.MessageUIMapperImpl
import data.database.DatabaseDriverFactory
import domain.usecases.ChatUseCase
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

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