package com.starwars.di

import com.starwars.data.remote.service.SpeciesWebService
import com.starwars.data.remote.service.createWebService
import org.koin.dsl.module.module

val webServiceModule = module {
    single { createWebService<SpeciesWebService>()}
}