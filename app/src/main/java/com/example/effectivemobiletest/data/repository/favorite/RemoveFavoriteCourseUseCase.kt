package com.example.effectivemobiletest.data.repository.favorite

import com.example.effectivemobiletest.domain.repository.FavoritesRepository
import javax.inject.Inject

class RemoveFavoriteCourseUseCase @Inject constructor(
    private val repository: FavoritesRepository,
) {
    suspend operator fun invoke(courseId: Int) {
        repository.removeFavorite(courseId)
    }
}
