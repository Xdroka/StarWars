package com.starwars.di

import com.e.presentation.BaseViewModel
import com.e.presentation.SpeciesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {
    viewModel { SpeciesViewModel() }

    viewModel { BaseViewModel() }
}