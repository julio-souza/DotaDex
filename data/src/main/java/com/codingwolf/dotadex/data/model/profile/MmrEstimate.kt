package com.codingwolf.dotadex.data.model.profile

import com.squareup.moshi.Json

class MmrEstimate(
    @Json(name = "estimate") val estimate: Int,
    @Json(name = "stdDev") val stdDev: Int = 0,
    @Json(name = "n") val n: Int = 0
)
