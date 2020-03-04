package com.codingwolf.dotadex.network.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
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

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl(): String = "https://api.opendota.com/api/"

    @Singleton
    @Provides
    @Named("ApiKey")
    fun provideOpenDotaApiKey(): String = "f6d43a1b-7a06-4543-909e-efaf3b8b223d"

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
    fun provideOkHttpClient(interceptors: Set<@JvmSuppressWildcards Interceptor>): OkHttpClient =
        OkHttpClient.Builder().apply { interceptors.forEach { addInterceptor(it) } }.build()


    @Provides @IntoSet
    fun providesLoggingInterceptor(@Named("isDebug") debugMode: Boolean): Interceptor =
        HttpLoggingInterceptor().apply { level = if (debugMode) Level.BODY else Level.NONE }

    @Provides @IntoSet
    fun providesOpenDotaKeyInterceptor(@Named("ApiKey") key: String): Interceptor =
        Interceptor { chain ->
            val request = chain.request()
            val newUrl = request.url().newBuilder().apply { addQueryParameter("Key", key) }.build()
            val newRequest = request.newBuilder().apply { url(newUrl) }.build()

            chain.proceed(newRequest)
        }
}
