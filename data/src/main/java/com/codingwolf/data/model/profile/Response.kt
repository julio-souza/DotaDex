package com.codingwolf.data.model.profile

import com.squareup.moshi.Json

data class Response(
    @Json(name = "players") val players: List<Player>
)
