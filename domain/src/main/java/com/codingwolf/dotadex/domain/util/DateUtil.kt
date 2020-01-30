package com.codingwolf.dotadex.domain.util

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateUtil @Inject constructor(locale: Locale) {

    private val simpleDateFormat = SimpleDateFormat(DATA_PATTERN, locale)


    fun formatDate(date: Date) = simpleDateFormat.format(date)

    fun formatDate(epoch: Long) =
        simpleDateFormat.format(fromEpoch(epoch))


    fun fromEpoch(epoch: Long) = Date(epoch * MILI)


    companion object {
        private const val MILI = 1000
        private const val DATA_PATTERN = "dd-MM-yyyy HH:mm"
    }
}
