package com.codingwolf.dotadex.network.profile.response

import com.squareup.moshi.Json

class MmrEstimateResponse(
    @Json(name = "estimate") val estimate: Int,
    @Json(name = "stdDev") val stdDev: Int = 0,
    @Json(name = "n") val n: Int = 0
)
