package com.codingwolf.dotadex.network.match

import com.codingwolf.dotadex.data.datastore.remote.MatchRemoteDataStore
import com.codingwolf.dotadex.data.model.Match
import com.codingwolf.dotadex.data.model.profile.Player
import javax.inject.Inject

class MatchRemoteDataStoreImpl @Inject constructor(private val matchApi: MatchApi) :
    MatchRemoteDataStore {

    override suspend fun getRecentMatches(accountId: Long, key: String): List<Match> =
        matchApi.getRecentMatches(accountId, key)
}
