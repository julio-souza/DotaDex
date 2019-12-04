package com.codingwolf.domain.respository

import com.codingwolf.domain.model.profile.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getUserProfile(): Flow<Profile>
}
