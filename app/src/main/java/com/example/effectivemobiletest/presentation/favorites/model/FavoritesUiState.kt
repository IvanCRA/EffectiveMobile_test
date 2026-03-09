package com.example.effectivemobiletest.presentation.favorites.model

import com.example.effectivemobiletest.domain.model.Course

data class FavoritesUiState(
    val courses: List<Course> = emptyList(),
    val isLoading: Boolean = true,
)
