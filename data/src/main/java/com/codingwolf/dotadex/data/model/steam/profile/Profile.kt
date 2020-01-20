package com.codingwolf.dotadex.data.model.steam.profile

import com.squareup.moshi.Json


data class Profile(
    @Json(name = "response") val response: Response
)
