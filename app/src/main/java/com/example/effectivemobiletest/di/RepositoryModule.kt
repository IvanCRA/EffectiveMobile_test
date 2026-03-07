package com.example.effectivemobiletest.di

import com.example.effectivemobiletest.data.repository.GreetingRepositoryImpl
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
}
