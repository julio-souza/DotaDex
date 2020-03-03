package com.codingwolf.dotadex.network.match

import com.codingwolf.dotadex.data.model.Match
import retrofit2.http.GET
import retrofit2.http.Path


interface MatchApi {

    @GET("players/{account_id}/recentMatches")
    suspend fun getRecentMatches(@Path("account_id") accountId: Int): List<MatchResponse>
}
