package com.vahitkeskin.jetpackcomposemoviekmmapp.android.home

import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.model.Movie

data class HomeScreenState(
    val loading: Boolean = false,
    val refreshing: Boolean = false,
    val movies: List<Movie> = listOf(),
    val errorMessage: String? = null,
    val loadFinished: Boolean = false
)
