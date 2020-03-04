package com.codingwolf.dotadex.data.model

data class Profile(
    val accountId: Int,
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
)
