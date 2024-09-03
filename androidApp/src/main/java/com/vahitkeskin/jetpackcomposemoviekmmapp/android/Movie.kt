package com.vahitkeskin.jetpackcomposemoviekmmapp.android

import android.app.Application
import com.vahitkeskin.jetpackcomposemoviekmmapp.android.di.appModule
import com.vahitkeskin.jetpackcomposemoviekmmapp.di.getSharedModules
import org.koin.core.context.startKoin

class Movie: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}