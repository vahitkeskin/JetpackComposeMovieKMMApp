package com.vahitkeskin.jetpackcomposemoviekmmapp.util

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher {
    val io: CoroutineDispatcher
}

internal expect fun provideDispatcher() : Dispatcher

//expect vs actual