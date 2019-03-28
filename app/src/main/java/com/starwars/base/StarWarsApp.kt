package com.starwars.base

import android.app.Application
import com.starwars.di.*
import org.koin.android.ext.android.startKoin
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

class StarWarsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(androidModule, presentationModule, domainModule ,dataModule, webServiceModule)
        )
        Fabric.with(this, Crashlytics())
    }
}