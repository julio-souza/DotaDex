package com.codingwolf.dotadex.network.profile

import com.codingwolf.dotadex.network.profile.response.PlayerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProfileApi {

    @GET("players/{account_id}")
    suspend fun getUserProfile(
        @Path("account_id") accountId: Long
    ): PlayerResponse
}
