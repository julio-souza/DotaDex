package com.codingwolf.dotadex.data.respository.util

import retrofit2.HttpException

object ResultHandler {
    inline fun <T : Any> handleRequest(function: () -> T): Result<T> =
        try {
            val userProfile = function.invoke()
            Result.Success(userProfile)
        } catch (httpEx: HttpException) {
            httpEx.response()?.let {
                val code = it.code()
                val message = it.errorBody().toString()

                Result.Error(code, message)
            } ?: Result.Error(999, httpEx.localizedMessage)
        }

}
