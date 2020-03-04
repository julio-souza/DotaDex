package com.codingwolf.dotadex.data.datasource.local

import com.codingwolf.dotadex.data.model.Profile

interface ProfileLocalDataSource {

    suspend fun saveUserProfile(profile: Profile)

    suspend fun getUserProfile(): Profile?
}
