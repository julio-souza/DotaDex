package com.codingwolf.domain.model.profile

import com.squareup.moshi.Json

data class Profile(
    @Json(name = "response") val response: Response
)
