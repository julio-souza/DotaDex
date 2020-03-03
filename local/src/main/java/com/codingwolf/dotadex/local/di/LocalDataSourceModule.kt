package com.codingwolf.dotadex.local.di

import com.codingwolf.dotadex.data.datasource.local.MatchLocalDataSource
import com.codingwolf.dotadex.data.datasource.local.ProfileLocalDataSource
import com.codingwolf.dotadex.local.datasource.MatchLocalDataSourceImpl
import com.codingwolf.dotadex.local.datasource.ProfileLocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindMatchLocalDataSource(matchLocalDataSource: MatchLocalDataSourceImpl): MatchLocalDataSource

    @Binds
    abstract fun bindProfileLocalDataSource(profileLocalDataSource: ProfileLocalDataSourceImpl): ProfileLocalDataSource
}
