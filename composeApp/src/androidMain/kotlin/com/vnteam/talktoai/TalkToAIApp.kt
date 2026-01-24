package com.vnteam.talktoai

import android.app.Application

class TalkToAIApp : Application() {

    var isNetworkAvailable: Boolean? = null

    override fun onCreate() {
        super.onCreate()
        registerForNetworkUpdates { isAvailable ->
            isNetworkAvailable = isAvailable
        }
        doInitKoin(this)
    }
}