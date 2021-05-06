package com.cesarynga.myapplication.data.remote

import android.util.Log
import com.cesarynga.myapplication.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class MovieRemoteDataSource(private val movieService: MovieService) {

    suspend fun getMovies(): List<Movie> = withContext(Dispatchers.IO) {
        try {
            val response = movieService.getMovies()
            if (response.isSuccessful) {
                val movies = response.body()
                if (movies != null) {
                    return@withContext movies
                }
            }
            Log.e("MovieRemote", "Error getting movies")
            return@withContext emptyList()
        }catch (e: Exception) {
            Log.e("MovieRemote", "Error getting movies", e)
            return@withContext emptyList()
        }
    }
}