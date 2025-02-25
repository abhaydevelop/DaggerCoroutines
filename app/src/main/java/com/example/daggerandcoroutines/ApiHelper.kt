package com.example.daggerandcoroutines

interface ApiHelper {

    suspend fun getUpCommingEventListData(
        userId: String,
        cityId: String,
        CatId: String,
        eventName: String,
        stageType: String
    ): Country

}