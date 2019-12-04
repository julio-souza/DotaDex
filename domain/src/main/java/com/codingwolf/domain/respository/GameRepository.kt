package com.codingwolf.domain.respository

import com.codingwolf.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {


    fun getRecentGames(): Flow<List<Game>>
}
