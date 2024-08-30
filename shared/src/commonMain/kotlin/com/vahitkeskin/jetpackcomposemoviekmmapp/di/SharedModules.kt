package com.vahitkeskin.jetpackcomposemoviekmmapp.di

import com.vahitkeskin.jetpackcomposemoviekmmapp.data.remote.MovieService
import com.vahitkeskin.jetpackcomposemoviekmmapp.data.remote.RemoteDataSource
import com.vahitkeskin.jetpackcomposemoviekmmapp.data.repository.MovieRepositoryImpl
import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.repository.MovieRepository
import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.usecase.GetMovieUseCase
import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.usecase.GetMoviesUseCase
import com.vahitkeskin.jetpackcomposemoviekmmapp.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory {
        RemoteDataSource(get(), get())
    }
    factory {
        MovieService()
    }
}

private val utilModule = module {
    factory {
        provideDispatcher()
    }
}

private val domainModule = module {
    factory {
        GetMovieUseCase()
    }
    factory {
        GetMoviesUseCase()
    }
    single<MovieRepository> {
        MovieRepositoryImpl(get())
    }
}

private val sharedModules = listOf(dataModule, utilModule, domainModule)

fun getSharedModules() = sharedModules