package com.example.effectivemobiletest.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effectivemobiletest.domain.usecase.GetCoursesUseCase
import com.example.effectivemobiletest.presentation.home.model.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCoursesUseCase: GetCoursesUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(HomeUiState())
    val state = _state.asStateFlow()

    init {
        loadCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            runCatching {
                getCoursesUseCase()
            }.onSuccess { courses ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        courses = courses,
                    )
                }
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSortByDateClick() {
        _state.update { current ->
            val sortedCourses =
                current.courses.sortedByDescending { course ->
                    parsePublishDate(course.publishDate)
                }

            current.copy(
                courses = sortedCourses,
                isSortedByDateDesc = true,
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun parsePublishDate(date: String): LocalDate {
        return runCatching { LocalDate.parse(date) }
            .getOrDefault(LocalDate.MIN)
    }
}
