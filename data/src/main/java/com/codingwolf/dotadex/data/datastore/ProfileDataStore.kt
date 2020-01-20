package com.codingwolf.dotadex.data.datastore

import com.codingwolf.dotadex.data.model.steam.profile.Profile

interface ProfileDataStore {

    suspend fun getUserProfile(key: String, userId: String): Profile
}
