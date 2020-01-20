@file:Suppress("SpellCheckingInspection")

package com.codingwolf.dotadex.data.model.steam.profile

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayerProfile(
    @Json(name = "steamid") val steamId: Long,
    @Json(name = "communityvisibilitystate") val communityVisibilityState: Int,
    @Json(name = "profilestate") val profileState: Int,
    @Json(name = "personaname") val personaName: String,
    @Json(name = "profileurl") val profileUrl: String,
    @Json(name = "avatar") val avatar: String,
    @Json(name = "avatarmedium") val avatarMedium: String,
    @Json(name = "avatarfull") val avatarFull: String,
    @Json(name = "personastate") val personaState: Int,
    @Json(name = "realname") val realName: String,
    @Json(name = "primaryclanid") val primaryClanId: Long,
    @Json(name = "timecreated") val timeCreated: Long,
    @Json(name = "personastateflags") val personaStateFlags: Int,
//    @Json(name = "gameextrainfo") val gameExtraInfo: String,
//    @Json(name = "gameid") val gameId: Long,
    @Json(name = "loccountrycode") val locCountryCode: String,
    @Json(name = "locstatecode") val locStateCode: String
)
