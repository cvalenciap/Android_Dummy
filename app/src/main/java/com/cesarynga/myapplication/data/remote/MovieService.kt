package com.cesarynga.myapplication.data.remote

import com.cesarynga.myapplication.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("data/peliculas")
    suspend fun getMovies(): Response<List<Movie>>
}