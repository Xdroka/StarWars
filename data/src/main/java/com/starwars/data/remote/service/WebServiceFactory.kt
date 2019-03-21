package com.starwars.data.remote.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.starwars.data.remote.Response
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> createWebService(): T = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()
    .create(T::class.java)

suspend fun <T : Any> apiCall(call: suspend () -> Deferred<T>): Response<T> = try {
    Response.Success(call().await())
} catch (e: Exception) {
    Response.Failure(e)
}