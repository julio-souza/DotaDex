package com.codingwolf.dotadex.data.datasource.local

import com.codingwolf.dotadex.data.model.Match

interface MatchLocalDataSource {

    suspend fun getRecentMatches(): List<Match>
    suspend fun saveMatches(matches: List<Match>)
}
