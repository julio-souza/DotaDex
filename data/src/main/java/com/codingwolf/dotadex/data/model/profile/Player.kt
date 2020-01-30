package com.codingwolf.dotadex.data.model.profile

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Player(
    @Json(name = "tracked_until") val trackedUntil: String,
    @Json(name = "solo_competitive_rank") val soloCompetitiveRank: String,
    @Json(name = "competitive_rank") val competitiveRank: String?,
    @Json(name = "rank_tier") val rankTier: Int,
    @Json(name = "leaderboard_rank") val leaderboardRank: Int?,
    @Json(name = "mmr_estimate") val mmrEstimate: MmrEstimate,
    @Json(name = "profile") val profile: Profile
)
