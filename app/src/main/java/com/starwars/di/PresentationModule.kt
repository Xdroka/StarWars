package com.starwars.di

import com.starwars.presentation.BaseViewModel
import com.starwars.presentation.SpeciesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {
    viewModel { SpeciesViewModel(contextProvider = get()) }

    viewModel { BaseViewModel(provider = get()) }
}