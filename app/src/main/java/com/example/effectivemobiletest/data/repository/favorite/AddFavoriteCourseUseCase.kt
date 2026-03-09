package com.example.effectivemobiletest.data.repository.favorite

import com.example.effectivemobiletest.domain.model.Course
import com.example.effectivemobiletest.domain.repository.FavoritesRepository
import javax.inject.Inject

class AddFavoriteCourseUseCase @Inject constructor(
    private val repository: FavoritesRepository,
) {
    suspend operator fun invoke(course: Course) {
        repository.addFavorite(course)
    }
}
