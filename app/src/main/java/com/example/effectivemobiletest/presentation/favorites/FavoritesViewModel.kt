package com.example.effectivemobiletest.presentation.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.effectivemobiletest.domain.usecase.ObserveFavoriteCoursesUseCase
import com.example.effectivemobiletest.presentation.favorites.model.FavoritesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val observeFavoriteCoursesUseCase: ObserveFavoriteCoursesUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(FavoritesUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            observeFavoriteCoursesUseCase().collect { courses ->
                _state.update {
                    it.copy(
                        courses = courses,
                        isLoading = false,
                    )
                }
            }
        }
    }
}
