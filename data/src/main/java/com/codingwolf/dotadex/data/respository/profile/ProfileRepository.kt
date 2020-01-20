package com.codingwolf.dotadex.data.respository.profile

import com.codingwolf.dotadex.data.datastore.ProfileDataStore
import com.codingwolf.dotadex.data.model.steam.profile.Profile
import com.codingwolf.dotadex.data.respository.Result
import retrofit2.HttpException

/**
 * This will implement rules to control if the data will be downloaded or not and to
 * chose between local and remote data.
 */
class ProfileRepository constructor(private val profileDataSource: ProfileDataStore) {

    suspend fun getUserProfile(key: String, userId: String): Result<Profile>{
        return try {
            val userProfile = profileDataSource.getUserProfile(key, userId)
            Result.Success(userProfile)
        } catch (httpEx :HttpException) {
            httpEx.response()?.let {
                val code = it.code()
                val message = it.errorBody().toString()

                Result.Error(code, message)
            } ?: Result.Error(999, httpEx.localizedMessage)
        }
    }
}
