package com.codingwolf.dotadex.local.datasource

import com.codingwolf.dotadex.data.datasource.local.ProfileLocalDataSource
import com.codingwolf.dotadex.data.model.Profile
import com.codingwolf.dotadex.local.db.dao.ProfileDao
import com.codingwolf.dotadex.local.db.entity.ProfileEntity
import javax.inject.Inject

class ProfileLocalDataSourceImpl @Inject constructor(
    private val profileDao: ProfileDao
) : ProfileLocalDataSource {

    override suspend fun saveUserProfile(profile: Profile) {
        profileDao.insert(ProfileEntity from profile)
    }

    override suspend fun getUserProfile(): Profile? = profileDao.get()?.toProfile()

}
