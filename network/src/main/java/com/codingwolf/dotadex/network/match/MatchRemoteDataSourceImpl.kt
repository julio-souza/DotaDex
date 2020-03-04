package com.codingwolf.dotadex.network.match

import com.codingwolf.dotadex.data.datasource.remote.MatchRemoteDataSource
import com.codingwolf.dotadex.data.model.Match
import javax.inject.Inject

class MatchRemoteDataSourceImpl @Inject constructor(private val matchApi: MatchApi) :
    MatchRemoteDataSource {

    override suspend fun getRecentMatches(accountId: Int): List<Match> =
        matchApi.getRecentMatches(accountId).map { it.toMatch() }
}
