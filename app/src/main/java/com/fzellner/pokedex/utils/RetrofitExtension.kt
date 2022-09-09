package com.fzellner.pokedex.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response


fun <T> Response<T>.call(default: T? = null): Flow<T> = flow {
    val response = this@call
    when (response.isSuccessful) {
        true -> emit(response.body() ?: (default ?: throw NullPointerException()))
        else -> throw when (response.code()) {
            in 400..499 -> Failure.ClientError
            in 500..599 -> Failure.ServerError
            else -> Failure.GenericError
        }
    }
}