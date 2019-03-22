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
        if(flowState.value?.status == Status.LOADING) return

        flowState.postValue(loading())
        viewModelScope.launch(contextProvider.io) {
            val response = interactor.getSpecies(currentPage)
            withContext(contextProvider.ui){
                when(response){
                    is Response.Failure -> flowState.postValue(failure(response.throwable))
                    is Response.Success -> flowState.postValue(success(response.data))
                }
            }
        }
    }

    override fun next() {
        currentStatus = flowState.value?.status
        super.next()
        requestAllSpecies()
    }

    override fun refresh() {
        currentStatus = flowState.value?.status
        super.refresh()
    }

    fun getMainFlow(): LiveData<FlowState<MutableList<Specie>>> = flowState
}