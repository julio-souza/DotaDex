package com.codingwolf.domain.usecase

import com.codingwolf.domain.model.Game
import com.codingwolf.domain.respository.GameRepository
import kotlinx.coroutines.flow.Flow

class GameUseCase(private val gameRepository: GameRepository) {
}
