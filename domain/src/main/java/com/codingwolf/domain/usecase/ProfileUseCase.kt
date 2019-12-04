package com.codingwolf.domain.usecase

import com.codingwolf.domain.respository.ProfileRepository

class ProfileUseCase(
    private val profileRepository: ProfileRepository
) {

    fun getUserProfile() =
        profileRepository.getUserProfile()
}

