package com.starwars.presentation

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

open class PaginationViewModel : ViewModel(), LifecycleObserver {
    var currentPage = 1
    var currentStatus: Status? = null
    var noMoreResults = false

    open fun next() {
        when (currentStatus) {
            Status.ERROR -> currentStatus = null
            Status.LOADING -> {}
            else -> { currentPage++ }
        }
    }

    open fun refresh() {
        if (currentStatus == Status.LOADING) {
            viewModelScope.coroutineContext.cancelChildren()
            currentStatus = null
        }
        currentPage = 1
    }
}