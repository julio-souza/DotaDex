package com.codingwolf.dotadex.network.di

import com.codingwolf.dotadex.data.datasource.remote.MatchRemoteDataSource
import com.codingwolf.dotadex.data.datasource.remote.ProfileRemoteDataSource
import com.codingwolf.dotadex.network.match.MatchRemoteDataSourceImpl
import com.codingwolf.dotadex.network.profile.ProfileRemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindProfileRemoteDataStore(profileDataStore: ProfileRemoteDataSourceImpl): ProfileRemoteDataSource

    @Binds
    abstract fun bindMatchRemoteDataStore(matchDataStore: MatchRemoteDataSourceImpl): MatchRemoteDataSource
}
