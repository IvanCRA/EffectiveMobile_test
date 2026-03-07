package com.example.effectivemobiletest.presentation.home

import androidx.lifecycle.ViewModel
import com.example.effectivemobiletest.domain.usecase.GetGreetingUseCase
import com.example.effectivemobiletest.presentation.home.model.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getGreetingUseCase: GetGreetingUseCase,
) : ViewModel() {
    private val _uiState =
        MutableStateFlow(
            HomeUiState(
                greeting = getGreetingUseCase(),
            ),
        )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
}
