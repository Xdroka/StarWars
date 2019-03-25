package com.starwars.ui.extensions

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun Any.toJson() = Gson().toJson(this)

inline fun <reified T> String.fromGson(): T? = try {
    Gson().let {
        val type = object : TypeToken<T>() {}.type
        it.fromJson(this, type)
    }
}catch (e: Exception) { null }
