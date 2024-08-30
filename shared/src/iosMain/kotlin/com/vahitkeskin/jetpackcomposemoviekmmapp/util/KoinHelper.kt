package com.vahitkeskin.jetpackcomposemoviekmmapp.util

import com.vahitkeskin.jetpackcomposemoviekmmapp.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}