package com.codingwolf.dotadex.local.db.dao

import androidx.room.*
import com.codingwolf.dotadex.local.db.entity.MatchEntity

@Dao
interface MatchDao {

    @Query("SELECT * FROM `Match`")
    suspend fun getAll(): List<MatchEntity>

    @Insert
    suspend fun insertAll(matches: List<MatchEntity>)

    @Delete
    suspend fun delete(match: MatchEntity)
}
