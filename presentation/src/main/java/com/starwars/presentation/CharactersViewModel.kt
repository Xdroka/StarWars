package com.starwars.presentation

import androidx.lifecycle.*
import com.starwars.data.remote.Response
import com.starwars.domain.interactor.CharacterInteractor
import com.starwars.domain.model.Character
import com.starwars.presentation.FlowState.Companion.failure
import com.starwars.presentation.FlowState.Companion.loading
import com.starwars.presentation.FlowState.Companion.success
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val contextProvider: ThreadContextProvider,
    private val interactor: CharacterInteractor
): PaginationViewModel() {
    private val flowState = MutableLiveData<FlowState<MutableList<Character>>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun requestCharacterList(){
        if(loading) return
        loading = true
        flowState.value = loading()
        viewModelScope.launch(contextProvider.io){
            val response = interactor.getCharacters(currentPage)
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

    override fun refresh() {
        super.refresh()
        requestCharacterList()
    }

    @Suppress("unused")
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun neutral(){
        if(loading) viewModelScope.coroutineContext.cancelChildren()
        loading = false
        flowState.value = FlowState.neutral()
    }

    fun getMainFlow(): LiveData<FlowState<MutableList<Character>>> = flowState
}