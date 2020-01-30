package com.codingwolf.dotadex.di

import dagger.Module
import dagger.Provides
import java.util.Locale

@Module
object AppModule {

    @Provides
    fun provideLocale(): Locale = Locale.getDefault()
}
