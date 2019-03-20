package com.starwars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.starwars.presentation.SpeciesViewModel
import com.starwars.R
import com.starwars.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class SpeciesFragment : BaseFragment() {

    private val viewModel by viewModel<SpeciesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycleObserver = viewModel
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_species, container, false)
    }

    override fun addListeners() {

    }

}
