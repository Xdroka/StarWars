package com.starwars.presentation

import com.starwars.presentation.Status.*

data class FlowState<T>(
    val data: T? = null,
    val throwable: Throwable? = null,
    val status: Status = NEUTRAL
){
    companion object {
        inline fun <reified T> success(data: T) = FlowState(data = data, status = SUCCESS)
        inline fun <reified T> failure(e: Throwable) = FlowState<T>(throwable = e, status = ERROR)
        inline fun <reified T> loading() = FlowState<T>(status = LOADING)
        inline fun <reified T> neutral() = FlowState<T>()
    }
}