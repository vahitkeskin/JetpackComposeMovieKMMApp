package com.vahitkeskin.jetpackcomposemoviekmmapp.domain.usecase

import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.model.Movie
import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMovieUseCase : KoinComponent {
    private val repository: MovieRepository by inject()

    @Throws(Exception::class) //try catch
    suspend operator fun invoke(movieId: Int): Movie {
        return repository.getMovie(movieId = movieId)
    }
}