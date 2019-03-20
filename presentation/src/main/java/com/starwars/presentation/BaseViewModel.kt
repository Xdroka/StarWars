package com.starwars.presentation

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

open class BaseViewModel(provider: ThreadContextProvider): ViewModel(), LifecycleObserver {
    private val contextProvider: ThreadContextProvider = provider
    private val job = SupervisorJob()
    protected val coroutineScope = CoroutineScope(contextProvider.io + job)

    override fun onCleared() {
        super.onCleared()
        coroutineScope.coroutineContext.cancelChildren()
    }
}