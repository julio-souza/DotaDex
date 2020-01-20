package com.codingwolf.data.respository

import com.codingwolf.domain.model.profile.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getUserProfile(key: String, userId: String): Flow<Profile>
}
