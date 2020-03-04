package com.codingwolf.dotadex.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codingwolf.dotadex.data.model.Profile

@Entity(tableName = "Profile")
data class ProfileEntity(
    @PrimaryKey val accountId: Int,
    val steamId: String,
    val personaName: String,
    val name: String?,
    val plus: Boolean,
    val cheese: Int,
    val avatar: String,
    val avatarMedium: String,
    val avatarFull: String,
    val profileUrl: String,
    val lastLogin: String,
    val countryCode: String
) {

    fun toProfile() =
        Profile(
            accountId,
            steamId,
            personaName,
            name,
            plus,
            cheese,
            avatar,
            avatarMedium,
            avatarFull,
            profileUrl,
            lastLogin,
            countryCode
        )

    companion object {
        infix fun from(profile: Profile) =
            ProfileEntity(
                profile.accountId,
                profile.steamId,
                profile.personaName,
                profile.name,
                profile.plus,
                profile.cheese,
                profile.avatar,
                profile.avatarMedium,
                profile.avatarFull,
                profile.profileUrl,
                profile.lastLogin,
                profile.countryCode
            )
    }
}
