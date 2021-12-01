package com.lifeplusbd.lifeplusbd.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lifeplusbd.lifeplusbd.data.GenreConverters
import com.lifeplusbd.lifeplusbd.model.Movie
import com.lifeplusbd.lifeplusbd.model.User

@Database(entities = [Movie::class, User::class], version = 1)
@TypeConverters(GenreConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun userDao(): UserDao
}