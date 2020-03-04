package com.codingwolf.dotadex.data.respository

import com.codingwolf.dotadex.data.datasource.local.MatchLocalDataSource
import com.codingwolf.dotadex.data.datasource.remote.MatchRemoteDataSource
import com.codingwolf.dotadex.data.model.Match
import com.codingwolf.dotadex.data.respository.util.Result
import com.codingwolf.dotadex.data.respository.util.ResultHandler
import javax.inject.Inject

class MatchRepository @Inject constructor(
    private val matchRemoteDataSource: MatchRemoteDataSource,
    private val matchLocalDataSource: MatchLocalDataSource
) {

    suspend fun getRecentMatches(accountId: Int): Result<List<Match>> =
        ResultHandler.handle {
            matchLocalDataSource.getRecentMatches().let {localMatches ->
                if (localMatches.isEmpty()) {
                    matchRemoteDataSource.getRecentMatches(accountId).also {remoteMatches ->
                        matchLocalDataSource.saveMatches(remoteMatches)
                    }
                } else {
                    localMatches
                }
            }
        }
}
