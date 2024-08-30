package com.vahitkeskin.jetpackcomposemoviekmmapp.data.repository

import com.vahitkeskin.jetpackcomposemoviekmmapp.data.remote.RemoteDataSource
import com.vahitkeskin.jetpackcomposemoviekmmapp.data.util.toMovie
import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.model.Movie
import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map {
            it.toMovie()
        }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}