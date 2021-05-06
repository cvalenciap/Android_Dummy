package com.cesarynga.myapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cesarynga.myapplication.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    suspend fun getMovies(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(vararg movie: Movie)

}