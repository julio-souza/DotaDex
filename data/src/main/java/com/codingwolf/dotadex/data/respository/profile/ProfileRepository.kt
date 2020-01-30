package com.codingwolf.dotadex.data.respository.profile

import com.codingwolf.dotadex.data.datastore.remote.ProfileRemoteDataStore
import com.codingwolf.dotadex.data.model.profile.Player
import com.codingwolf.dotadex.data.respository.util.Result
import com.codingwolf.dotadex.data.respository.util.ResultHandler
import javax.inject.Inject

/**
 * This will implement rules to control if the data will be downloaded or not and to
 * chose between local and remote data.
 */
class ProfileRepository @Inject constructor(private val profileRemoteDataSource: ProfileRemoteDataStore) {
    suspend fun getUserProfile(accountId: Long, key: String): Result<Player> =
        ResultHandler.handleRequest { profileRemoteDataSource.getUserProfile(accountId, key) }
}
