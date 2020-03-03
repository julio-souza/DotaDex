package com.codingwolf.dotadex.data.datasource.remote

import com.codingwolf.dotadex.data.model.Profile

interface ProfileRemoteDataSource {

    suspend fun getUserProfile(accountId: Long): Profile
}
