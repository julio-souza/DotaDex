package com.codingwolf.dotadex.network.profile

import com.codingwolf.dotadex.data.datasource.remote.ProfileRemoteDataSource
import com.codingwolf.dotadex.data.model.Profile
import com.codingwolf.dotadex.network.profile.response.PlayerResponse
import javax.inject.Inject

class ProfileRemoteDataSourceImpl @Inject constructor(private val profileApi: ProfileApi) :
    ProfileRemoteDataSource {

    override suspend fun getUserProfile(accountId: Long): Profile {
        return profileApi.getUserProfile(accountId).asProfile()
    }
}
