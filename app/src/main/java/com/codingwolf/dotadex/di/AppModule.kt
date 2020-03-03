package com.codingwolf.dotadex.di

import com.codingwolf.dotadex.BuildConfig
import dagger.Module
import dagger.Provides
import java.util.Locale
import javax.inject.Named
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideLocale(): Locale = Locale.getDefault()

    @Singleton
    @Provides
    @Named("isDebug")
    fun provideBuildType(): Boolean = BuildConfig.DEBUG
}
