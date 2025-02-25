package com.example.daggerandcoroutines

import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    /*@GET("v1_data_model/courses/home/get_all_events")
    suspend fun fetchData(): Response<List<Country>>*/

    @FormUrlEncoded
    @POST("EndUrl")
    suspend fun getEventUpcommingListData(
        @Field("user_id") userId: String,
        @Field("city_id") cityId: String,
        @Field("cat_id") catId: String,
        @Field("event_name") eventName: String,
        @Field("stage_type") stageType: String,
    ): Country
}