package com.vnteam.talktoai

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log
import domain.CommonExtensions.isTrue
import ui_models.MessageUIModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Application.isNetworkAvailable(): Boolean {
    return (this as? TalkToAIApp)?.isNetworkAvailable.isTrue()
}

fun Context.registerForNetworkUpdates(isNetworkAvailable: (Boolean) -> Unit) {
    val networkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()
    val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            isNetworkAvailable.invoke(true)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            isNetworkAvailable.invoke(false)
        }
    }
    val connectivityManager =
        getSystemService(ConnectivityManager::class.java) as ConnectivityManager
    connectivityManager.requestNetwork(networkRequest, networkCallback)
}
