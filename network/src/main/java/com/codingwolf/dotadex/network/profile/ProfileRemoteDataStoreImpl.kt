package com.codingwolf.dotadex.network.profile

import com.codingwolf.dotadex.data.datastore.remote.ProfileRemoteDataStore
import com.codingwolf.dotadex.data.model.profile.Player
import javax.inject.Inject

class ProfileRemoteDataStoreImpl @Inject constructor(private val profileApi: ProfileApi) :
    ProfileRemoteDataStore {

    override suspend fun getUserProfile(accountId: Long, key: String): Player {
        return profileApi.getUserProfile(accountId, key)
    }
}
