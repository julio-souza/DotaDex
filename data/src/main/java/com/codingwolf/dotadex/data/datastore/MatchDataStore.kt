package com.codingwolf.dotadex.data.datastore

import com.codingwolf.dotadex.data.model.Match

interface MatchDataStore {

    suspend fun getRecentMatches(accountId: Long): List<Match>
}
