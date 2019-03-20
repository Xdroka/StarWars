package com.starwars.di

import com.starwars.presentation.ThreadContextProvider
import org.koin.dsl.module.module

val androidModule = module {
    single { this }
    single { ThreadContextProvider() }
}