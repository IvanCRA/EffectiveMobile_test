package com.example.effectivemobiletest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.effectivemobiletest.data.local.entity.FavoriteCourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM favorite_courses")
    fun observeFavorites(): Flow<List<FavoriteCourseEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_courses WHERE id = :courseId)")
    suspend fun isFavorite(courseId: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(course: FavoriteCourseEntity)

    @Query("DELETE FROM favorite_courses WHERE id = :courseId")
    suspend fun deleteFavorite(courseId: Int)
}
