package com.starwars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.starwars.R
import com.starwars.base.BaseFragment
import com.starwars.domain.model.Film
import com.starwars.presentation.FilmsViewModel
import com.starwars.presentation.FlowState
import com.starwars.presentation.Status.*
import com.starwars.ui.adapters.FilmListAdapter
import com.starwars.ui.extensions.*
import kotlinx.android.synthetic.main.fragment_films.*
import org.koin.android.viewmodel.ext.android.viewModel

class FilmsFragment : BaseFragment() {
    private val viewModel: FilmsViewModel by viewModel()
    private val filmAdapter = makeAdapter()
    private val navController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycleObserver = viewModel
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_films, container, false)


    override fun addListeners() {
        refreshFilmsLayout.setOnRefreshListener {
            filmAdapter.filmList.clear()
            filmAdapter.notifyDataSetChanged()
            viewModel.requestFilms()
        }
        filmListRecyclerView.apply {
            adapter = filmAdapter
            activity?.let { addDefaultDecorator(it) }
            createScrollListener(
                conditionFunction = {lastVisibleItem ->
                    lastVisibleItem == filmAdapter.filmList.size && !viewModel.noMoreResults && !viewModel.loading
                },
                function = { viewModel.requestFilms() }
            )
        }
    }

    override fun addEvents() {
        viewModel.getMainFlow().observe(this, Observer { handleWithMainFlow(it) })
    }

    private fun handleWithMainFlow(flowState: FlowState<MutableList<Film>>?){
        when(flowState?.status){
            LOADING -> refreshFilmsLayout.loading()
            ERROR -> {
                refreshFilmsLayout.stopLoading()
                handleErrors(flowState.throwable)
            }
            SUCCESS -> {
                refreshFilmsLayout.stopLoading()
                flowState.data?.let {
                    filmAdapter.filmList.addAll(it)
                    filmAdapter.notifyItemRangeChanged(
                        filmAdapter.filmList.size - it.size, filmAdapter.filmList.size
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

    private fun makeAdapter() = FilmListAdapter{
        val action = FilmsFragmentDirections.actionFilmsFragmentToFilmDetailsFragment(it.toJson())
        navController.navigate(action)
    }
}
