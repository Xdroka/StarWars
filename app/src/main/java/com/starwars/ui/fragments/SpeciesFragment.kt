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
import com.starwars.ui.extensions.*
import kotlinx.android.synthetic.main.fragment_species.*
import org.koin.android.viewmodel.ext.android.viewModel

class SpeciesFragment : BaseFragment() {
    private val viewModel by viewModel<SpeciesViewModel>()
    private val speciesAdapter = makeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycleObserver = viewModel
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_species, container, false)

    override fun addListeners() {
        specieListFragmentRv.apply {
            adapter = speciesAdapter
            activity?.let { addDefaultDecorator(it) }
            createScrollListener(
                conditionFunction = { lastVisibleItem ->
                    lastVisibleItem == speciesAdapter.specieList.size && !viewModel.noMoreResults && !viewModel.loading
                },
                function = {
                    viewModel.requestAllSpecies()
                })
        }
        swipeRefreshSpecieList.setOnRefreshListener {
            speciesAdapter.specieList.clear()
            speciesAdapter.notifyDataSetChanged()
            viewModel.refresh()
        }
    }

    override fun addEvents() = viewModel.getMainFlow().observe(this, Observer { handleWithMainFlow(it) })

    private fun handleWithMainFlow(flowState: FlowState<MutableList<Specie>>?) {
        when (flowState?.status) {
            LOADING -> swipeRefreshSpecieList.loading()
            ERROR -> {
                swipeRefreshSpecieList.stopLoading()
                handleErrors(flowState.throwable)
            }
            SUCCESS -> {
                swipeRefreshSpecieList.stopLoading()
                flowState.data?.let {
                    speciesAdapter.specieList.addAll(it)
                    speciesAdapter.notifyItemRangeChanged(
                        speciesAdapter.specieList.size - it.size,
                        speciesAdapter.specieList.size
                    )
                }
            }
            else -> {}
        }
    }

    private fun makeAdapter() = SpecieListAdapter { specie ->
        val actions = SpeciesFragmentDirections.actionEspeciesFragmentToSpecieDetailsFragment(specie.toJson())
        navController.navigate(actions)
    }

    override fun onStop() {
        viewModel.getMainFlow().removeObservers(this)
        super.onStop()
    }

}