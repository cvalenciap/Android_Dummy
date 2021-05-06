package com.cesarynga.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarynga.myapplication.data.MovieRepository
import kotlinx.coroutines.launch

class MoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val _movies: MutableLiveData<List<Movie>> = MutableLiveData()
    val movies: LiveData<List<Movie>> = _movies

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    fun loadMovies(forceUpdate: Boolean = false) = viewModelScope.launch {
        _loading.value = true

        val movieList = movieRepository.getMovies(forceUpdate)

        _loading.value = false
        _movies.value = movieList
    }
}