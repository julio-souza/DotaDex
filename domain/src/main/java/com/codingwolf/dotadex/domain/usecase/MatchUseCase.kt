package com.codingwolf.dotadex.domain.usecase

import com.codingwolf.dotadex.data.respository.game.MatchRepository
import javax.inject.Inject

class MatchUseCase @Inject constructor(private val matchRepository: MatchRepository) {

    suspend fun getRecentMatches(accountId: Long, key: String) =
        matchRepository.getRecentMatches(accountId, key)
}
