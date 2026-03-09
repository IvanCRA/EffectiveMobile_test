package com.example.effectivemobiletest.presentation.home.model

import com.example.effectivemobiletest.domain.model.Course

data class HomeUiState(
    val isLoading: Boolean = false,
    val courses: List<Course> = emptyList(),
    val error: String? = null
)
