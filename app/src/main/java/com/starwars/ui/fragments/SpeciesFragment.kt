package com.starwars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.starwars.R
import com.starwars.base.BaseFragment
import com.starwars.domain.model.Specie
import com.starwars.presentation.FlowState
import com.starwars.presentation.SpeciesViewModel
import com.starwars.presentation.Status.*
import com.starwars.ui.adapters.SpecieListAdapter
import com.starwars.ui.extensions.loading
import com.starwars.ui.extensions.createScrollListener
import com.starwars.ui.extensions.stopLoading
import kotlinx.android.synthetic.main.fragment_species.*
import org.koin.android.viewmodel.ext.android.viewModel

class SpeciesFragment : BaseFragment() {
    private val viewModel by viewModel<SpeciesViewModel>()
    private val adapter = makeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycleObserver = viewModel
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_species, container, false)
    }

    override fun addListeners() {
        specieListFragmentRv.createScrollListener(
            conditionFunction = {lastVisibleItem ->
                lastVisibleItem == adapter.specieList.size && !viewModel.noMoreResults
                        && viewModel.getMainFlow().value?.status != LOADING
            },
            function ={
                
            })
    }

    override fun addEvents() {
        viewModel.getMainFlow().observe(this, Observer { handleWithMainFlow(it) })
    }

    private fun handleWithMainFlow(flowState: FlowState<MutableList<Specie>>?) {
        when (flowState?.status) {
            LOADING -> swipeRefreshSpecieList.loading()
            ERROR -> {
                swipeRefreshSpecieList.stopLoading()
                handleErrors(flowState.throwable)
            }
            SUCCESS -> {
                swipeRefreshSpecieList.stopLoading()
                flowState.data?.let { adapter.specieList.addAll(it) }
            }
        }
    }

    @Suppress("UNUSED_ANONYMOUS_PARAMETER")
    private fun makeAdapter() = SpecieListAdapter{ specie ->

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.getMainFlow().removeObservers(this)
    }

}
