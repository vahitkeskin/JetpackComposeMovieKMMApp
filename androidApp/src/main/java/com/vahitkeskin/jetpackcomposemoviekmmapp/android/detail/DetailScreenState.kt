package com.vahitkeskin.jetpackcomposemoviekmmapp.android.detail

import com.vahitkeskin.jetpackcomposemoviekmmapp.domain.model.Movie

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: Movie? = null,
    var errorMessage: String? = null
)