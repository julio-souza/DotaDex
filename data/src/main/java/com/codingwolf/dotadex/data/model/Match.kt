package com.codingwolf.dotadex.data.model

data class Match(
    val id: Long,
    val heroId: Int,
    val slot: Int,
    val victory: Boolean,
    val startTime: Long,
    val duration: Long,
    val gameMode: Int,
    val lobbyType: Int,
    val version: Int?,
    val team: Int,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val skillLvl: Int?,
    val gpm: Int,
    val xpm: Int,
    val heroDamage: Int,
    val towerDamage: Int,
    val healing: Int,
    val lastHits: Int,
    val lane: Int?,
    val role: Int?,
    val roaming: Boolean,
    val abandon: Boolean,
    val partySize: Int
)
