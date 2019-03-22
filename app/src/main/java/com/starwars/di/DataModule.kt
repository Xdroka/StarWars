package com.starwars.di

import com.starwars.data.remote.repository.SpeciesRepository
import com.starwars.data.remote.repository.SpeciesRepositoryImpl
import org.koin.dsl.module.module

val dataModule = module {

    factory { SpeciesRepositoryImpl(service = get()) as SpeciesRepository }
}