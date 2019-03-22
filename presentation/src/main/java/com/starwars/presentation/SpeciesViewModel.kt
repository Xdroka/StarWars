package com.starwars.presentation

import androidx.lifecycle.*
import com.starwars.data.remote.Response
import com.starwars.domain.interactor.SpecieInteractor
import com.starwars.domain.model.Specie
import com.starwars.presentation.FlowState.Companion.failure
import com.starwars.presentation.FlowState.Companion.loading
import com.starwars.presentation.FlowState.Companion.success
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpeciesViewModel(
    private val contextProvider: ThreadContextProvider,
    private val interactor: SpecieInteractor
) : PaginationViewModel() {
    private val flowState = MutableLiveData<FlowState<MutableList<Specie>>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun requestAllSpecies(){
        if(currentStatus == Status.LOADING) return
        flowState.postValue(loading())
        currentStatus = Status.LOADING
        viewModelScope.launch(contextProvider.io) {
            val response = interactor.getSpecies(currentPage)
            withContext(contextProvider.ui){
                when(response){
                    is Response.Failure -> {
                        currentStatus = Status.ERROR
                        flowState.postValue(failure(response.throwable))
                    }
                    is Response.Success -> {
                        currentStatus = Status.SUCCESS
                        if(response.data.isEmpty()) noMoreResults = true
                        flowState.postValue(success(response.data))
                    }
                }
            }
        }
    }

    override fun next() {
        super.next()
        requestAllSpecies()
    }

    override fun refresh() {
        super.refresh()
        requestAllSpecies()
    }

    fun getMainFlow(): LiveData<FlowState<MutableList<Specie>>> = flowState
}