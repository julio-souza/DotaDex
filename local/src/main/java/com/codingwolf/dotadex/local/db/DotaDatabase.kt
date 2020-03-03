package com.codingwolf.dotadex.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codingwolf.dotadex.local.db.dao.MatchDao
import com.codingwolf.dotadex.local.db.dao.ProfileDao
import com.codingwolf.dotadex.local.db.entity.MatchEntity
import com.codingwolf.dotadex.local.db.entity.ProfileEntity

@Database(
    entities = [
        MatchEntity::class,
        ProfileEntity::class
    ],
    version = DotaDatabase.VERSION
)
abstract class DotaDatabase : RoomDatabase() {


    abstract fun matchDao(): MatchDao

    abstract fun profileDao(): ProfileDao

    companion object {
        fun newInstance(context: Context): DotaDatabase =
            Room.databaseBuilder(
                context,
                DotaDatabase::class.java,
                DATABASE_NAME
            ).build()

        private const val DATABASE_NAME = "DotaDex_Database"
        const val VERSION = 1
    }
}
