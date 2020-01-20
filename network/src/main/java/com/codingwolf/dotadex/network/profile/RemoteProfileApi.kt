package com.codingwolf.dotadex.network.profile

import com.codingwolf.dotadex.data.model.steam.profile.Profile
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteProfileApi {

    @GET("players/")
    suspend fun getUserProfile(
        @Query("key") key: String,
        @Query("account_id") accountId: String
    ): Profile
}
