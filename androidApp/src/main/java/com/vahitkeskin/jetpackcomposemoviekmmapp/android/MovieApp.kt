package com.vahitkeskin.jetpackcomposemoviekmmapp.android

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vahitkeskin.jetpackcomposemoviekmmapp.android.common.Detail
import com.vahitkeskin.jetpackcomposemoviekmmapp.android.common.Home
import com.vahitkeskin.jetpackcomposemoviekmmapp.android.common.MovieAppBar
import com.vahitkeskin.jetpackcomposemoviekmmapp.android.common.movieDestination
import com.vahitkeskin.jetpackcomposemoviekmmapp.android.detail.DetailScreen
import com.vahitkeskin.jetpackcomposemoviekmmapp.android.detail.DetailViewModel
import com.vahitkeskin.jetpackcomposemoviekmmapp.android.home.HomeScreen
import com.vahitkeskin.jetpackcomposemoviekmmapp.android.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MovieApp() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = movieDestination.find {
        backStackEntry?.destination?.route == it.route || backStackEntry?.destination?.route == it.routeWithArgs
    } ?: Home
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieAppBar(
                canNavigateBack = navController.previousBackStackEntry != null, //Arkatarafı beklet
                currentScreen = currentScreen
            ) {
                navController.navigateUp()
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = Home.route
        ) {
            composable(Home.routeWithArgs) {
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(uiState = homeViewModel.uiState, loadNextMovies = {
                    homeViewModel.loadMovies(forceReload = it)
                }, navigateToDetail = {
                    navController.navigate(
                        "${Detail.route}/${it.id}"
                    )
                })
            }

            composable(Detail.routeWithArgs, arguments = Detail.arguments) {
                val movieId = it.arguments?.getInt("movieId") ?: 0
                val detailViewModel: DetailViewModel = koinViewModel(
                    parameters = {
                        parametersOf(movieId)
                    }
                )
                DetailScreen(uiState = detailViewModel.uiState)
            }
        }
    }

}