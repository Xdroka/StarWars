package com.starwars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.starwars.R
import com.starwars.base.BaseFragment
import com.starwars.domain.model.Specie
import com.starwars.presentation.FlowState
import com.starwars.presentation.SpeciesViewModel
import com.starwars.presentation.Status.*
import com.starwars.ui.adapters.SpecieListAdapter
import com.starwars.ui.extensions.createScrollListener
import com.starwars.ui.extensions.loading
import com.starwars.ui.extensions.stopLoading
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
            activity?.let { addItemDecoration(DividerItemDecoration(it, it.requestedOrientation)) }
            createScrollListener(
                conditionFunction = { lastVisibleItem ->
                    lastVisibleItem == speciesAdapter.specieList.size && !viewModel.noMoreResults
                            && viewModel.getMainFlow().value?.status != LOADING
                },
                function = {
                    viewModel.next()
                })
        }
        swipeRefreshSpecieList.setOnRefreshListener {
            speciesAdapter.specieList.clear()
            speciesAdapter.notifyDataSetChanged()
            viewModel.refresh()
        }
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
                flowState.data?.let {
                    speciesAdapter.specieList.addAll(it)
                    speciesAdapter.notifyItemRangeChanged(
                        speciesAdapter.specieList.size - it.size,
                        speciesAdapter.specieList.size
                    )
                }
            }
        }
    }

    @Suppress("UNUSED_ANONYMOUS_PARAMETER")
    private fun makeAdapter() = SpecieListAdapter { specie ->

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.getMainFlow().removeObservers(this)
    }

}
