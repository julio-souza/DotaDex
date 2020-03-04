package com.codingwolf.dotadex.network.profile.response

import com.squareup.moshi.Json

class ProfileResponse(
    @Json(name = "account_id") val accountId: Int,
    @Json(name = "personaname") val personaName: String,
    @Json(name = "name") val name: String?,
    @Json(name = "plus") val plus: Boolean,
    @Json(name = "cheese") val cheese: Int,
    @Json(name = "steamid") val steamId: String,
    @Json(name = "avatar") val avatar: String,
    @Json(name = "avatarmedium") val avatarMedium: String,
    @Json(name = "avatarfull") val avatarFull: String,
    @Json(name = "profileurl") val profileUrl: String,
    @Json(name = "last_login") val lastLogin: String,
    @Json(name = "loccountrycode") val locCountryCode: String,
    @Json(name = "is_contributor") val isContributor: Boolean
)
