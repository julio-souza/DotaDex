package com.codingwolf.dotadex.data.datastore.remote

import com.codingwolf.dotadex.data.model.profile.Player

interface ProfileRemoteDataStore {

    suspend fun getUserProfile(accountId: Long, key: String): Player
}
