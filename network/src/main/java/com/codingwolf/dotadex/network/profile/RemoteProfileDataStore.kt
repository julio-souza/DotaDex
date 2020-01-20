package com.codingwolf.dotadex.network.profile

import com.codingwolf.dotadex.data.datastore.ProfileDataStore
import com.codingwolf.dotadex.data.model.steam.profile.Profile
import javax.inject.Inject

class RemoteProfileDataStore @Inject constructor(private val profileApi: RemoteProfileApi) : ProfileDataStore {

    override suspend fun getUserProfile(key: String, userId: String): Profile {
        return profileApi.getUserProfile(key, userId)
    }
}
