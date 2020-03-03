package com.codingwolf.dotadex.network.profile.response

import com.codingwolf.dotadex.data.model.Profile
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayerResponse(
    @Json(name = "tracked_until") val trackedUntil: String,
    @Json(name = "solo_competitive_rank") val soloCompetitiveRank: String,
    @Json(name = "competitive_rank") val competitiveRank: String?,
    @Json(name = "rank_tier") val rankTier: Int,
    @Json(name = "leaderboard_rank") val leaderboardRank: Int?, //todo Understand why the Api return it as null
    @Json(name = "mmr_estimate") val mmrEstimate: MmrEstimateResponse,
    @Json(name = "profile") val profile: ProfileResponse
) {
    fun asProfile(): Profile =
        Profile(
            profile.accountId,
            profile.steamId,
            profile.personaName,
            profile.name,
            profile.plus,
            profile.cheese,
            profile.avatar,
            profile.avatarMedium,
            profile.avatarFull,
            profile.profileUrl,
            profile.lastLogin,
            profile.locCountryCode
        )
}
