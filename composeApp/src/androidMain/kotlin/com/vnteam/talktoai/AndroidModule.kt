package com.vnteam.talktoai

import PlatformMessageDisplayer
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import presentation.chat.ChatViewModel
import presentation.onboarding.OnBoardingViewModel
import data.database.DatabaseDriverFactory
import domain.repositories.DataStoreRepository
import domain.usecases.ChatUseCase
import domain.usecases.OnBoardingUseCase
import mapperimpls.MessageUIMapper
import mapperimpls.MessageUIMapperImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import usecaseimpls.ChatUseCaseImpl
import usecaseimpls.OnBoardingUseCaseImpl

val androidComposeModule = module {
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
    single<OnBoardingUseCase> {
        OnBoardingUseCaseImpl(
            dataStoreRepository = get()
        )
    }
    single<DataStore<Preferences>> {
        PreferenceDataStoreFactory.create(produceFile = {
            androidContext().preferencesDataStoreFile(androidContext().packageName)
        })
    }
    single<DataStoreRepository> {
        DataStoreRepositoryImpl(get())
    }
    viewModel {
        OnBoardingViewModel(
            onBoardingUseCase = get()
        )
    }
    viewModel {
        ChatViewModel(
            chatUseCase = get(),
            messageUIMapper = get()
        )
    }
}