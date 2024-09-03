package com.vahitkeskin.jetpackcomposemoviekmmapp.android.di

import com.vahitkeskin.jetpackcomposemoviekmmapp.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
}