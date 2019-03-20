@file:Suppress("CanBeParameter")

package com.e.presentation

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent

class SpeciesViewModel(
    private val contextProvider: ThreadContextProvider
) : BaseViewModel(contextProvider) {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun requestAllSpecies(){

    }
}