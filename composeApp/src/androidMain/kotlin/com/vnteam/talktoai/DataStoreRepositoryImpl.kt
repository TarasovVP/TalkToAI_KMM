package com.vnteam.talktoai

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import domain.Constants.ON_BOARDING_SEEN
import domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take

class DataStoreRepositoryImpl(private val dataStore: DataStore<Preferences>) : DataStoreRepository {

    override suspend fun setOnBoardingSeen(isOnBoardingSeen: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(ON_BOARDING_SEEN)] = isOnBoardingSeen
        }
    }

    override suspend fun onBoardingSeen(): Flow<Boolean?> {
        return dataStore.data
            .map { preferences ->
                preferences[booleanPreferencesKey(ON_BOARDING_SEEN)]
            }.take(1)
    }
}