package com.codingwolf.dotadex.data.datastore.remote

import com.codingwolf.dotadex.data.model.Match

interface MatchRemoteDataStore {

    suspend fun getRecentMatches(accountId: Long, key: String): List<Match>
}
