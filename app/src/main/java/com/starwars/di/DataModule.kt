package com.starwars.di

import com.starwars.data.remote.repository.*
import org.koin.dsl.module.module

val dataModule = module {

    factory { SpeciesRepositoryImpl(specieService = get()) as SpeciesRepository }

    factory { CharacterRespositoryImpl(characterService = get()) as CharacterRepository }

    factory { FilmsRepositoryImpl(filmService = get()) as FilmsRepository }

    factory { PlanetRepositoryImpl(planetService = get()) as PlanetRepository }
}