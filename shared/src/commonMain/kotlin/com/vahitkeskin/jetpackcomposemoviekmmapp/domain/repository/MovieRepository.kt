package com.vahitkeskin.jetpackcomposemoviekmmapp.domain.repository

import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.model.Movie

internal interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie
}