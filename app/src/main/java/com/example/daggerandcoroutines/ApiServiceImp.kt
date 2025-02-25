package com.example.daggerandcoroutines

import javax.inject.Inject

class ApiServiceImp @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUpCommingEventListData(
        userId: String,
        cityId: String,
        CatId: String,
        eventName: String,
        stageType: String
    ): Country {
        return apiService.getEventUpcommingListData(userId, cityId, CatId, eventName, stageType)
    }
}