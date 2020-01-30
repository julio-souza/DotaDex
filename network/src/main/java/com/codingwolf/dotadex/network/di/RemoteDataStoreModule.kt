package com.codingwolf.dotadex.network.di

import com.codingwolf.dotadex.data.datastore.remote.MatchRemoteDataStore
import com.codingwolf.dotadex.data.datastore.remote.ProfileRemoteDataStore
import com.codingwolf.dotadex.network.match.MatchRemoteDataStoreImpl
import com.codingwolf.dotadex.network.profile.ProfileRemoteDataStoreImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteDataStoreModule {

    @Binds
    abstract fun bindProfileRemoteDataStore(profileDataStore: ProfileRemoteDataStoreImpl): ProfileRemoteDataStore

    @Binds
    abstract fun bindMatchRemoteDataStore(matchDataStore: MatchRemoteDataStoreImpl): MatchRemoteDataStore
}
