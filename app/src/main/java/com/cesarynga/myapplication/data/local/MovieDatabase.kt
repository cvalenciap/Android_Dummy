package com.cesarynga.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cesarynga.myapplication.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase(){
    abstract fun movieDao(): MovieDao
}