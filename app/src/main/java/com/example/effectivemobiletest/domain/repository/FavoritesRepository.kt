package com.example.effectivemobiletest.domain.repository

import com.example.effectivemobiletest.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun observeFavorites(): Flow<List<Course>>

    suspend fun addFavorite(course: Course)

    suspend fun removeFavorite(courseId: Int)

    suspend fun isFavorite(courseId: Int): Boolean
}
