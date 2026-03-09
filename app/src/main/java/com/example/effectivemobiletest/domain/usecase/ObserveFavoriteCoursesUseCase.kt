package com.example.effectivemobiletest.domain.usecase

import com.example.effectivemobiletest.domain.repository.FavoritesRepository
import javax.inject.Inject

class ObserveFavoriteCoursesUseCase @Inject constructor(
    private val repository: FavoritesRepository,
) {
    operator fun invoke() = repository.observeFavorites()
}
