package com.codingwolf.dotadex.data.model.steam.profile

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "players") val playerProfiles: List<PlayerProfile>
)
