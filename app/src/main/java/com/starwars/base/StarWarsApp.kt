package com.starwars.base

import android.app.Application
import com.starwars.di.*
import org.koin.android.ext.android.startKoin

class StarWarsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(androidModule, presentationModule, domainModule ,dataModule, webServiceModule)
        )
    }
}