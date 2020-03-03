package com.codingwolf.dotadex.data.respository.util

sealed class ProfileExceptions(val code: Int, override val message: String) : Exception(message) {
    class NotFound(message: String) : ProfileExceptions(USER_NOT_FOUND, message)

    companion object {
        const val USER_NOT_FOUND = 1
    }
}


