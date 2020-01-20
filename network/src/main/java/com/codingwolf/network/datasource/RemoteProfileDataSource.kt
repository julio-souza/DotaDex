package com.codingwolf.datasource

import com.codingwolf.data.datastore.ProfileDataStore
import com.codingwolf.domain.model.profile.Profile
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteProfileDataSource : ProfileDataStore {

    @GET("ISteamUser/GetPlayerSummaries/v0002/")
    override fun getUserProfile(
        @Query("key") key: String,
        @Query("streamids") streamids: String
    ): Flow<Profile>
}
