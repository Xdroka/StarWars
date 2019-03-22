package com.starwars.base

interface ViewActions {
    fun addListeners()
    fun addEvents()
    fun handleErrors(throwable: Throwable?)
}