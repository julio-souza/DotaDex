package com.codingwolf.dotadex.util

const val STEAM_BASELINE_ID = 76561197960265728

object SteamUtil {

    fun getSteam32Id(steam64Id: String) =
        getSteam32Id(steam64Id.toLong()).toString()

    fun getSteam32Id(steam64Id: Long) =
        steam64Id - STEAM_BASELINE_ID
}
