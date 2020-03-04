package com.codingwolf.dotadex.local.di

import android.content.Context
import com.codingwolf.dotadex.local.db.DotaDatabase
import com.codingwolf.dotadex.local.db.dao.MatchDao
import com.codingwolf.dotadex.local.db.dao.ProfileDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object LocalModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): DotaDatabase = DotaDatabase.newInstance(context)

    @Provides
    fun provideProfileDao(db: DotaDatabase): ProfileDao = db.profileDao()

    @Provides
    fun provideMatchDao(db: DotaDatabase): MatchDao = db.matchDao()
}
