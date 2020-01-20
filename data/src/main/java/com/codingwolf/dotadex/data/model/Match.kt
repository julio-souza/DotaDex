package com.codingwolf.dotadex.data.model

import com.squareup.moshi.Json

data class Match (
    @Json(name = "match_id") val matchId : Int,
    @Json(name = "player_slot") val playerSlot : Int,
    @Json(name = "radiant_win") val radiantWin : Boolean,
    @Json(name = "duration") val duration : Int,
    @Json(name = "game_mode") val gameMode : Int,
    @Json(name = "lobby_type") val lobbyType : Int,
    @Json(name = "hero_id") val heroId : Int,
    @Json(name = "start_time") val startTime : Int,
    @Json(name = "version") val version : Int,
    @Json(name = "kills") val kills : Int,
    @Json(name = "deaths") val deaths : Int,
    @Json(name = "assists") val assists : Int,
    @Json(name = "skill") val skill : Int,
    @Json(name = "leaver_status") val leaverStatus : Int,
    @Json(name = "party_size") val partySize : Int
) {

    val isVictory = true

}
