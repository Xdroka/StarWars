package com.starwars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.starwars.R
import com.starwars.base.BaseFragment
import com.starwars.domain.model.Character
import com.starwars.presentation.CharactersViewModel
import com.starwars.presentation.FlowState
import com.starwars.presentation.Status.*
import com.starwars.ui.adapters.CharacterListAdapter
import com.starwars.ui.extensions.*
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.android.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment() {
    private val viewModel: CharactersViewModel by viewModel()
    private val charAdapter = makeAdapter()
    private val navController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycleObserver = viewModel
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_characters, container, false)

    override fun addListeners() {
        refreshCharactersLayout.setOnRefreshListener {
            charAdapter.charactersList.clear()
            charAdapter.notifyDataSetChanged()
            viewModel.refresh()
        }
        charactersListRecyclerView.apply{
            adapter = charAdapter
            activity?.let { addDefaultDecorator(it) }
            createScrollListener(
                conditionFunction = { lastVisibleItem ->
                    charAdapter.charactersList.size == lastVisibleItem && !viewModel.loading && !viewModel.noMoreResults
                },
                function = {
                    viewModel.requestCharacterList()
                }
            )
        }
    }

    override fun addEvents() = viewModel.getMainFlow().observe(this, Observer { handleWithMainFlow(it) })

    private fun handleWithMainFlow(flowState: FlowState<MutableList<Character>>?){
        when(flowState?.status){
            LOADING ->  refreshCharactersLayout.loading()
            ERROR -> {
                refreshCharactersLayout.stopLoading()
                handleErrors(flowState.throwable)
            }
            SUCCESS -> {
                refreshCharactersLayout.stopLoading()
                flowState.data?.let {
                    charAdapter.charactersList.addAll(it)
                    charAdapter.notifyItemRangeChanged(
                        charAdapter.charactersList.size - it.size, charAdapter.charactersList.size
                    )
                }
            }
            else -> {}
        }
    }

    override fun onStop() {
        viewModel.getMainFlow().removeObservers(this)
        super.onStop()
    }

    private fun makeAdapter() = CharacterListAdapter {character ->
        val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(character.toJson())
        navController.navigate(action)
    }
}
