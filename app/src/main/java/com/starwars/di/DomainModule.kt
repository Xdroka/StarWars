package com.starwars.di

import com.starwars.domain.interactor.*
import org.koin.dsl.module.module

val domainModule = module{
    factory { SpecieInteractorImpl(repository = get()) as SpecieInteractor }

    factory { CharacterInteractorImpl(characterRepository = get()) as CharacterInteractor }

    factory { FilmsInteractorImpl(filmRepository = get()) as FilmsInteractor }
}