package com.example.effectivemobiletest.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effectivemobiletest.data.repository.favorite.AddFavoriteCourseUseCase
import com.example.effectivemobiletest.data.repository.favorite.RemoveFavoriteCourseUseCase
import com.example.effectivemobiletest.domain.model.Course
import com.example.effectivemobiletest.domain.usecase.GetCoursesUseCase
import com.example.effectivemobiletest.domain.usecase.ObserveFavoriteCoursesUseCase
import com.example.effectivemobiletest.presentation.home.model.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase,
    private val observeFavoriteCoursesUseCase: ObserveFavoriteCoursesUseCase,
    private val addFavoriteCourseUseCase: AddFavoriteCourseUseCase,
    private val removeFavoriteCourseUseCase: RemoveFavoriteCourseUseCase,
) : ViewModel() {
    private val apiCourses = MutableStateFlow<List<Course>>(emptyList())
    private val isSortedByDateDesc = MutableStateFlow(false)

    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        loadCourses()
        observeCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            runCatching {
                getCoursesUseCase()
            }.onSuccess { courses ->
                apiCourses.value = courses
            }.onFailure { throwable ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = throwable.message ?: "Unknown error",
                    )
                }
            }
        }
    }

    private fun observeCourses() {
        viewModelScope.launch {
            combine(
                apiCourses,
                observeFavoriteCoursesUseCase(),
                isSortedByDateDesc,
            ) { remoteCourses, favoriteCourses, sortedByDateDesc ->

                val favoriteIds = favoriteCourses.map { it.id }.toSet()

                val mergedCourses =
                    remoteCourses.map { course ->
                        course.copy(hasLike = course.id in favoriteIds)
                    }

                val finalCourses =
                    if (sortedByDateDesc) {
                        mergedCourses.sortedByDescending { parsePublishDate(it.publishDate) }
                    } else {
                        mergedCourses
                    }

                finalCourses
            }.collect { courses ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        courses = courses,
                        error = null,
                        isSortedByDateDesc = isSortedByDateDesc.value,
                    )
                }
            }
        }
    }

    fun onSortByDateClick() {
        isSortedByDateDesc.value = true
    }

    fun onFavoriteClick(course: Course) {
        viewModelScope.launch {
            if (course.hasLike) {
                removeFavoriteCourseUseCase(course.id)
            } else {
                addFavoriteCourseUseCase(course)
            }
        }
    }

    private fun parsePublishDate(date: String): LocalDate {
        return LocalDate.parse(date)
    }
}
