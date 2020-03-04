package com.codingwolf.dotadex.data.datasource.remote

import com.codingwolf.dotadex.data.model.Match

interface MatchRemoteDataSource {

    suspend fun getRecentMatches(accountId: Int): List<Match>
}
