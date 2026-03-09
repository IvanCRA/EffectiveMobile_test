package com.example.effectivemobiletest.di

import android.content.Context
import androidx.room.Room
import com.example.effectivemobiletest.data.local.FavoritesDao
import com.example.effectivemobiletest.data.local.FavoritesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideFavoritesDatabase(
        @ApplicationContext context: Context,
    ): FavoritesDatabase {
        return Room.databaseBuilder(
            context,
            FavoritesDatabase::class.java,
            "favorites_database",
        ).build()
    }

    @Provides
    @Singleton
    fun provideFavoritesDao(
        database: FavoritesDatabase,
    ): FavoritesDao {
        return database.favoritesDao()
    }
}
