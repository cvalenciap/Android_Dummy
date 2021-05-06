package com.cesarynga.myapplication.di

import androidx.room.Room
import com.cesarynga.myapplication.MoviesViewModel
import com.cesarynga.myapplication.data.MovieRepository
import com.cesarynga.myapplication.data.local.MovieDatabase
import com.cesarynga.myapplication.data.local.MovieLocalDataSource
import com.cesarynga.myapplication.data.remote.MovieRemoteDataSource
import com.cesarynga.myapplication.data.remote.MovieService
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val movieModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java,
            "movies.db"
        ).build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.backendless.com/ACE797F5-67DB-A92F-FFCF-1C52D55B7500/B3C30BCD-F2B7-9ED6-FF64-B99EA5D1C400/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(MovieService::class.java)
    }

    single {
        MovieRemoteDataSource(get())
    }

    single {
        MovieLocalDataSource(get(MovieDatabase::class).movieDao())
    }

    single {
        MovieRepository(get(), get())
    }

    viewModel {
        MoviesViewModel(get())
    }
}