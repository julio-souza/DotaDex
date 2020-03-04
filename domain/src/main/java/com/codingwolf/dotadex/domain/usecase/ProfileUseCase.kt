package com.codingwolf.dotadex.domain.usecase


import com.codingwolf.dotadex.data.respository.ProfileRepository
import com.codingwolf.dotadex.data.respository.util.Result
import javax.inject.Inject

class ProfileUseCase @Inject constructor(private val profileRepository: ProfileRepository) {

    suspend fun initializeUser(accountId: Long): Result<String> =
        profileRepository.getUserProfile(accountId).let {
            when (it) {
                is Result.Success -> Result.Success("Success")
                is Result.Error -> Result.Error(error = "Can't load user, reason: \n${it.error}")
            }
        }

    suspend fun getUserProfile() =
        profileRepository.getUserProfile()
}
