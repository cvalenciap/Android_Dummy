package com.cesarynga.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val moviesViewModel: MoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val swipeRefresh = findViewById<SwipeRefreshLayout>(R.id.swipeRefresh)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = MovieAdapter()

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        moviesViewModel.movies.observe(this, Observer {
            adapter.setMovies(it)
        })

        moviesViewModel.loading.observe(this, {
            swipeRefresh.isRefreshing = it
        })

        swipeRefresh.setOnRefreshListener {
            moviesViewModel.loadMovies(true)
        }

        moviesViewModel.loadMovies()
    }
}