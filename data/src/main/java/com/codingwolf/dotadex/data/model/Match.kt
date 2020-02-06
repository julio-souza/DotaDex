package com.codingwolf.dotadex.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Match(
    @Json(name = "match_id") val matchId: Long,
    @Json(name = "player_slot") val playerSlot: Int,
    @Json(name = "radiant_win") val radiantWin: Boolean,
    @Json(name = "duration") val duration: Long,
    @Json(name = "game_mode") val gameMode: Int,
    @Json(name = "lobby_type") val lobbyType: Int,
    @Json(name = "hero_id") val heroId: Int,
    @Json(name = "start_time") val startTime: Long,
    @Json(name = "version") val version: Int?,
    @Json(name = "kills") val kills: Int,
    @Json(name = "deaths") val deaths: Int,
    @Json(name = "assists") val assists: Int,
    @Json(name = "skill") val skill: Int?,//Match not validated
    @Json(name = "xp_per_min") val xpPerMin: Int,
    @Json(name = "gold_per_min") val goldPerMin: Int,
    @Json(name = "hero_damage") val heroDamage: Int,
    @Json(name = "tower_damage") val towerDamage: Int,
    @Json(name = "hero_healing") val healing: Int,
    @Json(name = "last_hits") val lastHits: Int,
    @Json(name = "lane") val lane: Int?,//Match not validated
    @Json(name = "lane_role") val laneRole: Int?,//Match not validated
    @Json(name = "is_roaming") val isRoaming: Boolean,
    @Json(name = "cluster") val cluster: Int,
    @Json(name = "leaver_status") val leaverStatus: Int,
    @Json(name = "party_size") val partySize: Int
) {
    val isRadiant = playerSlot > 100

    val isVictory = radiantWin xor isRadiant
}












