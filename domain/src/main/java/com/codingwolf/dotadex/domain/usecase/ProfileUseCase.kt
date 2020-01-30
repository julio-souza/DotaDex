package com.codingwolf.dotadex.domain.usecase


import com.codingwolf.dotadex.data.respository.profile.ProfileRepository
import javax.inject.Inject

class ProfileUseCase @Inject constructor(private val profileRepository: ProfileRepository) {

    suspend fun getUserProfile(accountId: Long, openDotaKey: String) =
        profileRepository.getUserProfile(accountId, openDotaKey)
}

