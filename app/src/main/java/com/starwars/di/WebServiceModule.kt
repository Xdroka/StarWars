package com.starwars.di

import com.starwars.data.remote.service.*
import org.koin.dsl.module.module

val webServiceModule = module {
    single { createWebService<SpeciesWebService>() }
    single { createWebService<CharactersWebService>() }
    single { createWebService<FilmWebService>() }
    single { createWebService<PlanetWebService>() }
}