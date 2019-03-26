package com.starwars.di

import com.starwars.presentation.CharactersViewModel
import com.starwars.presentation.FilmsViewModel
import com.starwars.presentation.PaginationViewModel
import com.starwars.presentation.SpeciesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val presentationModule = module {
    viewModel { SpeciesViewModel(contextProvider = get(), interactor = get()) }

    viewModel { PaginationViewModel() }

    viewModel { CharactersViewModel(contextProvider = get(), interactor = get()) }

    viewModel { FilmsViewModel(contextProvider = get(), interactor = get()) }
}