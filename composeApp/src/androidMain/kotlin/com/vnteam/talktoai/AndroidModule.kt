package com.vnteam.talktoai

import PlatformMessageDisplayer
import data.database.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule = module {
    single {
        DatabaseDriverFactory(androidContext())
    }
    single {
        PlatformMessageDisplayer(androidContext())
    }
}