package com.codingwolf.dotadex.data.respository

import com.codingwolf.dotadex.data.datasource.local.ProfileLocalDataSource
import com.codingwolf.dotadex.data.datasource.remote.ProfileRemoteDataSource
import com.codingwolf.dotadex.data.model.Profile
import com.codingwolf.dotadex.data.respository.util.Result
import com.codingwolf.dotadex.data.respository.util.ResultHandler
import com.codingwolf.dotadex.data.respository.util.ProfileExceptions
import javax.inject.Inject

/**
 * This will implement rules to control if the data will be downloaded or not and to
 * chose between local and remote data.
 */
class ProfileRepository @Inject constructor(
    private val profileLocalDataSource: ProfileLocalDataSource,
    private val profileRemoteDataSource: ProfileRemoteDataSource
) {

    suspend fun getUserProfile(accountId: Long): Result<Profile> =
        ResultHandler.handle {
            profileLocalDataSource.getUserProfile() ?:
            profileRemoteDataSource.getUserProfile(accountId).also {
                profileLocalDataSource.saveUserProfile(it)
            }
        }

    suspend fun getUserProfile(): Result<Profile> =
        ResultHandler.handle {
            profileLocalDataSource.getUserProfile() ?: throw ProfileExceptions.NotFound("User not initialized.")
        }
}
