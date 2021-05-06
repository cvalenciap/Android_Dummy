package com.cesarynga.myapplication.data

import com.cesarynga.myapplication.Movie
import com.cesarynga.myapplication.data.local.MovieLocalDataSource
import com.cesarynga.myapplication.data.remote.MovieRemoteDataSource

class MovieRepository(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) {

    suspend fun getMovies(forceUpdate: Boolean): List<Movie> {
        if(forceUpdate) {
            return getMoviesRemote()
        } else {
            val moviesLocal = movieLocalDataSource.getMovies()
            if (moviesLocal.isNullOrEmpty()) {
                return getMoviesRemote()
            }
            return moviesLocal
        }
    }

    private suspend fun getMoviesRemote(): List<Movie> {
        val moviesRemote = movieRemoteDataSource.getMovies()
        movieLocalDataSource.insertMovies(moviesRemote)
        return moviesRemote
    }
}