package com.example.effectivemobiletest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.effectivemobiletest.data.local.entity.FavoriteCourseEntity

@Database(
    entities = [FavoriteCourseEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class FavoritesDatabase : RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao
}
