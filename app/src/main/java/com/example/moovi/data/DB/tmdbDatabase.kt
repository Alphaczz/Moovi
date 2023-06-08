package com.example.moovi.data.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moovi.data.model.Movie
@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class tmdbDatabase : RoomDatabase()
{
    abstract fun movieDao():movieDao
}