package com.codingwolf.dotadex.data.respository.game

import com.codingwolf.dotadex.data.datastore.remote.MatchRemoteDataStore
import com.codingwolf.dotadex.data.model.Match
import com.codingwolf.dotadex.data.respository.util.ResultHandler

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MatchRepository @Inject constructor(private val matchRemoteDataStore: MatchRemoteDataStore) {


    suspend fun getRecentMatches(accountId: Long, key: String) =
        ResultHandler.handleRequest { matchRemoteDataStore.getRecentMatches(accountId, key) }
}
