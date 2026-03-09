package com.example.effectivemobiletest.data.repository.favorite

import com.example.effectivemobiletest.data.local.FavoritesDao
import com.example.effectivemobiletest.data.local.mapper.toDomain
import com.example.effectivemobiletest.data.local.mapper.toFavoriteEntity
import com.example.effectivemobiletest.domain.model.Course
import com.example.effectivemobiletest.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val favoritesDao: FavoritesDao,
) : FavoritesRepository {
    override fun observeFavorites(): Flow<List<Course>> {
        return favoritesDao.observeFavorites().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun addFavorite(course: Course) {
        favoritesDao.insertFavorite(course.toFavoriteEntity())
    }

    override suspend fun removeFavorite(courseId: Int) {
        favoritesDao.deleteFavorite(courseId)
    }

    override suspend fun isFavorite(courseId: Int): Boolean {
        return favoritesDao.isFavorite(courseId)
    }
}
