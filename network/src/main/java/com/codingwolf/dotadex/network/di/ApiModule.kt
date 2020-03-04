package com.codingwolf.dotadex.network.di

import com.codingwolf.dotadex.network.match.MatchApi
import com.codingwolf.dotadex.network.profile.ProfileApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object ApiModule {

    @Provides
    fun bindProfileApi(retrofit: Retrofit) = retrofit.create(ProfileApi::class.java)

    @Provides
    fun bindMatchApi(retrofit: Retrofit) = retrofit.create(MatchApi::class.java)
}
