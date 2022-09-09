package com.fzellner.pokedex

import android.app.Application
import com.fzellner.pokedex.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokedexApplication: Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokedexApplication)
            modules(Modules.modules())
        }
    }
}