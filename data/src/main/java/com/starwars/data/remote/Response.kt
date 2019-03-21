package com.starwars.data.remote

sealed class Response<out T> {
    class Success<out T>(val data: T) : Response<T>()
    class Failure(val throwable: Throwable) : Response<Nothing>()
}