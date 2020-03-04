package com.codingwolf.dotadex.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codingwolf.dotadex.data.model.Match

@Entity(tableName = "Match")
data class MatchEntity(
    @PrimaryKey val id: Long,
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
) {


    fun asMatch() =
        Match(
            this.id,
            this.heroId,
            this.slot,
            this.victory,
            this.startTime,
            this.duration,
            this.gameMode,
            this.lobbyType,
            this.version,
            this.team,
            this.kills,
            this.deaths,
            this.assists,
            this.skillLvl,
            this.xpm,
            this.gpm,
            this.heroDamage,
            this.towerDamage,
            this.healing,
            this.lastHits,
            this.lane,
            this.role,
            this.roaming,
            this.abandon,
            this.partySize
        )

    companion object {
        infix fun from(match: Match) =
            MatchEntity(
                match.id,
                match.heroId,
                match.slot,
                match.victory,
                match.startTime,
                match.duration,
                match.gameMode,
                match.lobbyType,
                match.version,
                match.team,//todo create team constants
                match.kills,
                match.deaths,
                match.assists,
                match.skillLvl,
                match.gpm,
                match.xpm,
                match.heroDamage,
                match.towerDamage,
                match.healing,
                match.lastHits,
                match.lane,
                match.role,
                match.roaming,
                match.abandon,
                match.partySize
            )
    }
}
