package com.cesarynga.myapplication.data.local

import com.cesarynga.myapplication.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieLocalDataSource(private val movieDao: MovieDao) {

    suspend fun getMovies(): List<Movie> = withContext(Dispatchers.IO) {
        movieDao.getMovies()
    }

    suspend fun insertMovies(movies: List<Movie>) {
        movieDao.insertMovies(*(movies.toTypedArray()))
    }
}