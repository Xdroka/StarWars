package com.starwars.presentation

import androidx.lifecycle.*
import com.starwars.data.remote.Response
import com.starwars.domain.interactor.FilmsInteractor
import com.starwars.domain.model.Film
import com.starwars.presentation.FlowState.Companion.failure
import com.starwars.presentation.FlowState.Companion.loading
import com.starwars.presentation.FlowState.Companion.success
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FilmsViewModel(
    private val contextProvider: ThreadContextProvider,
    private val interactor: FilmsInteractor
) : PaginationViewModel() {
    private val flowState = MutableLiveData<FlowState<MutableList<Film>>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun requestFilms() {
        if (loading) return
        loading = true
        flowState.value = loading()
        viewModelScope.launch(contextProvider.io) {
            val response = interactor.getFilms(currentPage)
            withContext(contextProvider.ui) {
                when (response) {
                    is Response.Failure -> {
                        error = true
                        flowState.value = failure(response.throwable)
                    }
                    is Response.Success -> {
                        error = false
                        if(response.data.isEmpty()) noMoreResults = true
                        flowState.value = success(response.data)
                    }
                }
                next()
            }
        }
    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun neutral(){
        viewModelScope.coroutineContext.cancelChildren()
        flowState.value = FlowState.neutral()
    }

    override fun refresh() {
        super.refresh()
        requestFilms()
    }

    fun getMainFlow(): LiveData<FlowState<MutableList<Film>>> = flowState
}