package com.vnteam.talktoai

import PlatformMessageDisplayer
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.vnteam.talktoai.chat.ChatViewModel
import com.vnteam.talktoai.onboarding.OnBoardingViewModel
import mapperimpls.MessageUIMapper
import data.database.DatabaseDriverFactory
import domain.repositories.DataStoreRepository
import domain.usecases.ChatUseCase
import domain.usecases.OnBoardingUseCase
import mapperimpls.MessageUIMapperImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import usecaseimpls.ChatUseCaseImpl
import usecaseimpls.OnBoardingUseCaseImpl

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
            application = androidApplication(),
            onBoardingUseCase = get()
        )
    }
    viewModel {
        ChatViewModel(
            application = androidApplication(),
            chatUseCase = get(),
            messageUIMapper = get()
        )
    }
}