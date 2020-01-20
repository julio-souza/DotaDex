package com.codingwolf.dotadex.network.di

import com.codingwolf.dotadex.network.profile.RemoteProfileApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object ApiModule {

    @Provides
    fun bindProfileApi(retrofit: Retrofit) = retrofit.create(RemoteProfileApi::class.java)
}
