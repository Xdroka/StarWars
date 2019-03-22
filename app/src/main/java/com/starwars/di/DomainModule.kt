package com.starwars.di

import com.starwars.domain.interactor.SpecieInteractor
import com.starwars.domain.interactor.SpecieInteractorImpl
import org.koin.dsl.module.module

val domainModule = module{
    factory { SpecieInteractorImpl(repository = get()) as SpecieInteractor }
}