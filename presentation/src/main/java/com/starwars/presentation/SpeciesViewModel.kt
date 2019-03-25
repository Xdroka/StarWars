package com.starwars.presentation

import androidx.lifecycle.*
import com.starwars.data.remote.Response
import com.starwars.domain.interactor.SpecieInteractor
import com.starwars.domain.model.Specie
import com.starwars.presentation.FlowState.Companion.failure
import com.starwars.presentation.FlowState.Companion.loading
import com.starwars.presentation.FlowState.Companion.success
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpeciesViewModel(
    private val contextProvider: ThreadContextProvider,
    private val interactor: SpecieInteractor
) : PaginationViewModel() {
    private val flowState = MutableLiveData<FlowState<MutableList<Specie>>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun requestAllSpecies(){
        if(loading) return
        loading = true
        flowState.value = loading()
        viewModelScope.launch(contextProvider.io) {
            val response = interactor.getSpecies(currentPage)
            withContext(contextProvider.ui){
                when(response){
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

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun neutral(){
        flowState.value = FlowState.neutral()
        viewModelScope.coroutineContext.cancelChildren()
    }


    override fun refresh() {
        super.refresh()
        requestAllSpecies()
    }

    fun getMainFlow(): LiveData<FlowState<MutableList<Specie>>> = flowState
}