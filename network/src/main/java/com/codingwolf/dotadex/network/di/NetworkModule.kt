package com.codingwolf.dotadex.network.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ApiModule::class])
object NetworkModule {

    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl(): String = "https://api.opendota.com/api/"

    //Temporary
    @Provides
    @Named("BuildType")
    fun provideBuildType(): Boolean = true

    @Singleton
    @Provides
    fun provideReotrofit(
        @Named("BaseUrl")
        baseUrl: String,
        client: OkHttpClient,
        converterFactory: MoshiConverterFactory
    ): Retrofit = Retrofit
        .Builder()
        .apply {
            baseUrl(baseUrl)
            addConverterFactory(converterFactory)
            client(client)
        }.build()

    @Singleton
    @Provides
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Singleton
    @Provides
    fun provideConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)


    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder().apply { addInterceptor(interceptor) }.build()

    @Singleton
    @Provides
    fun provideInterceptor(@Named("BuildType") debugMode: Boolean): Interceptor =
        HttpLoggingInterceptor().apply { level = if (debugMode) Level.BODY else Level.NONE }
}
