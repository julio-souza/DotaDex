package com.codingwolf.dotadex.data.respository

sealed class Result<out T> {
    data class Success<out T>(val value: T): Result<T>()
    data class Error(val code: Int? = null, val error: String? = null): Result<Nothing>()

}
