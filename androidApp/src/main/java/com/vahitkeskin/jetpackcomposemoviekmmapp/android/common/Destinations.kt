package com.vahitkeskin.jetpackcomposemoviekmmapp.android.common

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Destinations {
    val title: String
    val route: String
    val routeWithArgs: String
}

object Home : Destinations {
    override val title: String
        get() = "Movies"
    override val route: String
        get() = "home"
    override val routeWithArgs: String
        get() = route
}

object Detail : Destinations {
    override val title: String
        get() = "Movie details"
    override val route: String
        get() = "details"
    override val routeWithArgs: String
        get() = "$route/{movieId}"

    val arguments = listOf(navArgument("movieId") {
        type = NavType.IntType
    })
}

val movieDestination = listOf(Home, Detail)