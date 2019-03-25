package com.starwars.di

import com.starwars.domain.interactor.CharacterInteractor
import com.starwars.domain.interactor.CharacterInteractorImpl
import com.starwars.domain.interactor.SpecieInteractor
import com.starwars.domain.interactor.SpecieInteractorImpl
import org.koin.dsl.module.module

val domainModule = module{
    factory { SpecieInteractorImpl(repository = get()) as SpecieInteractor }

    factory { CharacterInteractorImpl(characterRepository = get()) as CharacterInteractor }
}