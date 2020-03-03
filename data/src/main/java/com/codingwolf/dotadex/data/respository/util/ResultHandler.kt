package com.codingwolf.dotadex.data.respository.util

import retrofit2.HttpException

object ResultHandler {
    inline fun <T : Any> handle(call: () -> T): Result<T> =
        try {
            Result.Success(call.invoke())
        } catch (ex: Exception) {
            when (ex) {
                is HttpException -> ex.response()?.let {
                    val code = it.code()
                    val message = it.errorBody().toString()

                    Result.Error(code, message)
                } ?: Result.Error(999, ex.localizedMessage)
                is ProfileExceptions.NotFound -> Result.Error(ex.code, ex.message)
                else -> Result.Error(999, ex.localizedMessage)
            }
        }
}
