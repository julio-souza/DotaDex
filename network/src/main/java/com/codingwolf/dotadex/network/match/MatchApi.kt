package com.codingwolf.dotadex.network.match

import com.codingwolf.dotadex.data.model.Match
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MatchApi {

    @GET("players/{account_id}/recentMatches")
    suspend fun getRecentMatches(@Path("account_id") accountId: Long, @Query("key") key: String): List<Match>
}
