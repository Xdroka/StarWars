package com.starwars.presentation

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren

open class PaginationViewModel : ViewModel(), LifecycleObserver {
    protected var currentPage = 1
    var loading = false
        protected set
    protected var error = false
    var noMoreResults = false
        protected set
    open fun next() {
        loading = false
        if(!error) currentPage++
    }

    open fun refresh() {
        if (loading) viewModelScope.coroutineContext.cancelChildren()
        currentPage = 1
        noMoreResults = false
        loading = false
        error = false
    }
}