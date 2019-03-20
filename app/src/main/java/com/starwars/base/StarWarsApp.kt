package com.starwars.base

import android.app.Application
import com.starwars.di.androidModule
import com.starwars.di.dataModule
import com.starwars.di.presentationModule
import com.starwars.di.webServiceModule
import org.koin.android.ext.android.startKoin

class StarWarsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(androidModule, presentationModule, dataModule, webServiceModule))
    }
}