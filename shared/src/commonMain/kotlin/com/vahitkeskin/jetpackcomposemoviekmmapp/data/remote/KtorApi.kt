package com.vahitkeskin.jetpackcomposemoviekmmapp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//API_KEY -> https://www.themoviedb.org/settings/api
//https://api.themoviedb.org/3/movie/603692?api_key=API_KEY
//https://api.themoviedb.org/3/movie/popular?page=1&api_key=API_KEY


private const val BASE_URL = "https://api.themoviedb.org/"
private const val API_KE = "API_KEY"

internal abstract class KtorApi {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(BASE_URL)
            path("3", path)
            parameter("api_key", API_KE)
        }
    }
}