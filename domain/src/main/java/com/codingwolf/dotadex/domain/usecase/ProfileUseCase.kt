package com.codingwolf.dotadex.domain.usecase


import com.codingwolf.dotadex.data.respository.profile.ProfileRepository
import javax.inject.Inject

class ProfileUseCase @Inject constructor(private val profileRepository: ProfileRepository) {

    suspend fun getUserProfile() =
        profileRepository.getUserProfile("33A4D52ACDAD58DF2E09F9D969EE6644", "76561198051747725")
}

