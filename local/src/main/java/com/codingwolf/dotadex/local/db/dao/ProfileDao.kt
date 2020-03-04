package com.codingwolf.dotadex.local.db.dao

import androidx.room.*
import com.codingwolf.dotadex.local.db.entity.ProfileEntity

@Dao
interface ProfileDao {

    @Query("SELECT * FROM `Profile`")
    fun get(): ProfileEntity?

    @Insert
    fun insert(profileEntity: ProfileEntity)

    @Update
    fun update(profileEntity: ProfileEntity)

    @Delete
    fun delete(profileEntity: ProfileEntity)
}
