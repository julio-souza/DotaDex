package com.codingwolf.dotadex.domain.usecase

import com.codingwolf.dotadex.data.respository.MatchRepository
import javax.inject.Inject

class MatchUseCase @Inject constructor(private val matchRepository: MatchRepository) {

    suspend fun getRecentMatches(accountId: Int) =
        matchRepository.getRecentMatches(accountId)
}
