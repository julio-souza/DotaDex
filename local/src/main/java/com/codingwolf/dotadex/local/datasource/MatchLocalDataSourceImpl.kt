package com.codingwolf.dotadex.local.datasource

import com.codingwolf.dotadex.data.datasource.local.MatchLocalDataSource
import com.codingwolf.dotadex.data.model.Match
import com.codingwolf.dotadex.local.db.dao.MatchDao
import com.codingwolf.dotadex.local.db.entity.MatchEntity
import javax.inject.Inject

class MatchLocalDataSourceImpl @Inject constructor(
    private val matchDao: MatchDao
) : MatchLocalDataSource {

    override suspend fun getRecentMatches(): List<Match> =
        matchDao.getAll().map { matchEntity -> matchEntity.asMatch() }

    override suspend fun saveMatches(matches: List<Match>) =
        matchDao.insertAll(matches.map { match -> MatchEntity from match })
}
