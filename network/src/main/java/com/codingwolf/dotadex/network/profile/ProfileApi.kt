package com.codingwolf.dotadex.network.profile

import com.codingwolf.dotadex.data.model.profile.Player
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileApi {

    @GET("players/{account_id}")
    suspend fun getUserProfile(
        @Path("account_id") accountId: Long,
        @Query("key") key: String
    ): Player
}
