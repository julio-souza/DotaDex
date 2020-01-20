package com.codingwolf.data.respository

import com.codingwolf.data.datastore.ProfileDataStore
import com.codingwolf.domain.model.profile.Profile
import com.codingwolf.data.respository.ProfileRepository
import kotlinx.coroutines.flow.Flow

/**
 * This will implement rules to control if the data will be downloaded or not and to
 * chose between local and remote data.
 */
class ProfileRepositoryImpl(private val profileDataSource: ProfileDataStore) : ProfileRepository {

    override fun getUserProfile(key: String, userId: String): Flow<Profile> {
        return profileDataSource.getUserProfile(key, userId)
    }
}
