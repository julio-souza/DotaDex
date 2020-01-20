@file:Suppress("SpellCheckingInspection")

package com.codingwolf.data.model.profile

import com.squareup.moshi.Json

data class Player(
    @Json(name = "steamid") val steamId: Int,
    @Json(name = "communityvisibilitystate") val communityVisibilityState: Int,
    @Json(name = "profilestate") val profileState: Int,
    @Json(name = "personaname") val personaName: String,
    @Json(name = "profileurl") val profileUrl: String,
    @Json(name = "avatar") val avatar: String,
    @Json(name = "avatarmedium") val avatarMedium: String,
    @Json(name = "avatarfull") val avatarFull: String,
    @Json(name = "personastate") val personaState: Int,
    @Json(name = "realname") val realName: String,
    @Json(name = "primaryclanid") val primaryClanId: Int,
    @Json(name = "timecreated") val timeCreated: Int,
    @Json(name = "personastateflags") val personaStateFlags: Int,
    @Json(name = "gameextrainfo") val gameExtraInfo: String,
    @Json(name = "gameid") val gameId: Int,
    @Json(name = "loccountrycode") val locCountryCode: String,
    @Json(name = "locstatecode") val locStateCode: String
)
