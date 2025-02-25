package com.example.daggerandcoroutines

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getEventUpCommingListData(
        userId: String,
        cityId: String,
        CatId: String,
        eventName: String, stageType: String
    ): Flow<NetworkStatus<Country>> {

        return flow {
            val response = apiHelper.getUpCommingEventListData(userId, cityId, CatId, eventName, stageType)
            emit(NetworkStatus.success(response))
        }.flowOn(Dispatchers.IO)
    }

}
