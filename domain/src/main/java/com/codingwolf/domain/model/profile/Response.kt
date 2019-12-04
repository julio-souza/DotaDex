package com.codingwolf.domain.model.profile

import com.codingwolf.domain.model.profile.Player
import com.squareup.moshi.Json

data class Response(
    @Json(name = "players") val players: List<Player>
)
