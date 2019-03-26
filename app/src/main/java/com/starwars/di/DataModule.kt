package com.starwars.di

import com.starwars.data.remote.repository.*
import org.koin.dsl.module.module

val dataModule = module {

    factory { SpeciesRepositoryImpl(service = get()) as SpeciesRepository }

    factory { CharacterRespositoryImpl(service = get()) as CharacterRepository }

    factory { FilmsRepositoryImpl(service = get()) as FilmsRepository }
}