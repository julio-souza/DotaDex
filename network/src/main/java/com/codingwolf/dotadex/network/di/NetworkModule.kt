package com.codingwolf.dotadex.network.di

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
object NetworkModule {

    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://api.opendota.com/api/"

    @Singleton
    @Provides
    fun provideReotrofit(
        @Named("BaseUrl")
        baseUrl: String,
        client: OkHttpClient,
        converterFactory: MoshiConverterFactory
    ) = Retrofit
        .Builder()
        .apply {
            baseUrl(baseUrl)
            addConverterFactory(converterFactory)
            client(client)
        }.build()

    @Singleton
    @Provides
    fun provideConverterFactory() =
        MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor) =
        OkHttpClient.Builder().apply { addInterceptor(interceptor) }.build()

    @Singleton
    @Provides
    fun provideInterceptor(debugMode: Boolean) =
        HttpLoggingInterceptor().apply { level = if (debugMode) Level.BODY else Level.NONE }
}
