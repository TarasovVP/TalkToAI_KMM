package domain.repositories

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    suspend fun setOnBoardingSeen(isOnBoardingSeen: Boolean)

    suspend fun onBoardingSeen(): Flow<Boolean?>

}