package com.example.effectivemobiletest.di

import com.example.effectivemobiletest.data.repository.CoursesRepositoryImpl
import com.example.effectivemobiletest.data.repository.GreetingRepositoryImpl
import com.example.effectivemobiletest.data.repository.favorite.FavoritesRepositoryImpl
import com.example.effectivemobiletest.domain.repository.CoursesRepository
import com.example.effectivemobiletest.domain.repository.FavoritesRepository
import com.example.effectivemobiletest.domain.repository.GreetingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGreetingRepository(
        impl: GreetingRepositoryImpl,
    ): GreetingRepository

    @Binds
    @Singleton
    abstract fun bindCoursesRepository(
        impl: CoursesRepositoryImpl,
    ): CoursesRepository

    @Binds
    @Singleton
    abstract fun bindFavoritesRepository(
        impl: FavoritesRepositoryImpl,
    ): FavoritesRepository
}
